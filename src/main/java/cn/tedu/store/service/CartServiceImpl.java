package cn.tedu.store.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.store.bean.Cart;
import cn.tedu.store.bean.CartVo;
import cn.tedu.store.mapper.CartMapper;

/**
 * 购物车的接口实现类
 * @author chenjiabing
 *
 */
@Service
public class CartServiceImpl implements ICartService {
	@Resource
	private CartMapper cartMapper;
	/**
	 * 添加购物车
	 * 1. 
	 */
	public void addCart(Cart cart) {
		cartMapper.insertCart(cart);
	}
	
	//获取购物车中的数据
	public List<CartVo> getCartVoList(Integer uid) {
		return cartMapper.selectCartByUid(uid);
	}

	//批量删除数据
	public void moveCartById(Integer[] ids) {
		cartMapper.deleteCartById(ids);
	}

	//修改数量
	public void updateNum(Integer id, Integer num) {
		cartMapper.updateNum(id, num);
	}

}
