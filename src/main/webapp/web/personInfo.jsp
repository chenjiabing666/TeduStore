<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>我的订单 - 达内学子商城</title>
    <link href="../css/orders.css" rel="stylesheet"/>
    <link href="../css/header.css" rel="stylesheet"/>
    <link href="../css/footer.css" rel="stylesheet"/>
    <link href="../css/personage.css" rel="stylesheet" />
    <link rel="stylesheet" type="text/css" href="../css/icon/css/bootstrap.min.css">
	<link href="../css/icon/css/cropper.min.css" rel="stylesheet">
	<link href="../css/icon/css/sitelogo.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="../css/icon/css/font-awesome.min.css">
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>

<jsp:include page="leftslider.jsp"></jsp:include>
    <!-- 右边栏-->
    <!--个人信息头部-->
    <div class="rightsidebar_box rt">
        <div class="rs_header">
            <span class="rs_header_active"><a href="<%=request.getContextPath() %>/user/showPersonInfo.do">我的信息</a></span>
            <span><a href="<%=request.getContextPath() %>/user/showPassword.do">安全管理</a></span>
        </div>

        <!--个人信息具体内容 -->
        <div class="rs_content">
            <!--头像-->
            <div class="rs_content_headPortrait">
	                <span class="same">我的头像：</span>
	               <img src="${pageContext.request.contextPath }${user.image }" alt="" id="icon" width="50px" height="50px"/>
	                <input type="file" name="file" value="" id="iconPic" onchange="getImageFun()">
	                
	                <!-- <span class="change_headPortrait same_click" data-toggle="modal" data-target="#avatar-modal" >更改头像</span> -->
	            </div>
            <!--用户名-->
            <form action="" id="personInfo-form">
            <div class="rs_content_username">
                <span class="same">用户名：</span>
                <span class="same rs_username">${sessionScope.user.username }</span>
                <input class="ed_username" value="${user.username }" id="username" name="username" style="display: none;"/>
                <span class="change_username same_click">更改用户名</span>
            </div>
            <!--性别-->
            <div class="rs_content_sex">
                <span class="same">性别：</span>
                <span class="man selected" style="display: none;">
                    <img src="../images/personage/select.png" alt=""/>男
                </span>
                <span class="women" style="display:none;">
                    <img src="../images/personage/un_select.png" alt=""/>女
                </span>
                
                <input type="radio" name="gender" id="gender0" value="0" <c:if test="${user.gender==0 }">checked="checked"</c:if> >男
                <input type="radio" name="gender" id="gender1" value="1" <c:if test="${user.gender==1 }">checked="checked"</c:if>  >女
                
            </div>
            <!--绑定电话-->
            <div class="rs_content_tel">
                <span class="same">绑定电话：</span>
                <input type="text" value="${user.phone }" name="phone" id="phone"/>
            </div>
            <!--绑定邮箱-->
            <div class="rs_content_mail">
                <span class="same">绑定邮箱：</span>
                <input class="ed_email" value="${user.email }" style="display: none;" name="email" id="email"/>
                <span class="rs_mail">${user.email }</span>
                <span class="same_click change_mail">更改邮箱</span>
            </div>
            <!--保存按钮-->
            <div class="save">
                <a href="#" onclick="btnUpdate()" style="color: white;">保存更改</a>
            </div>
       </form>
        </div>
    </div>
</div>
<!-- 头像插件 -->
<div class="modal fade" id="avatar-modal" aria-hidden="true" aria-labelledby="avatar-modal-label" role="dialog" tabindex="-1"> 
    <div class="modal-dialog modal-lg"> 
        <div class="modal-content"> 
            <!--<form class="avatar-form" action="upload-logo.php" enctype="multipart/form-data" method="post">--> 
            <form class="avatar-form"> 
                <div class="modal-header"> 
                    <button class="close" data-dismiss="modal" type="button">×</button> 
                    <h4 class="modal-title" id="avatar-modal-label">上传图片</h4> 
                </div> 
                <div class="modal-body"> 
                    <div class="avatar-body"> 
                        <div class="avatar-upload"> 
                            <input class="avatar-src" name="avatar_src" type="hidden"> 
                            <input class="avatar-data" name="avatar_data" type="hidden"> 
                            <label for="avatarInput" style="line-height: 35px;">图片上传</label> 
                            <button class="btn btn-info"  type="button" style="height: 35px;" onClick="$('input[id=avatarInput]').click();">请选择图片</button> 
                            <span id="avatar-name"></span> 
                            <input class="avatar-input hide" id="avatarInput" name="avatar_file" type="file"></div> 
                        <div class="row"> 
                            <div class="col-md-9"> 
                                <div class="avatar-wrapper"></div> 
                            </div> 
                            <div class="col-md-3"> 
                                <div class="avatar-preview preview-lg" id="imageHead"></div> 
                                <!--<div class="avatar-preview preview-md"></div> 
                        <div class="avatar-preview preview-sm"></div>--> 
                            </div> 
                        </div> 
                        <div class="row avatar-btns"> 
                            <div class="col-md-4"> 
                                <div class="btn-group"> 
                                    <button class="btn btn-info fa fa-undo" data-method="rotate" data-option="-90" type="button" title="Rotate -90 degrees"> 向左旋转</button> 
                                </div> 
                                <div class="btn-group"> 
                                    <button class="btn  btn-info fa fa-repeat" data-method="rotate" data-option="90" type="button" title="Rotate 90 degrees"> 向右旋转</button> 
                                </div> 
                            </div> 
                            <div class="col-md-5" style="text-align: right;">                                 
                                <button class="btn btn-info fa fa-arrows" data-method="setDragMode" data-option="move" type="button" title="移动"> 
                                <span class="docs-tooltip" data-toggle="tooltip" title="" data-original-title="$().cropper("setDragMode", "move")"> 
                                </span> 
                              </button> 
                              <button type="button" class="btn btn-info fa fa-search-plus" data-method="zoom" data-option="0.1" title="放大图片"> 
                                <span class="docs-tooltip" data-toggle="tooltip" title="" data-original-title="$().cropper("zoom", 0.1)"> 
                                  <!--<span class="fa fa-search-plus"></span>--> 
                                </span> 
                              </button> 
                              <button type="button" class="btn btn-info fa fa-search-minus" data-method="zoom" data-option="-0.1" title="缩小图片"> 
                                <span class="docs-tooltip" data-toggle="tooltip" title="" data-original-title="$().cropper("zoom", -0.1)"> 
                                  <!--<span class="fa fa-search-minus"></span>--> 
                                </span> 
                              </button> 
                              <button type="button" class="btn btn-info fa fa-refresh" data-method="reset" title="重置图片"> 
                                    <span class="docs-tooltip" data-toggle="tooltip" title="" data-original-title="$().cropper("reset")" aria-describedby="tooltip866214"> 
                               </button> 
                            </div> 
                            <div class="col-md-3"> 
                                <button id="button_save" class="btn btn-info btn-block avatar-save fa fa-save" type="button" data-dismiss="modal"> 保存修改</button> 
                            </div> 
                        </div> 
                    </div> 
                </div> 
            </form> 
        </div> 
    </div> 
