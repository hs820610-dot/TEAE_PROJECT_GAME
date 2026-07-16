document.addEventListener('DOMContentLoaded', function () {
    const deleteForm = document.getElementById("patchDeleteForm");

    if(delectForm) {
        deleteForm.addEventListener('submit', function (e) {
            e.preventDefault();

            const isConfirmed = confirm('정말 삭제할 겁니까?');

            if(isConfirmed) {
                deleteForm.submit();
            }else{
                console.log('삭제가 취소되었습니다.')
            }
        });
    }
});