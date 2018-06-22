<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>学子商城详情页</title>
    <link rel="stylesheet" href="../css/header.css"/>
    <link href="../css/pro_details.css" rel="Stylesheet"/>
    <link href="../css/animate.css" rel="Stylesheet"/>
    <link rel="stylesheet" href="../css/footer.css"/>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<!--细节导航-->
<div id="nav_detail">
    <h5>首页 > 学习用品 > ${category3Name }> ${goods.title }></h5>
</div>
<!--产品预览-->
<div id="shop_detail">
    <!-- 左侧-->
    <div id="preview" class="lf">
        <div id="mediumDiv">
            <img id="mImg" src="..${goods.image }" style="width: 500px;height: 400px;"/>
        </div>
        <div id="icon_all">
            <ul id="icon_list">
                <li class="i1"><img src="../images/product_detail/product_detail_img1.jpg"/></li>
                <li class="i1"><img src="../images/product_detail/product_detail_img2.jpg"/></li>
                <li class="i1"><img src="../images/product_detail/product_detail_img3.jpg"/></li>
                <li class="i1"><img src="../images/product_detail/product_detail_img4.jpg"/></li>
                <li class="li"><img src="../images/product_detail/product_detail_img5.jpg"/></li>
            </ul>
        </div>
    </div>
    <!-- 右侧-->
    <div class="right_detail lf">
        <!-- 商品名称-->
        <h1>${goods.itemType }</h1>
        <!-- 商品全称-->
        <h3>${goods.title }</h3>
        <!-- 价格部分-->
        <div class="price">
            <div id="pro_price"><b>学员售价：</b><span>￥${goods.price }</span></div>
            <div class="promise">
                <b>服务承诺：</b>
                <span>*退货补运费</span>
                <span>*30天无忧退货</span>
                <span>*48小时快速退款</span>
                <span>*72小时发货</span>
            </div>
        </div>
        <!-- 参数部分 客服-->
        <p class="parameter">
            <b>客服：</b>
            <span class="connect">联系客服</span><img class="gif" src="../images/product_detail/kefuf.gif">
        </p>
        <!-- 颜色-->
        <p class="style" id="choose_color">
            <s class="color">颜色：</s>
            <input type="button" class="i1" value="黑色" title="黑色"/>
            <input type="button" class="i2" value="灰色" title="灰色"/>
            <input type="button" class="i3" value="金色" title="金色"/>
            <input type="button" class="i4" value="白色" title="白色"/>
        </p>
        <!-- 规格-->
        <p>
            <s>规格：</s>
            <span class="avenge">15寸 15 1T</span>
            <span class="avenge">18寸 18 2T</span>
            <span class="avenge">19寸 19 3T</span>
        </p>
        <!-- 未选择规格，颜色时状态-->
        <div class="message"></div>
        <!-- 数量-->
        <p class="accountChose">
            <s>数量：</s>
            <button class="numberMinus">-</button>
            <%--使用隐藏表单域存储商品的id --%>
            <input type="hidden" value="${goods.id }" name="goodsId" id="goodsId">
            <input type="text" value="1" class="number" id="buy-num" name="num">
            <button class="numberAdd">+</button>
        </p>
        <!-- 购买部分-->
        <div class="shops">
            <a href="cart.html" class="buy lf" id="buy_now">立即购买</a>
            <a href="javascript:void(0)" class="shop lf" id="add_cart"><img src="../images/product_detail/product_detail_img7.png" alt=""/>加入购物车</a>
            <a href="#" class="collection lf" id="collect"><span>收藏</span></a><b><img src="../images/product_detail/product_detail_img6.png"                                                                       alt=""/></b>
        </div>
    </div>
