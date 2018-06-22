package cn.tedu.store.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.store.bean.Area;
import cn.tedu.store.bean.City;
import cn.tedu.store.bean.Province;
import cn.tedu.store.bean.ResponseResult;
import cn.tedu.store.service.IDictService;
/**
 * 省市区的controller层
 * 继承父类BaseController
 * @author chenjiabing
 */
@Controller
@RequestMapping("/dict")
public class DictController extends BaseController {
	@Resource  
	private IDictService dictService;  //自动创建service对象
	
	/**
	 * 异步获取所有的省份信息，返回给页面
	 * @return 结果集，省份信息
	 */
	@RequestMapping("/getProvince.do")
	@ResponseBody
	public ResponseResult<List<Province>> getProvince(){
		//创建结果集对象
		ResponseResult<List<Province>> result=new ResponseResult<List<Province>>();
		List<Province> provinces=dictService.getProvinces();
		result.setState(1);  //设置响应码
		result.setMessage("响应成功");
		result.setData(provinces);  //添加返回的数据
		return result;
	}
	
	/**
	 * 获取城市信息
	 * @param provinceCode  省份的编码
	 * @return  返回结果集
	 */
	@RequestMapping("/getCity.do")
	@ResponseBody
	public ResponseResult<List<City>> getCity(String provinceCode){
		ResponseResult<List<City>> result=new ResponseResult<List<City>>();  //创建结果集对象
		List<City> cities=dictService.getCities(provinceCode);   //获取城市信息
		result.setData(cities);   //将城市信息封装到结果集中
		return result;
	}
	
	/**
	 * 异步获取所有县区的信息
	 * @param cityCode  城市编码
	 * @return  结果集，其中封装了县区的信息
	 */
	@RequestMapping("/getArea.do")
	@ResponseBody
	public ResponseResult<List<Area>> getAreas(String cityCode){
		ResponseResult<List<Area>> result=new ResponseResult<List<Area>>();
		List<Area> areas=dictService.getAreas(cityCode);
		result.setData(areas);
		return result;
	}
	
}

