package cn.tedu.store.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.store.bean.Area;
import cn.tedu.store.bean.City;
import cn.tedu.store.bean.Province;
import cn.tedu.store.mapper.DictMapper;

/**
 * 省市区的业务实现类
 * @author chenjiabing
 */
@Service //控制反转，创建对象
public class DictServiceImpl implements IDictService {
	@Resource   //自动注入对象
	private DictMapper dictMapper;
	
	//获取所有的省份信息
	public List<Province> getProvinces() {
		return dictMapper.selectProvince();
	}
	
	/**
	 * 获取所有的城市信息
	 */
	public List<City> getCities(String provinceCode) {
		return dictMapper.selectCityByProvinceCode(provinceCode);
	}
	
	/**
	 * 获取所有的县区信息
	 */
	public List<Area> getAreas(String cityCode) {
		return dictMapper.selectAreaByCityCode(cityCode);
	}
}
