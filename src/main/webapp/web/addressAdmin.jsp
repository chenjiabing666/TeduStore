<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>我的订单 - 达内学子商城</title>
    <link href="../css/orders.css" rel="stylesheet"/>
    <link href="../css/header.css" rel="stylesheet"/>
    <link href="../css/footer.css" rel="stylesheet"/>
    <link href="../css/personage.css" rel="stylesheet" />
</head>
<body>
<%--导入头部 --%>
<jsp:include page="header.jsp"></jsp:include>
<%--导入左边栏 --%>
<jsp:include page="leftslider.jsp"></jsp:include>

   <!-- 右边栏-->
    <div class="rightsidebar_box rt">	
        <!--标题栏-->
        <div class="rs_header">
            <span class="address_title">收获地址管理</span>
        </div>
        <!--收货人信息填写栏-->
        <div class="rs_content">
        	<form method="post" action="">
        		
        		<!-- 收货地址的id -->
        		<input type="hidden" name="hidden" id="hidden">
        		
	            <!--收货人姓名-->
	            <div class="recipients">
	                <span class="red">*</span><span class="kuan">收货人：</span><input type="text" name="receiverName" id="receiverName"/>
	            </div>
	            
	            <!--收货人所在城市等信息-->
	            <div class="address_content">
					 <span class="red">*</span><span class="kuan">省&nbsp;&nbsp;份：</span>
					 	   <select id="receiverState" name="receiverState" onchange="getCities(this.value,-1,-1)">
					 	   		<option value="-1">-------请选择省份---------</option>
					 	   </select>
					  城市：<select id="receiverCity" name="receiverCity" onchange="getAreas(this.value,-1)">
					  			<option value='-1'>-------请选择城市---------</option>
					  	  </select>
					  区/县：<select id="receiverDistrict" name="receiverDistrict">
					  			<option value="-1">-------请选择区县---------</option>
					  		</select>
				</div> 
	            
	            
	            <!--收货人详细地址-->
	            <div class="address_particular">
	                <span class="red">*</span><span class="kuan">详细地址：</span><textarea name="receiverAddress" id="receiverAddress" cols="60" rows="3" placeholder="建议您如实填写详细收货地址"></textarea>
	            </div>
	            <!--收货人地址-->
	            <div class="address_tel">
	                <span class="red">*</span><span class="kuan">手机号码：</span><input type="tel" id="receiverMobile" name="receiverMobile"/>固定电话：<input type="text" name="receiverPhone" id="receiverPhone"/>
	            </div>
	            <!--邮政编码-->
	            <div class="address_postcode">
	                <span class="red">&nbsp;</span class="kuan"><span>邮政编码：</span>&nbsp;<input type="text" name="receiverZip" id="receiverZip"/>
	            </div>
	            <!--地址名称-->
	            <div class="address_name">
	                <span class="red">&nbsp;</span class="kuan"><span>地址名称：</span>&nbsp;<input type="text" id="addressName" name="addressName"/>如：<span class="sp">家</span><span class="sp">公司</span><span class="sp">宿舍</span>
	            </div>
	            <!--保存收货人信息-->
	            <div style="width: 160px;height: 40px;line-height: 40px;    background: -webkit-linear-gradient(top, #27b1f6 0%, #0aa1ed 100%);color: #fff;border-radius: 2px;cursor: pointer;text-align: center;margin-bottom: 50px;">
	                <a href="#" onclick="addAddress()" style="color: white;" id="save_opertion">保存收货人信息</a>
	            </div>
	
    		</form>
            <!--已有地址栏-->
            <div class="address_information_manage">
                <div class="aim_title">
                    <span class="dzmc dzmc_title">地址名称</span><span class="dzxm dzxm_title">姓名</span><span class="dzxq dzxq_title">地址详情</span><span class="lxdh lxdh_title">联系电话</span><span class="operation operation_title">操作</span>
                </div>
            </div>
        </div>
    </div>
</div>
<%--导入底部的页面 --%>
<jsp:include page="bottom.jsp"></jsp:include>

