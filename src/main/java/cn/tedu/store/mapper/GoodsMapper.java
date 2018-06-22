package cn.tedu.store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.store.bean.Goods;

/**
 * 商品的mapper接口
 * @author chenjiabing
 */
public interface GoodsMapper {
	
	/**
	 * 根据分类的id查询出商品信息
	 * @param categoryId 分类id
	 * @param offest 偏移量
	 * @param count  数量
	 * @return
	 */
	List<Goods> selectGoodsByCategoryId(@Param("categoryId")Integer categoryId,@Param("offest")Integer offest,@Param("count")Integer count);
	
	/**
	 * 根据categoryId查询商品数量
	 * @param categoryId  分类id
	 * @return  数量
	 */
	Integer selectCountByCategoryId(Integer categoryId);
	
	/**
	 * 根据id查询商品
	 * @param id
	 * @return
	 */
	Goods selectGoodsById(Integer id);
	
}
