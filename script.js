// scripts.js

function sortBooks(criteria) {
    let rows = document.querySelectorAll("table tbody tr");
    let arr = Array.from(rows);

    arr.sort((a, b) => {
        let valA = a.querySelector("." + criteria).innerText.toLowerCase();
        let valB = b.querySelector("." + criteria).innerText.toLowerCase();
        return valA.localeCompare(valB);
    });

    let tbody = document.querySelector("table tbody");
    tbody.innerHTML = "";
    arr.forEach(row => tbody.appendChild(row));
}

function searchBooks() {
    let input = document.getElementById("searchInput").value.toLowerCase();
    let rows = document.querySelectorAll("table tbody tr");

    rows.forEach(row => {
        let bookName = row.querySelector(".name").innerText.toLowerCase();
        if (bookName.includes(input)) {
            row.style.display = "";
        } else {
            row.style.display = "none";
        }
    });
}
