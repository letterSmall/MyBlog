
$("#addcategory").click(function () {
    $("#addcategory").prop("disabled",true);
    var name=$("#category-name").val();
    var aliasname=$("#aliasname").val();
    var keyword=$("#keyword").val();
    var dec=$("#des").val();
    $.ajax({
        type:'POST',
        url:"/Category/add",
        data: $('#form1').serialize(),
        success:function (data) {
            document.getElementById("form1").reset();
            window.location.href='/back/category';
        },error:function (data) {
            alert("error");
        }
    })
})