package cn.tedu.store.md5;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * 密码加密的类
 * @author chenjiabing
 */
public class MD5Password {
	private final static String SALT="加油,骚年!";  //加盐处理
	
	/**
	 * 获取加密之后的密码
	 * @param password 用户输入的密码
	 * @return  加密之后的密码
	 */
	public static  String getMd5Password(String password){
		return DigestUtils.md5Hex(password+SALT);  //使用了加盐处理
	}
}