</body>
<script type="text/javascript" src="../js/jquery-3.1.1.min.js"></script>
<script src="../js/jquery.page.js"></script>
<script type="text/javascript" src="../js/orders.js"></script>
<script type="text/javascript" src="../js/distpicker.data.js"></script>
<script type="text/javascript" src="../js/distpicker.js"></script>
<script type="text/javascript" src="../js/personal.js"></script>
<script type="text/javascript">
	$(".lxdh_normal").each(function(i,e) {
		var phone = $(e).html();
		$(e).html(changePhone(phone));
	});
	
	//页面加载完毕，执行匿名函数
	$(function(){
		//左边栏中的所有dd都隐藏
		 $("#leftsidebar_box dd").hide();
		//账号管理的列表项显示
		 $("#leftsidebar_box .address dd").show();
		//所有的箭头设置成向右
		 $("#leftsidebar_box dt img").attr("src","../images/myOrder/myOrder1.png");
		 $("#leftsidebar_box .address").find('img').attr("src","../images/myOrder/myOrder2.png");
		 var flag=0;
		 $(".address dt").click(function(){
			 if(flag==0){
				 $(".address dt img").attr("src","../images/myOrder/myOrder1.png");
				 flag=1;
			 }else if(flag==1){
				 $(this).parent().find('img').attr("src","../images/myOrder/myOrder2.png");
				 flag=0;
			 }
		    });
		 getProvinces(-1,-1,-1);
		 getAddressByUid();
	});
	
	//获取用户的所有收货地址
	function getAddressByUid(){
		var url="<%=request.getContextPath()%>/address/getAddressByUid.do";  //url
		$.get(url,function(data,status,xhr){
			if(status=="success"){
				for(var i=0;i<data.data.length;i++){
					var span_default=$('<span class="swmr swmr_normal" id="'+data.data[i].id+'">设为默认</span>');
					var div=$('<div class="aim_content_one"></div>');
					var span_tag=$('<span class="dzmc dzmc_normal">'+data.data[i].recvTag+'</span>');
					var span_name=$('<span class="dzxm dzxm_normal">'+data.data[i].recvName+'</span>');
					var span_address=$('<span class="dzxq dzxq_normal">'+data.data[i].recvDistrict+data.data[i].recvAddress+'</span>');
					var span_phone=$('<span class="lxdh lxdh_normal">'+data.data[i].recvPhone+'</span>');
					var span_opertion=$('<span class="operation operation_normal"><span class="aco_change" onclick="goUpdateFun('+data.data[i].id+')">修改</span>|<span class="aco_delete" onclick="deleteFun('+data.data[i].id+')">删除</span></span>');
					//如果这个设置为默认的
					if(data.data[i].isDefault==1){
						div=$('<div class="aim_content_one aim_active"></div>');
						span_default=$('<span class="swmr swmr_normal" id="'+data.data[i].id+'"></span>');
						span_tag=$('<span class="dzmc dzmc_active">'+data.data[i].recvTag+'</span>');
					}
					div.append(span_tag);
					div.append(span_name);
					div.append(span_address);
					div.append(span_phone);
					div.append(span_opertion);
					div.append(span_default);
					$(".address_information_manage").append(div);
				}
				
				//设置为默认
				$(".swmr_normal").click(function(){
					setDefault(this);  //设置默认的样式
					var id=$(this).attr("id");   //获取地址的id
					var url="<%=request.getContextPath()%>/address/setDefault.do?id="+id; //请求的url
					$.get(url,function(obj,status,xhr){
						//如果响应成功
						if(status=="success"){
							alert(obj.message);
						}
					})
				})
				
				
				
				
				
				
				
			}
		})
	}
	
	//回显收货人信息
	function goUpdateFun(id){
		var url="<%=request.getContextPath()%>/address/getAddressById.do?id="+id;
		$.get(url,function(obj,status,xhr){
			//响应成功
			if(status=="success"){
				if(obj.state==1){
					$("#receiverName").val(obj.data.recvName);  // 收货人姓名
					$("#receiverAddress").val(obj.data.recvAddress);  //详细地址
					$("#receiverMobile").val(obj.data.recvPhone); //手机号码
					$("#receiverPhone").val(obj.data.recvTel);  //固定电话
					$("#receiverZip").val(obj.data.recvZip);  //邮政编码
					$("#addressName").val(obj.data.recvTag);  //地址名称
					$("#receiverState").val(obj.data.recvProvince);  //省份编码
					
					//显示下拉列表中的数据
					getProvinces(obj.data.recvProvince,obj.data.recvCity,obj.data.recvArea);
					getCities(obj.data.recvProvince,obj.data.recvCity,obj.data.recvArea);
					getAreas(obj.data.recvCity,obj.data.recvArea);
					
					//设置div的文本内容
					$("#save_opertion").text("提交修改");
					//修改绑定的点击事件方法
					$("#save_opertion").attr("onclick","updateAddress()");
					
					//设置id主键到隐藏表单域中
					$("#hidden").val(id);
					
				}else{
					alert(obj.message)
				}
			}
		});		
	}
	
	//修改地址信息
	function updateAddress(){
		var recvName=$("#receiverName").val();  //收货人姓名
		var recvProvince=$("#receiverState").val();  //省份编码
		var recvCity=$("#receiverCity").val();  //市
		var recvArea=$("#receiverDistrict").val();  //区
		var recvAddress=$("#receiverAddress").val();  //详细地址
		var recvPhone=$("#receiverMobile").val(); //手机号码
		var recvTel=$("#receiverPhone").val();  //固定电话
		var recvZip=$("#receiverZip").val();  //邮政编码
		var recvTag=$("#addressName").val();  //地址名称
		var id=$("#hidden").val();  // id
		
		if(recvName&&recvProvince&&recvCity&&recvArea&&recvPhone&&recvAddress){
			var url="<%=request.getContextPath()%>/address/updateAddress.do";  //url
			var d={"recvName":recvName,"recvProvince":recvProvince,"recvCity":recvCity,"recvArea":recvArea,"recvAddress":recvAddress,
				"recvPhone":recvPhone,"recvTel":recvTel,"recvZip":recvZip,"recvTag":recvTag,"id":id};  //  封装数据
			//发出异步请求
			$.post(url,d,function(data,status,xhr){
				if(status=="success"){
					alert(data.message);
					//重定向刷新页面
					window.location="<%=request.getContextPath()%>/address/showAddress.do";
				}
			});
		}else{
			alert("务必完善带*号的信息")
			return;
		}
	}
	
	//删除收货人地址
	function deleteFun(id){
		var url="${pageContext.request.contextPath}/address/deleteAddressById.do?id="+id; //url
		 if(confirm("确定要删除此行信息?")){
			$.get(url,function(obj,status,xhr){
				if(status=="success"){
					alert(obj.message);
					if(obj.state==1){
						//重定向刷新页面
						window.location="<%=request.getContextPath()%>/address/showAddress.do";
					}
				}
			});
		} 
	}

	//添加收货地址
	function addAddress(){
		var recvName=$("#receiverName").val();  //收货人姓名
		var recvProvince=$("#receiverState").val();  //省份编码
		var recvCity=$("#receiverCity").val();  //市
		var recvArea=$("#receiverDistrict").val();  //区
		var recvAddress=$("#receiverAddress").val();  //详细地址
		var recvPhone=$("#receiverMobile").val(); //手机号码
		var recvTel=$("#receiverPhone").val();  //固定电话
		var recvZip=$("#receiverZip").val();  //邮政编码
		var recvTag=$("#addressName").val();  //地址名称
		
		if(recvName&&recvProvince&&recvCity&&recvArea&&recvPhone&&recvAddress){
			var url="<%=request.getContextPath()%>/address/addAddress.do";  //url
			var d={"recvName":recvName,"recvProvince":recvProvince,"recvCity":recvCity,"recvArea":recvArea,"recvAddress":recvAddress,
				"recvPhone":recvPhone,"recvTel":recvTel,"recvZip":recvZip,"recvTag":recvTag};  // 封装数据
			//发出异步请求
			
			$.post(url,d,function(data,status,xhr){
				if(status=="success"){
					alert(data.message);
					//重定向刷新页面
					window.location="<%=request.getContextPath()%>/address/showAddress.do";
				}
			});
		}else{
			alert("务必完善带*号的信息")
			return;
		}
		
		
	}
	
	
	//获取所有的省份信息
	function getProvinces(provinceCode,cityCode,areaCode){
		var url="<%=request.getContextPath()%>/dict/getProvince.do";  // 异步请求的url
		//发出异步请求
		$.get(url,function(data,status,xhr){
			if(status=="success"){
				for(var i=0;i<data.data.length;i++){
					var option="<option value="+data.data[i].provinceCode+">"+data.data[i].provinceName+"</option>";
					$("#receiverState").append(option);
				}
				
				if(provinceCode!=-1){
					$("#receiverState").val(provinceCode);
				}				
			}
		});
	}
	
	
	//获取所有的城市信息
	function getCities(provinceCode,cityCode,areaCode){
		//var provinceCode=$("#receiverState").val();  //请求的数据
		var url="<%=request.getContextPath()%>/dict/getCity.do?provinceCode=" + provinceCode;  //异步请求的url
		
		$("#receiverCity").html("<option value='-1'>-------请选择城市---------</option>");
		
		//如果其中的provinceCode==-1，表示选择了请选择省份的那个选项，此时就不许需要发出异步请求了
		if(provinceCode==-1){
			return;
		}
		//发送异步请求
		$.get(url,function(data,status,xhr){
			if(status=="success"){
				for(var i=0;i<data.data.length;i++){
					//新建option节点，第一个是文本的值，第二个是value属性的值
					var option=new Option(data.data[i].cityName,data.data[i].cityCode);
					$("#receiverCity").append(option);  
				}
				
				if(provinceCode!=-1){
					$("#receiverCity").val(cityCode);
				}
			}
		})
		
	}
	
	//获取所有县区的异步请求
	function getAreas(cityCode,areaCode){
		//var cityCode=$("#receiverCity").val();  //请求的数据
		var url="<%=request.getContextPath()%>/dict/getArea.do?cityCode="+cityCode;  // 异步请求的url
		
		$("#receiverDistrict").html("<option value='-1'>-------请选择县区---------</option>");
		
		//如果其中的cityCode==-1，表示选择了请选择省份的那个选项，此时就不许需要发出异步请求了
		if(cityCode==-1){
			return;
		}
		//发送异步请求
		$.get(url,function(data,status,xhr){
			if(status=="success"){
				for(var i=0;i<data.data.length;i++){
					//新建option节点，第一个是文本的值，第二个是value属性的值
					var option=new Option(data.data[i].areaName,data.data[i].areaCode);
					$("#receiverDistrict").append(option);  
				}
				
				if(cityCode!=-1){
					$("#receiverDistrict").val(areaCode);
				}
			}
		})
	}
	
	
</script>
</html>