package cn.tedu.store.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sun.org.apache.xpath.internal.operations.Mod;

import sun.net.www.content.image.gif;
import cn.tedu.store.bean.Goods;
import cn.tedu.store.bean.GoodsCategory;
import cn.tedu.store.service.IGoodsCategoryService;
import cn.tedu.store.service.IGoodsService;

/**
 * 首页的控制器
 * @author chenjiabing
 */
@RequestMapping("/main")
@Controller
public class MainController extends BaseController{
	@Resource
	private IGoodsCategoryService goodsCategoryService;
	@Resource
	private IGoodsService goodsService;
	
	/**
	 * 显示首页 index.jsp
	 * @return
	 */
	@RequestMapping("/showIndex.do")
	public String showIndex(ModelMap map){
		//查找二级分类
		List<GoodsCategory> computerList=goodsCategoryService.getGoodsCategoryByParentId(161, 0, 3);
		
		//创建三级分类的集合
		List<List<GoodsCategory>> category161List=new ArrayList<List<GoodsCategory>>();
		
		for (GoodsCategory list : computerList) {
			//根据二级分类的id查找对应的三级分类信息
			List<GoodsCategory> goodsCategories=goodsCategoryService.getGoodsCategoryByParentId(list.getId(), null,null);
			//将查找到的三级分类的信息存储到集合中
			category161List.add(goodsCategories);  
		}
		
		//添加二级分类的信息在map中
		map.addAttribute("computerList",computerList);
		//添加三级分类的信息到map中
		map.addAttribute("category161List",category161List);
		
		//获取商品集合
		List<Goods> goods=goodsService.getGoodsByCategoryId(163,0,3);
		//将商品添加到map中
		map.addAttribute("goods",goods);
		
		return "index";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
