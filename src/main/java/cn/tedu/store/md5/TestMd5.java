package cn.tedu.store.md5;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

public class TestMd5 {
	@Test
	public void test1(){
		String str1="你们好，未来的程序员!";
		String strMessageString=DigestUtils.md5Hex(str1);
		System.out.println(strMessageString);
	}
	
	@Test
	public void test2() throws IOException{
		InputStream inputStream=new FileInputStream(new File("/home/chenjiabing/Documents/Blog/AOP.md"));
		String message=DigestUtils.md5Hex(inputStream);
		System.out.println(message);
	}
	
	@Test
	public void test3(){
		String str1="123456";
		String salt="这个是加盐处理";  //需要加盐，随便定义一个字符串
		String message=DigestUtils.md5Hex(str1+salt);  //获取加盐之后的消息摘要
		System.out.println(message);
	}
	
	
	
}
