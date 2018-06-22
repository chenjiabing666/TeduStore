import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.bean.Cart;
import cn.tedu.store.bean.Goods;
import cn.tedu.store.bean.GoodsCategory;
import cn.tedu.store.bean.Province;
import cn.tedu.store.mapper.CartMapper;
import cn.tedu.store.mapper.DictMapper;
import cn.tedu.store.mapper.GoodsCategoryMapper;
import cn.tedu.store.mapper.GoodsMapper;

public class TestCartMapper {
	@Test
	public void testInsertCart() {
		// 加载Spring的配置文件
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("spring-dao.xml");
		CartMapper cartMapper=ac.getBean("cartMapper",CartMapper.class);
		Cart cart=new Cart();
		cart.setGoodsId(10000017);
		cart.setNum(2);
		cart.setUid(4);
		cart.setCreatedUser("陈加兵");
		cart.setCreatedTime(new Date());
		cart.setModifiedUser("JACK");
		cart.setModifiedTime(new Date());
		cartMapper.insertCart(cart);
		ac.close();
	}
	
	@Test
	public void testdelete() {
		// 加载Spring的配置文件
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("spring-dao.xml");
		CartMapper cartMapper=ac.getBean("cartMapper",CartMapper.class);
		
		cartMapper.deleteCartByIdProcdure(9);
		ac.close();
	}

}
