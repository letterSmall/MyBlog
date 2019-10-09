// $("#submit_article").click(function () {
//     var h=$('#article-title').val();
//     var content=$('#content').val();
//     var article_keyword=$('#article-keyword').val();
//     var article_des=$('#article-des').val();
//     var radioValue = $('input:radio:checked').val();
//     var checkbox=[];
//     $("input[name='check']:checked").each(function (i) {
//         checkbox[i]=$(this).val();
//     });
//     if (content){
//         alert("文章内容不能为空")
//     }
//     else if (radioValue) {
//         alert("栏目不能为空")
//     }
//     else {
//         $.ajax({
//             type: "POST",
//             url: "/Article/add",
//             data:{content:content},
//             dataType: "json",
//             success:function (data) {
//                 alert("成功")
//             },error:function (data) {
//                 alert("失败")
//             }
//         })
//     }
// })

$(".category").click(function () {
    var radioValue = $('input:radio:checked').val();
    if(radioValue!=null && radioValue!=''){
        $.ajax({
            type: "POST",
            url:"/article/label",
            data:{category_id:radioValue},
            dataType:"json",
            success:function (data) {
                $("#mylabel").html();
                var label="";
                if (data==null && data==''){
                    label="";
                }else {
                    for (var i=0;i < data.length;i++){
                        label +="<label style='margin-left: 6px;'><input name='check' value=\""+data[i].id+"\"type=\"checkbox\" style=\"margin: 0px 3px 0px 0px;\">"+data[i].labelname+"</label>";
                    }
                }
                $("#mylabel").html(label);
            },
            error:function (data) {
                alert("获取标签失败");
            }
        },)
    }

})
var editor = UE.getEditor('article-content');
window.onresize=function(){
    window.location.reload();
}
var _uploadEditor;
$(function () {
    //重新实例化一个编辑器，防止在上面的editor编辑器中显示上传的图片或者文件
    _uploadEditor = UE.getEditor('uploadEditor');
    _uploadEditor.ready(function () {
        //设置编辑器不可用
        //_uploadEditor.setDisabled();
        //隐藏编辑器，因为不会用到这个编辑器实例，所以要隐藏
        _uploadEditor.hide();
        //侦听图片上传
        _uploadEditor.addListener('beforeInsertImage', function (t, arg) {
            //将地址赋值给相应的input,只去第一张图片的路径
            $("#pictureUpload").attr("value", arg[0].src);
            //图片预览
            //$("#imgPreview").attr("src", arg[0].src);
        })
        //侦听文件上传，取上传文件列表中第一个上传的文件的路径
        _uploadEditor.addListener('afterUpfile', function (t, arg) {
            $("#fileUpload").attr("value", _uploadEditor.options.filePath + arg[0].url);
        })
    });
});
//弹出图片上传的对话框
$('#upImage').click(function () {
    var myImage = _uploadEditor.getDialog("insertimage");
    myImage.open();
});
//弹出文件上传的对话框
function upFiles() {
    var myFiles = _uploadEditor.getDialog("attachment");
    myFiles.open();
}