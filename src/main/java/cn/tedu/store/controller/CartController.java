package cn.tedu.store.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.store.bean.Cart;
import cn.tedu.store.bean.CartVo;
import cn.tedu.store.bean.ResponseResult;
import cn.tedu.store.service.ICartService;

@Controller
@RequestMapping("/cart")
public class CartController extends BaseController {
	@Resource
	private ICartService cartService;
	
	/**
	 * 添加购物车
	 * @param session  HttpSession  用于获取用户id
	 * @param num  数量
	 * @return
	 */
	@RequestMapping("/addCart.do")
	@ResponseBody
	public ResponseResult<Void> addCart(HttpSession session,Integer goodsId,Integer num){
		System.out.println(goodsId);
		ResponseResult<Void> result=new ResponseResult<Void>();
		try {
			Integer uid=this.getId(session);
			Cart cart=new Cart();  //新建Cart对象
			cart.setUid(uid);
			cart.setNum(num);
			cart.setGoodsId(goodsId);
			cartService.addCart(cart);
			result.setState(1);
			result.setMessage("添加成功");
		} catch (Exception e) {
			result.setState(0);
			result.setMessage(e.getMessage());
		}
		return result;
	}
	
	/**
	 * 显示购物车
	 * @param session 获取uid
	 * @param map
	 * @return
	 */
	@RequestMapping("/showCart.do")
	public String showCart(HttpSession session,ModelMap map){
		try {
			Integer uid=this.getId(session); //获取uid
			List<CartVo> cartVos=cartService.getCartVoList(uid);
			//添加到map中
			map.addAttribute("carts", cartVos);
		} catch (Exception e) { //用户登录超时
			map.addAttribute("errorInfo", e.getMessage());
		}  
		return "cart";
	}
	
	/**
	 * 批量删除商品
	 * @param Itemids  数组，其中全是id
	 * @return
	 */
	@RequestMapping("/moveCartBatch.do")
	public String moveCartBatch(Integer[] Itemids){
		System.out.println(Itemids);
		cartService.moveCartById(Itemids);
		return "redirect:../cart/showCart.do";
	}
	
	@RequestMapping("/modifyCartNum.do")
	@ResponseBody
	public ResponseResult<Void> modifyCartNum(Integer id,Integer num){
		ResponseResult<Void> result=new ResponseResult<Void>();
		cartService.updateNum(id, num);
		result.setState(1);
		result.setMessage("添加成功");
		return result;
	}
	
	
	
}
