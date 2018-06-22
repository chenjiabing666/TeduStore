<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>我的订单 - 达内学子商城</title>
    <link href="../css/orders.css" rel="Stylesheet"/>
    <link href="../css/header.css" rel="Stylesheet"/>
    <link href="../css/footer.css" rel="Stylesheet"/>
    <link href="../css/personage.css" rel="stylesheet" />
</head>
<body>
<%--导入头部 --%>
<jsp:include page="header.jsp"></jsp:include>
<%--导入左边栏 --%>
<jsp:include page="leftslider.jsp"></jsp:include>

    <!-- 右边栏-->
    <!--个人信息头部-->
    <div class="rightsidebar_box rt">
        <div class="rs_header">
            <span ><a href="<%=request.getContextPath()%>/user/showPersonInfo.do">我的信息</a></span>
            <span class="rs_header_active"><a href="<%=request.getContextPath()%>/user/showPassword.do">安全管理</a></span>
        </div>

        <!--安全管理 -->
        <div class="rs_content">
            <p class="change_password_title">更改密码</p>
            <div class="new_password">
                <span class="word">输入旧密码：</span><input type="password" name="oldPassword" id="oldPassword"/><span class="change_hint" id="oldPasswordSpan"></span>
            </div>
            <div class="new_password">
                <span class="word">输入新密码：</span><input type="password" name="newPassword" id="newPassword"/><span class="change_hint" id="newPasswordSpan"></span>
            </div>
            <div class="confirm_password">
                <span class="word">确认新密码：</span><input type="password" id="confirmPassword"/><span class="confirm_hint" id="confirmPasswordSpan"></span>
            </div>
            <div class="save_password">
                <a href="#" onclick="updatePassword()" style="color: white;">保存更改</a>
            </div>
        </div>


    </div>
</div>

<%--导入底部栏 --%>
<jsp:include page="bottom.jsp"></jsp:include>

</body>
<script type="text/javascript" src="../js/jquery-3.1.1.min.js"></script>
<script src="../js/index.js"></script>
<script src="../js/jquery.page.js"></script>
<script type="text/javascript" src="../js/orders.js"></script>

<script type="text/javascript">

//验证密码长度在6-9位之间,参数为密码
function checkPasswordLength(pwd){
	return pwd.length>=6&&pwd.length<=9;   
}

//验证新密码和确认新密码是否相同
function checkPasswordEquals(){
	var newPassword=$("#newPassword").val(); //新密码
	var confirmPassword=$("#confirmPassword").val();  //确认新密码
	return newPassword==confirmPassword;   
}

//旧密码失去焦点验证密码长度
$("#oldPassword").blur(function(){
	if(!checkPasswordLength($(this).val())){
		$("#oldPasswordSpan").text("密码长度在6-9位之间");
		$("#oldPasswordSpan").css("color","red"); 
	}else{
		$("#oldPasswordSpan").text("密码格式正确");
		$("#oldPasswordSpan").css("color","green"); 
	}
});

//新密码失去焦点验证密码长度
$("#newPassword").blur(function(){
	if(!checkPasswordLength($(this).val())){
		$("#newPasswordSpan").text("密码长度在6-9位之间");
		$("#newPasswordSpan").css("color","red"); 
	}else{
		$("#newPasswordSpan").text("密码格式正确");
		$("#newPasswordSpan").css("color","green"); 
	}
});


//确认密码失去焦点验证与新密码是否一致
$("#confirmPassword").blur(function(){
	//如果密码不一致
	if(!checkPasswordEquals()){
		$("#confirmPasswordSpan").text("密码与新密码不一致");
		$("#confirmPasswordSpan").css("color","red");
	}else{
		$("#confirmPasswordSpan").text("");
	}
});


//修改密码的方法
function updatePassword(){
	var newPassword=$("#newPassword").val(); // 新密码
	var oldPassword=$("#oldPassword").val();   // 旧密码
	var d={"newPassword":newPassword,"oldPassword":oldPassword };  // 封装请求数据
	var url="<%=request.getContextPath()%>/user/updatePassword.do";  // 请求的url
	
	//如果验证的条件都完成了，那么可以发出请求
	if(checkPasswordLength(newPassword)&&checkPasswordLength(oldPassword)&&checkPasswordEquals()){
		$.post(url,d,function(data,status,xhr){
			//响应成功
			if(status=="success"){
				//如果修改成功
				if(data.state==1){
					alert(data.message); 
					//重定向到登录界面
					window.location="<%=request.getContextPath()%>/user/showLogin.do";
				}else{  //如果修改失败
					alert(data.message);
				}
			}
		});
	}
}





//页面加载完毕，执行匿名函数
$(function(){
	//左边栏中的所有dd都隐藏
	 $("#leftsidebar_box dd").hide();
	//账号管理的列表项显示
	 $("#leftsidebar_box .count_managment dd").show();
	//所有的箭头设置成向右
	 $("#leftsidebar_box dt img").attr("src","../images/myOrder/myOrder1.png");
	 $("#leftsidebar_box .count_managment").find('img').attr("src","../images/myOrder/myOrder2.png");
	 var flag=0;
	 $(".count_managment dt").click(function(){
		 if(flag==0){
			 $(".count_managment dt img").attr("src","../images/myOrder/myOrder1.png");
			 flag=1;
		 }else if(flag==1){
			 $(this).parent().find('img').attr("src","../images/myOrder/myOrder2.png");
			 flag=0;
		 }
	    });
});
</script>

</html>