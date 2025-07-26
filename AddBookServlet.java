package com.bookstore.servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class AddBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int bookId = Integer.parseInt(request.getParameter("book_id"));
        String name = request.getParameter("name");
        String author = request.getParameter("author");
        double price = Double.parseDouble(request.getParameter("price"));

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore", "root", "Me@smonkey14");
            PreparedStatement ps = con.prepareStatement("INSERT INTO books VALUES (?, ?, ?, ?, 'available')");
            ps.setInt(1, bookId);
            ps.setString(2, name);
            ps.setString(3, author);
            ps.setDouble(4, price);

            int i = ps.executeUpdate();
            PrintWriter out = response.getWriter();
            if (i > 0) {
                out.println("<h2>Book Added Successfully</h2>");
            } else {
                out.println("<h2>Error adding book</h2>");
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
