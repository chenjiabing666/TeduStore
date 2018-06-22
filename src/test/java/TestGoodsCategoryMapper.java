import java.util.List;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.bean.GoodsCategory;
import cn.tedu.store.bean.Province;
import cn.tedu.store.mapper.DictMapper;
import cn.tedu.store.mapper.GoodsCategoryMapper;

public class TestGoodsCategoryMapper {
	@Test
	public void testselectGoodsCategoryBYParentId() {
		// 加载Spring的配置文件
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("spring-dao.xml");
		GoodsCategoryMapper goodsCategoryMapper=ac.getBean("goodsCategoryMapper",GoodsCategoryMapper.class);
		List<GoodsCategory> goodsCategories=goodsCategoryMapper.selectGoodsCategoryBYParentId(161,0,3);
		System.out.println(goodsCategories);
		
		for (GoodsCategory goodsCategory : goodsCategories) {
			List<GoodsCategory> list=goodsCategoryMapper.selectGoodsCategoryBYParentId(goodsCategory.getId(),null,null);
			System.out.println(list);
		}
		ac.close();
	}

}
