document.addEventListener("DOMContentLoaded", function () {
    const menuItems = document.querySelectorAll(".sidebar ul li.has-submenu > a");

    menuItems.forEach(item => {
        item.addEventListener("click", function (e) {
            e.preventDefault();
            const parentLi = this.parentElement;
            const submenu = parentLi.querySelector("ul");
            const icon = this.querySelector(".submenu-icon");

            const isOpen = parentLi.classList.contains("open");

            document.querySelectorAll(".sidebar ul li.has-submenu").forEach(li => {
                if (li !== parentLi) {
                    li.classList.remove("open");
                    li.querySelector("ul").style.maxHeight = "0";
                    li.querySelector(".submenu-icon").textContent = "+";
                }
            });

            if (isOpen) {
                submenu.style.maxHeight = "0";
                icon.textContent = "+";
            } else {
                submenu.style.maxHeight = submenu.scrollHeight + "px";
                icon.textContent = "−";
            }

            parentLi.classList.toggle("open");
        });
    });
});