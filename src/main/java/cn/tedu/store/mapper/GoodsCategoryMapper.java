package cn.tedu.store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.store.bean.GoodsCategory;

/**
 * 商品分类的mapper接口
 * @author chenjiabing
 */
public interface GoodsCategoryMapper {
	/**
	 * 根据parentId查询出商品分类
	 * @param parentId  父级id
	 * @param offest   偏移量
	 * @param count   查询的数量
	 * @return 返回二级和三级分类的集合
	 */
	List<GoodsCategory> selectGoodsCategoryBYParentId(@Param("parentId")Integer parentId,@Param("offest")Integer offest,@Param("count")Integer count);
	/**
	 * 根据id查询分类信息
	 * @param id
	 * @return
	 */
	GoodsCategory selectGoodCategoryById(Integer id);
}
