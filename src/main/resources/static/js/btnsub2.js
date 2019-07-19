$(function () {
    $("#btnsub2").click(function () {
        $.get("/dr-user/userOnlyCheck",{"textName2":$("#textName2").val()},function (data) {
            if (data == "true"){
                alert("对不起，您已经买过该产品了");
            }else{
                alert("您可以购买该产品");
            }
        })
    })
});