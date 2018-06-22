package cn.tedu.store.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tedu.store.service.IGoodsCategoryService;

@Controller
@RequestMapping("/goodsCategory")
public class GoodsCategoryController {
	@Resource
	private IGoodsCategoryService goodsCategoryService;
	
	
}
