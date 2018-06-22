package cn.tedu.store.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.store.bean.Goods;
import cn.tedu.store.mapper.GoodsMapper;
/**
 * 商品业务层的实现类
 * @author chenjiabing
 */
@Service
public class GoodsServiceImpl implements IGoodsService {
	@Resource
	private GoodsMapper goodsMapper;
	//根据categoryId获取商品的信息
	public List<Goods> getGoodsByCategoryId(Integer categoryId, Integer offest,
			Integer count) {
		return goodsMapper.selectGoodsByCategoryId(categoryId, offest, count);
	}
	
	//根据categoryId获取商品的数量
	public Integer getGoodsCountByCategoryId(Integer categoryId) {
		return goodsMapper.selectCountByCategoryId(categoryId);
	}

	//根据商品id查询商品详细信息
	public Goods getGoodsById(Integer id) {
		return goodsMapper.selectGoodsById(id);
	}
	
	
	

}
