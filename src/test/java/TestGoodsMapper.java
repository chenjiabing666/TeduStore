import java.util.List;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.bean.Goods;
import cn.tedu.store.bean.GoodsCategory;
import cn.tedu.store.bean.Province;
import cn.tedu.store.mapper.DictMapper;
import cn.tedu.store.mapper.GoodsCategoryMapper;
import cn.tedu.store.mapper.GoodsMapper;

public class TestGoodsMapper {
	@Test
	public void testselectGoodsCategoryBYParentId() {
		// 加载Spring的配置文件
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("spring-dao.xml");
		
		GoodsMapper goodsMapper=ac.getBean("goodsMapper",GoodsMapper.class);
		
		List<Goods> goods=goodsMapper.selectGoodsByCategoryId(238, 0, 10);

		System.out.println(goods);
		ac.close();
	}

}
