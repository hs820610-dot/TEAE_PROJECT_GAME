
const form = document.querySelector('#searchForm');









document.querySelectorAll(".page-item a").forEach(function (el) {
    el.addEventListener("click", function (e) {
        e.preventDefault();
        document.querySelector("#page").value = e.currentTarget.dataset.page;
        form.submit();
    });
});