</div> 
<jsp:include page="bottom.jsp"></jsp:include>
</body>
<script type="text/javascript" src="../js/jquery.min.js"></script>
<script src="../js/index.js"></script>
<script src="../js/jquery.page.js"></script>
<script type="text/javascript" src="../js/orders.js"></script>
<script type="text/javascript" src="../js/personal.js"></script>
<script src="../js/icon/bootstrap.min.js"></script>
<script src="../js/icon/cropper.js"></script>
<script src="../js/icon/sitelogo.js"></script>
<script src="../js/icon/html2canvas.min.js" type="text/javascript" charset="utf-8"></script> 
<script type="text/javascript"> 

//上传文件的方法
function getImageFun(){
	var file=document.getElementById("iconPic").files[0];  //获取当前的file
	// 创建FormData对象
	var formData=new FormData();
	formData.append("file",file);  //将文件放入formData中
	alert(file)
	$.ajax({
		"url":"${pageContext.request.contextPath}/user/getImage.do",
		"data":formData,
		"type":"post",
		"dataType":"json",   //返回数据类型
		"contentType":false,  //不设置上传文件类型  ，因为上传的文件有多种类型的
		"processData":false,    //不处理数据
		"success":function(obj){
			alert(obj.message);
			var url=window.URL.createObjectURL(file);  //获取上传的的本地路径
			$("#icon").attr("src",url);  //将上面的头像显示为当前选择的图片
		}
	})
}

function btnUpdate(){
	//异步请求
	$.ajax({
		url:"<%=request.getContextPath()%>/user/updateUser.do",
		type:"POST",
		dataType:"json",
		data:$("#personInfo-form").serialize(),   //封装请求参数
		success:function(obj){
			alert(obj.message);
			//如果成功修改
			if(obj.state==1){
				//重定向到个人信息页面，相当于刷新页面了，那么此时修改的信息会更新在页面中
				window.location.href="<%=request.getContextPath()%>/user/showPersonInfo.do";
			}
		}
	})
}
//做个下简易的验证  大小 格式  
    $('#avatarInput').on('change', function(e) {
        var filemaxsize = 1024 * 5;//5M 
        var target = $(e.target); 
        var Size = target[0].files[0].size / 1024; 
        if(Size > filemaxsize) { 
            alert('图片过大，请重新选择!'); 
            $(".avatar-wrapper").childre().remove; 
            return false; 
        } 
        if(!this.files[0].type.match(/image.*/)) { 
            alert('请选择正确的图片!') 
        } else { 
            var filename = document.querySelector("#avatar-name"); 
            var texts = document.querySelector("#avatarInput").value; 
            var teststr = texts; //你这里的路径写错了 
            testend = teststr.match(/[^\\]+\.[^\(]+/i); //直接完整文件名的 
            filename.innerHTML = testend; 
        } 
     
    }); 
 
    $(".avatar-save").on("click", function() { 
        var img_lg = document.getElementById('imageHead'); 
        // 截图小的显示框内的内容 
        html2canvas(img_lg, { 
            allowTaint: true, 
            taintTest: false, 
            onrendered: function(canvas) { 
                canvas.id = "mycanvas"; 
                //生成base64图片数据 
                var dataUrl = canvas.toDataURL("image/png"); 
                var newImg = document.createElement("img"); 
                newImg.src = dataUrl; 
                imagesAjax(dataUrl) 
            } 
        }); 
    }) 
    function imagesAjax(src) { 
        var data = {}; 
        data.img = src; 
        $.ajax({ 
            url: "", 
            data: data, 
            type: "POST", 
            dataType: 'json', 
            success: function(re) {
            	if (re) {
	                if(re.status == 200) {
	                    $('#icon').attr('src',re.data.url );
	                    $('#iconPic').val(re.data.url);
	                }else {
						alert("上传失败")
					} 
					
				}
            } 
        });
    } 
</script>
<script type="text/javascript">
$("#icon").click(function() {
	window.open($(this).attr("src"));
})
</script> 

<script>
	$("#button_save").click(function(){
		var url = $("#imageHead img").attr("src");
		$('#icon').attr('src',url);
	});
	
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