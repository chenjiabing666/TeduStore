package cn.tedu.store.service;

import java.util.List;

import cn.tedu.store.bean.Goods;

/**
 * 商品业务层的接口
 * @author chenjiabing
 */
public interface IGoodsService {
	/**
	 * 根据categoryId获取商品的信息
	 * @param categoryId  分类id
	 * @param offest  偏移量
	 * @param count  数量
	 * @return  商品集合
	 */
	List<Goods> getGoodsByCategoryId(Integer categoryId,Integer offest,Integer count);
	
	/**
	 * 根据categoryId获取商品的数量
	 * @param categoryId  分类id
	 * @return  数量
	 */
	Integer getGoodsCountByCategoryId(Integer categoryId);
	
	/**
	 * 根据商品id获取商品详细信息
	 * @param id  商品id
	 * @return  商品对象
	 */
	Goods getGoodsById(Integer id);
	
	
	
	
	
	
	
}
