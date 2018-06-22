package cn.tedu.store.service;

import java.util.List;

import cn.tedu.store.bean.GoodsCategory;

/**
 * 商品分类的业务层接口
 * @author chenjiabing
 */
public interface IGoodsCategoryService {
	
	/**
	 * 查询商品的分类信息
	 * @param parentId  父级的id
	 * @param offest 偏移量
	 * @param count   数量
	 * @return  返回二级和三级分类信息
	 */
	List<GoodsCategory> getGoodsCategoryByParentId(Integer parentId,Integer offest,Integer count);
	
	/**
	 * 根据id查询分类信息
	 * @param id  主键id
	 * @return  分类信息
	 */
	GoodsCategory getGoodsCatoryById(Integer id);
	
}
