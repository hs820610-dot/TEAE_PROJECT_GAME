const writeForm = document.querySelector("#writeForm");
const writeTitle = document.querySelector("#writeTitle");
const writePasswd = document.querySelector("#writePasswd");
const writeContent = document.querySelector("#writeContent");
const writeWriter = document.querySelector("#writeWrite");

writeForm.addEventListener("submit", function (event) {
    if (writeTitle == "") {
        alert("제목을 입력하세요.");
        writeTitle.focus();
        return;
    }

    if (writeContent == "") {
        alert("내용을 입력하세요.");
        writeContent.focus();
        return;
    }

    if (writePasswd == "") {
        alert("비밀번호를 입력하세요.");
        writePasswd.focus();
        return;
    }

    if (writeWriter == "") {
        alert("작성자를 입력하세요.");
        writeWriter.focus();
        return;
    }
});
