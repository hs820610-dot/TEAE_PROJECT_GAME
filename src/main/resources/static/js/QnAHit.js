const QnARecommendButton = document.querySelector("#QnARecommendButton");
const QnADeleteButton = document.querySelector("#QnADeleteButton");
const QnAUpdateButton  = document.querySelector("#QnAUpdateButton");

QnARecommendButton.addEventListener("click", async function(){
    const num = document.querySelector("#noQnA").value;
    try{
        const response = await fetch(`/game/QnAHit/${num}`, {
            method: "POST"
        });

        if (response.ok) {
            const reCount = await response.json();
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
       const response = await fetch(`/game/QnAdelete/${num}`, {
           method: "POST"
       });

       if (response.ok) {
           alert("삭제되었습니다.")
           location.href = "/game/QnAList";
       }else{
           alert("failed");
       }
   } catch(err){
        console.log(err);
        alert("something went wrong!");
   }
});