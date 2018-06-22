package cn.tedu.store.mapper;

import java.util.List;

import cn.tedu.store.bean.Area;
import cn.tedu.store.bean.City;
import cn.tedu.store.bean.Province;

/**
 * 省市区的接口
 * @author chenjiabing
 */
public interface DictMapper {
	/**
	 * 查询所有的省份
	 * @return  省份集合
	 */
	List<Province> selectProvince();
	
	/**
	 * 
	 * @param provinceCode
	 * @return
	 */
	List<City> selectCityByProvinceCode(String provinceCode);
	
	/**
	 * 根据城市的编码查询所有的县区
	 * @param cityCode
	 * @return
	 */
	List<Area> selectAreaByCityCode(String cityCode);
	
	/**
	 * 根据省份编号查询省份的名称
	 * @param proviceCode   省份编码
	 * @return
	 */
	String selectProvinceNameByCode(String proviceCode);
	
	/**
	 * 根据城市的编号查询城市的名称
	 * @param cityCode  城市的编号
	 * @return
	 */
	String selectCityNameByCode(String cityCode);

	/**
	 * 根据区县编号查询区县的名称 
	 * @param areaCode 区县的编号
	 * @return
	 */
	String selectAreaNameByCode(String areaCode);
}
