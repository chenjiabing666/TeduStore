package cn.tedu.store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.store.bean.Cart;
import cn.tedu.store.bean.CartVo;

public interface CartMapper {
	
	/**
	 * 添加购物车
	 * @param cart
	 */
	void insertCart(Cart cart);
	
	/**
	 * 根据uid查询购物车中的所有商品
	 * @param uid  用户id
	 * @return   查询的结果
	 */
	List<CartVo> selectCartByUid(Integer uid);
	
	/**
	 * 根据id删除购物车中的商品
	 * @param ids
	 */
	void deleteCartById(@Param("ids")Integer[] ids);
	
	/**
	 * 调用存储过程 deleteCart(pid int)删除数据
	 * @param id
	 */
	void deleteCartByIdProcdure(Integer id);
	
	/**
	 * 更新数量
	 * @param id  主键id
	 * @param num  数量
	 */
	void updateNum(@Param("id")Integer id,@Param("num")Integer num);
}
