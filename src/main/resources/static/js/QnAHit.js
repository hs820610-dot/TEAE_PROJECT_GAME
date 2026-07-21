let actionType = "";
const QnARecommendButton = document.querySelector("#QnARecommendButton");
const QnADeleteButton = document.querySelector("#QnADeleteButton");
const QnAUpdateButton  = document.querySelector("#QnAUpdateButton");
const pwdArea = document.querySelector("#pwdArea");
const QnAPassword = document.querySelector("#QnAPassword");
const QnAPassWordButton = document.querySelector("#QnAPassWordButton");


const hidePwd = () => {
     if (pwdArea) pwdArea.classList.add("hide-default");
    QnAPassword.value = "";
    actionType = "";
}
const veiwPwd = () => {
    pwdArea.classList.remove("hide-default");
    QnAPassword.focus();
}

QnARecommendButton.addEventListener("click", async function(){
    const num = document.querySelector("#noQnA").value;
    try{
        const response = await fetch(`/client/QnA/QnAHit/${num}`, {
            method: "POST"
        });

        if (response.ok) {
            const reCount = await response.text();
            const recommend = document.querySelector("#recommendCount");
            recommend.textContent = reCount;
        } else{
            alert("failed");
        }
    }catch(err){
        console.log(err);
        alert("something went wrong!");
    }
});

QnADeleteButton.addEventListener("click", async function(){
   if (!confirm("이 질문글을 삭제합니까?")) {
       return;
   }
   const num = document.querySelector("#noQnA").value;

   try{
       const response = await fetch(`/client/QnA/QnADelete/${num}`, {
           method: "POST"
       });
       if (response.ok) {
           alert("삭제되었습니다.")
           location.href = "/client/QnA/QnAList";
       }else{
           alert("failed");
       }
   } catch(err){
        console.log(err);
        alert("something went wrong!");
   }
});


QnAUpdateButton.addEventListener("click", function(){
    const num = document.querySelector("#noQnA").value;
    window.location.href = "/client/QnA/QnAModify/"+num;
});