</div>
<!--为你推荐-->
<div id="recommended">
    <p>为你推荐<span>大家都在看</span></p>
    <div id="demo" style="width:1000px;overflow:hidden;">
        <div id="indemo" style="float: left;width: 200%;">
            <div id="demo1" style="float:left"><!-- 第一个宽度显示 -->
                 <div class="detail_1 lf">
                    <div class="detail_img1">
                        <img src="../images/product_detail/product_detail_1.png" border="0">
                    </div>
                    <p>ThinkPad New S2 (20GUA00QCD)13.3英寸超霸</p>
                </div>
                <div class="detail_1 lf">
                    <div class="detail_img1">
                        <img src="../images/product_detail/product_detail_2.png" border="0">
                    </div>
                    <p>戴尔 DELL燃7000 R1605S 超霸</p>
                </div>
                <div class="detail_1 lf">
                    <div class="detail_img1">
                        <img src="../images/product_detail/product_detail_3.png" border="0">
                    </div>
                    <p>戴尔(DELL)魔方15MF Pro-R2505TSS灵</p>
                </div>
                <div class="detail_1 lf">
                    <div class="detail_img1">
                        <img src="../images/product_detail/product_detail_4.png" border="0">
                    </div>
                    <p>联想(Lenovo) YOGA900 (YOGA4 PRO)多彩版</p>
                </div>
                <!--</div>-->
            </div>
            <div id="demo2" style="float:left">
            </div>
        </div>
        <!-- 宽度超大 -->
    </div>
    <!-- 外面大框 -->
</div>
<!--商品详情-->
<div id="iteminfo">
    <div id="tab">
        <div class="tab lf">
            <div class="cat">
                <span class="active"><a href="">商品详情</a></span>
                <span><a href="lookforward.html">商品评价</a></span>
            </div>
        </div>
        <div class="cart rt">
            <img src="../images/product_detail/product_detail_img9.png" alt=""/>
        </div>
    </div>
    <div class="left lf">
        <div class="all">
            <!--<p><img src="images_x/pin_logo.png" alt=""/></p>-->
            <div id="parm">
                <div id="specification_parameter">
                    <p>
                        规格参数
                        <img src="../images/product_detail/product_detail_icon_1.png" alt="" class="ys5"/>
                    </p>
                    <!--<img src="images_x/canshu.png" alt="" class="ys5"/>-->
                </div>
                <ul>
                    <li><a href="#">商品名称：联想YOGA 710</a></li>
                    <li><a href="#">系统：windows10</a></li>
                    <li><a href="#">内存容量：8G</a></li>
                    <li><a href="#">分辨率：全清高屏(1920*1080)</a></li>
                    <li><a href="#">显卡型号：GT940M</a></li>
                    <li><a href="#">处理器：Intel i7低功耗版</a></li>
                    <li><a href="#">显存容量：2G</a></li>
                    <li><a href="#">分类：清薄本</a></li>
                    <li><a href="#">硬盘容量:256G固态</a></li>
                </ul>
            </div>
            <div id="product_introduction">
                <p>
                    商品介绍
                    <img src="../images/product_detail/product_detail_icon_4.png" alt="" class="ys5"/>
                </p>
                <img src="../images/product_detail/product_detail_img8.png" alt=""/>
            </div>
            <div id="sale_protection">
                <p>
                    售后保障
                    <img src="../images/product_detail/product_detail_icon_3.png" alt="" class="ys5"/>
                </p>

                <div class="sale_content">
                    <p class="paper" id="sale_protect">
                        <img src="../images/product_detail/product_detail_img16.png" alt=""/>
                        正品保障
                    </p>

                    <p class="content">
                        达内学子商城向您保证所售商品均为正品行货，达内自营商品开具机打发票或电子发票。
                    </p>

                    <p class="paper">
                        <img src="../images/product_detail/product_detail_img16.png" alt=""/>
                        全国联保
                    </p>

                    <p class="content">
                        凭质保证书及达内商城发票，可享受全国联保服务，与您亲临商场选购的商品享受相同的质量保证。达内商城还为您提供具有竞争力的商品价格和运费政策，请您放心购买！
                        注：因厂家会在没有任何提前通知的情况下更改产品包装、产地或者一些附件，本司不能确保客户收到的货物与商城图片、产地、附件说明完全一致。只能确保为原厂正货！并且保证与当时市场上同样主流新品一致。若本商城没有及时更新，请大家谅解！
                    </p>
                </div>
            </div>
            <div id="packing_list">
                <p>
                    包装清单
                    <img src="../images/product_detail/product_detail_icon_2.png" alt="" class="ys5"/>
                </p>

                <p class="content">笔记本 x1 适配器 x1 电源线 x1 电池 x1 说明书（电子版）x1 备注：笔记本电脑的背面只会标注此电脑的系列，例如： XPS 13-9360 ，
                    如果您需要核实此电脑的具体配置型号是否与达内页面相符，可电话咨询达内厂商：800-858-2969</p>
            </div>
        </div>
    </div>
    <div class="right rt">
        <div class="aside_nav">
            <p><i><img src="../images/product_detail/product_detail_icon_g_1.png" alt=""/></i><a href="#specification_parameter">规格参数</a></p>
            <p><i><img src="../images/product_detail/product_detail_icon_t_1.png" alt=""/></i><a href="#product_introduction">商品介绍</a></p>
            <p><i><img src="../images/product_detail/product_detail_icon_d_1.png" alt=""/></i><a href="#sale_protection">售后保障</a></p>
            <p><i><img src="../images/product_detail/product_detail_icon_bao_1.png" alt=""/></i><a href="#sale_protect">包装清单</a></p>
            <p><i><img src="../images/product_detail/product_detail_icon_up_1.png" alt=""/></i><a href="#">回到顶部</a></p>
        </div>
    </div>
