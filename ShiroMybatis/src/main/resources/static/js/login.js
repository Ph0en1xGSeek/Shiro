$(function(){
    $("#login").click(function () {
        var username = $("#username").val();
        var password = $("#password").val();
        if(username.length == 0){
            alert("请输入用户名");
        }else if(password.length == 0){
            alert("请输入密码");
        }else{
            var user = {username: username, password: hex_md5(password)};
            $.ajax({
                url: '/login',
                type: 'POST',
                dataType: 'text',
                async: false,
                data: user,
                success: function(data){
                    if(data == 'success'){
                        window.location.href = "/index";
                    }else{
                        alert("用户名或密码错误");
                    }
                }
            });
        }
    });

    $("#register").click(function () {
        window.location.href = '/register';
    });
});