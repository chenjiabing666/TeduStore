package cn.tedu.store.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.store.bean.GoodsCategory;
import cn.tedu.store.mapper.GoodsCategoryMapper;

/**
 * 商品分类的业务层实现类
 * @author chenjiabing
 */
@Service
public class GoodsCategoryServiceImpl implements IGoodsCategoryService {
	@Resource
	private GoodsCategoryMapper goodsCategoryMapper;
	
	//查询商品的分类信息
	public List<GoodsCategory> getGoodsCategoryByParentId(Integer parentId,
			Integer offest, Integer count) {
		return goodsCategoryMapper.selectGoodsCategoryBYParentId(parentId, offest, count);
	}

	public GoodsCategory getGoodsCatoryById(Integer id) {
		return goodsCategoryMapper.selectGoodCategoryById(id);
	}

}