</div>

<jsp:include page="bottom.jsp"></jsp:include>
<script src="../js/jquery-3.1.1.min.js"></script>
<script src="../js/index.js"></script>
<!--图片轮播悬停进入详情页效果-->
<script>
    var speed = 20;
    var tab = document.getElementById("demo");
    var tab1 = document.getElementById("demo1");
    var tab2 = document.getElementById("demo2");
    tab2.innerHTML = tab1.innerHTML;
    function Marquee() {
        if (tab2.offsetWidth - tab.scrollLeft <= 0)
            tab.scrollLeft -= tab1.offsetWidth
        else {
            tab.scrollLeft++;
        }
    }
    var MyMar = setInterval(Marquee, speed);
    tab.onmouseover = function () {
        clearInterval(MyMar)
    };
    tab.onmouseout = function () {
        MyMar = setInterval(Marquee, speed)
    };
</script>
<!--添加到购物车 立即购买 收藏部分-->
<script type="text/javascript">
    //加入购物车操作
    var color;
    var norms;
    var buyAccount;
    function getPro(){
    	//颜色取值
        $("#choose_color input").each(function (i, item) {
            if ($(this).hasClass("borderChange")) {
                color = $(this).val();
            }
        })
        console.log(color)
        //规格取值
        $(".avenge").each(function () {
            if ($(this).hasClass("borderChange")) {
                norms = $(this).html();
            }
        })
        console.log(norms)
        //数量取值
        buyAccount = $("#buy-num").val();
        console.log(buyAccount);
    }
    //添加购物车
    $("#add_cart").click(function (e) {
    	var url="${pageContext.request.contextPath}/cart/addCart.do";
    	var buyAccount = $("#buy-num").val();
    	var goodsId=$("#goodsId").val();
    	var d={"num":buyAccount,"goodsId":goodsId};
    	/*  $.post(url,d,function(data,status,xhr){
    		 alert(data.status)
    		 alert(xhr.status)
    			alert(data.message);
    			alert("cds");
    			window.location="${pageContext.request.contextPath}/user/showLogin.do";
    	}) 
    	 */
    	$.ajax({
    		url:url,
    		type:"GET",
    		data:d,
    		dataType:"json",
    		success:function(data){
    			alert(data.message);
    		},
    		error:function(){
    			window.location="${pageContext.request.contextPath}/user/showLogin.do";
    		}
    	}) 
    })
    	
    /**添加到收藏**/
    $("#collect").click(function (e){
        e.preventDefault();
        getPro();
          //如果未选择，请选择商品信息
		if (!color || !norms ) {
			alert("请选择宝贝的参数信息");
        }else{
            $(".modal").show();
            $(".modal_information span").html("是否将您的宝贝加入收藏夹");
        }
    })
    $('.no').click(function(){
        $('.modal').hide();
    })
