<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head lang="en">
<meta charset="UTF-8">
<title>商品搜索页面</title>
<link rel="stylesheet" href="../css/header.css" />
<link rel="stylesheet" href="../css/search.css" />
<link rel="stylesheet" href="../css/footer.css" />
</head>

<body>
	<jsp:include page="header.jsp"></jsp:include>
	
	<div class="big">
		<form name="" action="" method="post">
			<section id="section">
				<p class="header">全部结果>${categoryName }</p>
				<div id="wrap">
				
					<c:forEach var="goods" items="${goodsList }">
						<div class="lf box" id="d1" style="margin-right: 10px;">
							<div class="info">
							<div class="img pic">
								<img src="..${goods.image }" alt="" onclick="toItemInfo(${goods.id})" />
							</div>			
							<div class="describe" >
								<p style="width: 200px;height: 14px;overflow: hidden;" onclick="toItemInfo(${goods.id})">${goods.title }</p>
								<span class="price"><b>￥</b><span class="priceContent">${goods.price }</span></span>
								<span class="addCart"><img id="collect" src="../images/search/care.png" alt="" /><a href="javascript:void(0);" class="add_cart">加入购物车</a></span>
								<!-- <span class="succee" style="display: none"> 
									<img src="/images/search/product_true.png" alt="" /> 
									<span>已移入购物车</span>
								</span> -->
							</div>
							</div>
						</div>
					</c:forEach>
				
				</div>
			</section>
		</form>
	</div>
	
	<div style="height: 20px;margin-right: 100px;font-size: 15px;" align="right">
		共${totalSize }条记录 | 分${pageSize }页 
		<c:forEach var="index" begin="1" end="${pageSize }">
			<a href="${pageContext.request.contextPath }/goods/showSearch.do?categoryId=${categoryId}&categoryName=${categoryName}&page=${index}" <c:if test="${currentPage==index }">style="color:#ff0000"</c:if>>${index }</a>
		</c:forEach>
	</div>
	
	
	<!-- 尾部-->
<jsp:include page="bottom.jsp"></jsp:include>
	<script src="../js/jquery-3.1.1.min.js"></script>
	<script src="../js/index.js"></script>
	<script src="../js/jquery.page.js"></script>
	<script>
	$(".add_cart").click(function(){
		$(".modal").show();
		$(".modal .modal_information span").html("将您的宝贝加入购物车?");
	})
	$(".yes").click(function(){
	    $(".modal").hide();
	})
	$('.no').click(function(){
    	$('.modal').hide();
    	
    })
</script>
    <!--<script type="text/javascript">
	// var status = ${status};
	var pages = ${pageBean.totalPages};
	var index = ${pageBean.pageIndex};
	$(".tcdPageCode").createPage({
		// 总页数
	    pageCount:pages,
	 	// 起始页
	    current:index,
	    backFn:function(p){
	    	// 执行代码
	    	window.location.href="http://localhost:18888/search.html?q=${q}&page="+p;
	    }
	});
</script>-->
<script type="text/javascript">
    /* 商品详情页  */
	function toItemInfo(id) {
		if (id) {
			window.location.href="${pageContext.request.contextPath}/goods/showProductInfo.do?id="+id+"&categoryName=${categoryName}";
		}else {
			alert("商品不存在");
		}
	} 
</script>
<script type="text/javascript">
	/**添加到收藏**/
    $("#collect").click(function(e){
    	$(".modal").show();
		$(".modal .modal_information span").html("将您的宝贝加入收藏夹");
    })
    $(".yes").click(function(){
	    $(".modal").hide();
	    $('#collect').attr("src","../images/search/care1.png");
    })
</script>
</body>
</html>