package cn.tedu.store.service;

import java.util.List;

import cn.tedu.store.bean.Cart;
import cn.tedu.store.bean.CartVo;

/**
 * 购物车的业务层接口
 * @author chenjiabing
 */
public interface ICartService {
	/**
	 * 添加购物车
	 * @param cart  Cart对象
	 */
	void addCart(Cart cart);
	
	/**
	 * 根据uid获取购物车中的所有商品信息
	 * @param uid  用户id
	 * @return
	 */
	List<CartVo> getCartVoList(Integer uid);
	
	/**
	 * 根据id批量删除购物车
	 * @param ids id主键
	 */
	void moveCartById(Integer[] ids);
	
	/**
	 * 修改数量
	 * @param id
	 * @param num
	 */
	void updateNum(Integer id,Integer num);
}
