package cn.tedu.store.service;

import java.util.List;

import cn.tedu.store.bean.Area;
import cn.tedu.store.bean.City;
import cn.tedu.store.bean.Province;

/**
 * 省市区的业务接口
 * @author chenjiabing
 */
public interface IDictService {
	/**
	 * 获取所有的省份信息，返回对象集合
	 * @return  Province对象集合
	 */
	List<Province> getProvinces();
	
	/**
	 * 根据省份的编码获取所有的城市信息
	 * @param provinceCode   省份的编码
	 * @return   所有的城市的集合
	 */
	List<City> getCities(String provinceCode);
	
	/**
	 * 根据城市的编码获取所有的县区的信息
	 * @param cityCode  城市的编码
	 * @return  所有县区的集合
	 */
	List<Area> getAreas(String cityCode);
	
}
