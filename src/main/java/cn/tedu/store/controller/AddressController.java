package cn.tedu.store.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;

import cn.tedu.store.bean.Address;
import cn.tedu.store.bean.ResponseResult;
import cn.tedu.store.service.IAddressService;
import cn.tedu.store.service.ex.DataNotExisteException;
import cn.tedu.store.service.ex.UserNotFoundException;

/**
 * 地址管理的controller
 * 继承父类BaseController
 * @author chenjiabing
 */
@Controller
@RequestMapping("/address")
public class AddressController extends BaseController {
	@Resource
	private IAddressService addressService;
	
	/**
	 * 显示地址管理的视图  addressAdmin.jsp
	 * @return
	 */
	@RequestMapping("/showAddress.do")
	public String showAddress(){
		return "addressAdmin";
	}
	
	/**
	 * 添加收货地址
	 * @param session HttpSession对象，用于获取当前登录的用户id
	 * @param address 封装请求参数
	 * @return  返回结果集
	 */
	@RequestMapping("/addAddress.do")
	@ResponseBody
	public ResponseResult<Void> addAddress(HttpSession session,Address address){
		ResponseResult<Void> result=new ResponseResult<Void>();  //创建结果集对象
		try {
			Integer uid=this.getId(session); //获取用户的id
			address.setUid(uid);  //设置到地址对象中
			addressService.addAddress(address);  //调用方法，执行插入
			result.setState(1);
			result.setMessage("添加成功");
		}catch(UserNotFoundException e){   //当前登录的用户不存在
			result.setState(0);
			result.setMessage(e.getMessage());
		} catch (Exception e) {  //当前登录的用户已经过期	
			result.setState(0);
			result.setMessage(e.getMessage());
		}
		return result;
	}
	
	
	/**
	 * 获取所有的收货地址
	 * @param session  HttpSession对象，获取用户id
	 * @return  返回的是结果集，其中封装了所有地址信息
	 */
	@RequestMapping("/getAddressByUid.do")
	@ResponseBody
	public ResponseResult<List<Address>> getAddress(HttpSession session){
		//创建结果集对象
		ResponseResult<List<Address>> result=new ResponseResult<List<Address>>();
		try {
			Integer uid=this.getId(session);  //获取用户id
			List<Address> addresses=addressService.getAddressesByUid(uid);  //查询
			result.setState(1);     //设置响应状态码
			result.setMessage("查询成功");
			result.setData(addresses);  //添加查询到的数据
		} catch (UserNotFoundException e) {  //用户名已经注销或者被删除导致不存在的异常
			result.setState(0);
			result.setMessage(e.getMessage());
		}catch (Exception e) {
			result.setState(0);
			result.setMessage(e.getMessage());
		}
		return result;
	
	}
	
	
	/**
	 * 修改默认地址的异步请求处理方法
	 * @param session  HttpSession方法，用于获取uid
	 * @param id  收货地址对应的id
	 * @return  返回结果集对象
	 */
	@RequestMapping("/setDefault.do")
	@ResponseBody
	public ResponseResult<Void> setDefault(HttpSession session,Integer id){
		ResponseResult<Void> result=new ResponseResult<Void>(); //创建响应结果集对象
		try {
			Integer uid=this.getId(session);  //获取uid
			addressService.setDefault(uid,id);
			result.setState(1);
			result.setMessage("设置成功");
		} catch (DataNotExisteException e) {
			result.setState(0);
			result.setMessage(e.getMessage());
		}catch (Exception e) {
			result.setState(0);
			result.setMessage(e.getMessage());
		}
		return result;
	}
	
	
	/**
	 * 处理根据id查询地址信息的异步请求
	 * @param id  地址id
	 * @return  结果集，其中封装了地址信息
	 */
	@RequestMapping("/getAddressById.do")
	@ResponseBody
	public  ResponseResult<Address> getAddressById(Integer id){
		//创建结果集对象
		ResponseResult<Address> result=new ResponseResult<Address>();
		try {
			//查找
			Address address=addressService.getAddressById(id);
			result.setData(address);  //将数据添加到结果集中
			result.setState(1);
			result.setMessage("查询成功");
		} catch (DataNotExisteException e) {
			result.setState(0);
			result.setMessage(e.getMessage());
		}
		return result;
	}
	
	/**
	 * 修改地址信息的异步请求
	 * @param address
	 * @return
	 */
	@RequestMapping("/updateAddress.do")
	@ResponseBody
	public ResponseResult<Void> updateAddress(Address address){
		ResponseResult<Void> result=new ResponseResult<Void>();
		addressService.updateAddressById(address);
		result.setState(1);
		result.setMessage("修改成功");
		return result;
	}
	
	
	@RequestMapping("/deleteAddressById.do")
	@ResponseBody
	public ResponseResult<Void> deleteAddressById(Integer id){
		ResponseResult<Void> result=new ResponseResult<Void>(); //创建响应结果集对象
		try {
			addressService.deleteAddressById(id);
			result.setState(1);
			result.setMessage("删除成功");
		} catch (DataNotExisteException e) {
			result.setState(0);
			result.setMessage(e.getMessage());
		}
		return result;
	}
	
	
	
	
	
	
	
}
