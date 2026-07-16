const writeForm = document.querySelector("#writeForm");
const writeTitle = document.querySelector("#writeTitle");
const writePasswd = document.querySelector("#writePasswd");
const writeContent = document.querySelector("#writeContent");
const writeWriter = document.querySelector("#writeWrite");

writeForm.addEventListener("submit", function (event) {


    if (writeTitle.value == "") {
        event.preventDefault();
        alert("제목을 입력하세요.");
        writeTitle.focus();
        return;
    }

    if (writeContent.value == "") {
        event.preventDefault();
        alert("내용을 입력하세요.");
        writeContent.focus();
        return;
    }

    if (writePasswd.value == "") {
        event.preventDefault();
        alert("비밀번호를 입력하세요.");
        writePasswd.focus();
        return;
    }

    if (writeWriter.value == "") {
        event.preventDefault();
        alert("작성자를 입력하세요.");
        writeWriter.focus();
        return;
    }
});