</script>
<script>
    $(function () {
        var nav = $("#tab"); //得到导航对象
        var aside = $(".aside_nav");//右侧导航
        var win = $(window); //得到窗口对象
        var sc = $(document);//得到document文档对象。
        win.scroll(function () {
            if (sc.scrollTop() >= 1000) {
                nav.addClass("fixed_tab");
                aside.addClass("fixed_aside");
            }
            else {
                nav.removeClass("fixed_tab");
                aside.removeClass("fixed_aside");
            }
        })


        //介绍区域右侧导航
        $("#iteminfo .right p").click(function () {
            //$(this).addClass("clic").siblings().removeClass("clic");
            $(this).css("background-color", "#0AA1ED").siblings().css("background-color", "#e8e8e8");
            $(this).find("a").css("color", "#fff").parent().siblings().find("a").css("color", "#828282")
        })
        /**选择商品进行添加 悬停效果**/
        $(".avenge").mouseover(function () {
            $(this).css({"border": "1px solid #0AA1ED", "color": "#0AA1ED"});
        }).mouseout(function () {
            $(this).css({"border": "1px solid #666", "color": "#666"})
        })
        /**数量添加**/
        var n = $("#buy-num").val() * 1;
        $(".numberMinus").click(function () {
            if (n >= 1) {
                $("#buy-num").val(n -= 1);
            }
        })
        $(".numberAdd").click(function () {
            $("#buy-num").val(n += 1);
        })

        /**ajax提交**/
        $(".avenge").each(function (i, item) {
            $(this).click(function (norms) {
                $(this).addClass("borderChange")
                if ($(this).siblings().addClass("borderChange")) {
                    $(this).siblings().removeClass("borderChange")
                }
                //规格选择
                var norms = $(this).html();
                console.log(norms)
            })
        })
        //颜色选择
        $("#choose_color input").each(function (i, item) {
            $(this).click(function () {
                $(this).addClass("borderChange")
                if ($(this).siblings().addClass("borderChange")) {
                    $(this).siblings().removeClass("borderChange")
                }
                var color = $(this).val();
                console.log(color)
            })
        })
        //数量选择
        $(".accountChose").click(function () {
            var buyAccount = $("#buy-num").val();
            console.log(buyAccount);
        })

        /*立即购买*/
        $("#buy_now").click(function (e) {
            //如果未选择，请选择商品信息
            if (color == undefined && norms == undefined) {
//            $("#add_cart").text("加入购物车").css({"background":"#f5f5f5","color":"#000"})
                alert("请选择商品信息");
            }else{
                location.href="cart.html";
            }
            e.preventDefault();
            var color = $("#choose_color input.borderChange").val();
            var model = $("#choose_model span.borderChange").html();
            var num = $("#buy-num").val();
            // 后台需要的参数
            // var url = '/toOrder/'+${item.id}+'.html?&num='+num+'&itemColor='+color+'&itemModel='+model;
//             window.location.href = url;
        })
    })
</script>
<!--图片效果-->
<script>
    $("#mImg").hover(function (){
        $(this).addClass("animated pulse");
    }, function (){
        $(this).removeClass("animated pulse");
    });
</script>
<script>
    $('#icon_list>li').click(function(){
        $(this).children('img').css('border','1px solid #CECFCE');
        var address=$(this).children().attr('src');
        console.log(address);
        var newaddress=address.slice(0,-4);
        var bigaddress=newaddress+'big.png';
        $('#mImg').attr('src',bigaddress);
        $(this).siblings().children('img').css('border','');
    })
</script>
</body>
</html>