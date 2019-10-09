function checkurl() {
    var flink_url=$("#flink-url").val();
    alert(flink_url);
    if (flink_url!=null && flink_url !=''){
        $.ajax({
            type: 'GET',
            url: 'back/business/checkurl',
            data: {url:flink_url},
            dataType: "json",
            success:function (data) {
                if (data.result!=null){
                    alert(成功)
                }
            },
            error:function (data) {
                alert(失败)
            }
        })
    }
}

$("#flink-name").change(function () {
    var flink_name = $("#flink-name").val();
    if (flink_name != null && flink_name != '') {
        $.ajax({
            type: "GET",
            url: "@{back/flink.json}",
            data: {flink_name},
            dataType: "json",
            success: function (data) {
                $("#flink-state").html("");
                    p = "<p><label>状态：</label><span>"+data[1].linkname+"</span></p>\n"+
                        "<p><label>地址：</label><span>"+data[1].url+"</span></p>\n"+
                        "<p><label>图像：</label><img th:src="+data.image+" th:width=\"20px\" th:height=\"20px\" /> </p>\n" +
                        "<p><label>描述：</label><span>"+data[1].des+"</span></p>\n";
                $("#flink-state").html(p);
            },
            error:function (data) {
                $("#flink-state").html("");
                var p = "<p><label>状态：</label><span>未添加</span></p>\n" +
                    "<p><label>地址：</label><span>未添加</span></p>\n" +
                    "<p><label>图像：</label><img th:src=\"@{/backstage/images/icon/favicon.ico}\" th:width=\"20px\" th:height=\"20px\" /> </p>\n" +
                    "<p><label>描述：</label><span class=\"article-time-display\">未添加</span></p>\n";
                $("#flink-state").html(p);
            }
        })
    }
})