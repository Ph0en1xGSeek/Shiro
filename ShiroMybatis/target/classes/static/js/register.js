$(function(){
    $("#register").click(function(){
        var username = $("#username").val();
        var password = $("#password").val();
        var passwordAgain = $("#passwordAgain").val();
        if(username.length == 0){
            alert("请输入用户名");
        }else if(password.length == 0){
            alert("请输入密码");
        }else if(passwordAgain.length == 0){
            alert("请确认密码");
        }else if(password != passwordAgain){
            alert("密码不一致");
        }else{
            user = JSON.stringify({username: username, password: hex_md5(password)});
            $.ajax({
                url: '/users',
                type: 'POST',
                dataType: 'text',
                async: false,
                data: user,
                contentType: 'application/json;charset=UTF-8',
                success: function(data){
                    if(data == 'success'){
                        window.location.href = "/";
                    }else{
                        alert(data);
                    }
                }
            });
        }
    });

    $("#login").click(function(){
        window.location.href = "/";
    });
});