
document.addEventListener("DOMContentLoaded", function() {
    const form = document.querySelector("#QnAInsertUpdateForm");

    const no = document.querySelector("#noQnA");
    const writer = document.querySelector("#writerQnA");
    const passwd = document.querySelector("#passwdQnA");
    const editMode = Boolean(no && no.value);

    if (editMode){
        passwd.removeAttribute("required")
        writer.readOnly = true;
    }

    form.addEventListener("submit", (e) => {
        e.preventDefault();

        if (passwd.value.trim()==="" && editMode){
            passwd.disabled = true;
        }
        form.action = editMode? '/client/QnA/QnAUpdate':'/client/QnA/QnAWrite';
        form.submit();
    });
});