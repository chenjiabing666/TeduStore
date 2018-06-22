package cn.tedu.store.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tedu.store.bean.Goods;
import cn.tedu.store.bean.GoodsCategory;
import cn.tedu.store.service.GoodsCategoryServiceImpl;
import cn.tedu.store.service.IGoodsCategoryService;
import cn.tedu.store.service.IGoodsService;

@Controller
@RequestMapping("/goods")
public class GoodsController extends BaseController {
	@Resource
	private IGoodsService goodService;
	@Resource
	private IGoodsCategoryService goodsCategoryService;
	
	/**
	 * 展示商品，分页展示
	 * @param categoryId  分类id
	 * @param categoryName  分类的名称
	 * @param page 页数  此时的 offest=(page-1)*12 偏移量
	 * @param map  ModelMap对象
	 * @return
	 */
	@RequestMapping("/showSearch.do")
	public String showSearch(Integer categoryId,String categoryName,Integer page,ModelMap map){
		//如果刚传过来的此时的page==null，我们显示第一页
		if (page==null) {
			page=1;
		}
		Integer offest=(page-1)*12; //偏移量
		
		//将分类名称添加到request域中
		map.addAttribute("categoryName", categoryName);

		//查询对应分类id的所有商品信息
		List<Goods> goods=goodService.getGoodsByCategoryId(categoryId,offest,12);
		//将查询出来的商品放入request域中
		map.addAttribute("goodsList", goods);
		
		//获取商品的总数
		Integer count=goodService.getGoodsCountByCategoryId(categoryId);
		
		Integer pageSize=count%12==0? count/12 : count/12+1;  //分多少页
		
		//将总条数放到request域中
		map.addAttribute("totalSize", count);
		//显示的页数
		map.addAttribute("pageSize", pageSize);
		
		//将分类id放入request中，分页的链接需要使用
		map.addAttribute("categoryId",categoryId);
		
		map.addAttribute("currentPage", page);
		
		return "search";
	}
	
	/**
	 * 显示详情页面
	 * @return
	 */
	@RequestMapping("/showProductInfo.do")
	public String showProductInfo(Integer id,String categoryName,ModelMap map){
		//根据id获取商品详情
		Goods goods=goodService.getGoodsById(id);
		
		//添加到request中
		map.addAttribute("goods", goods);
		//将三级分类分类的名称添加到request中
		map.addAttribute("category3Name",categoryName);
		return "product_details";
	}
	
	
	
	
	
	
	
	
	
	
}
