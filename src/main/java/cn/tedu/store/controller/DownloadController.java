package cn.tedu.store.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.store.bean.User;

@Controller
@RequestMapping("/download")
public class DownloadController {

	@RequestMapping("/download.do")
	@ResponseBody
	public byte[] download(HttpServletResponse response,HttpServletRequest request,String filename)
			throws IOException {
		// 转换编码格式为iso-8859-1
		filename = URLEncoder.encode(filename, "utf-8");
		// 设置响应头 contentType,这里是下载图片 因此写的是 image/png
		response.setContentType("image/png");
		// 设置响应头Content-Disposition
		response.setHeader("Content-Disposition", "attachment;filename=\""
				+ filename + "\"");
		
		return getImage(filename, request);
	}
	
	/**
	 * 返回需要下载图片的byte数组
	 * @param filename 图片的名称
	 * @param request  HttpServletRequest对象，需要获取下载图片的项目路径
	 * @return  byte数组
	 * @throws IOException
	 */
	public byte[] getImage(String filename,HttpServletRequest request) throws IOException{
		
		//获取图片文件存放的位置，在项目的upload文件夹下
		String projectPath=request.getServletContext().getRealPath("/upload/");
		//获取需要下载的图片的路径
		File file=new File(projectPath+File.separator+filename);
		
		//创建输入流，读取图片
		InputStream inputStream=new FileInputStream(file);
		//创建内存操作流
		ByteArrayOutputStream out=new ByteArrayOutputStream();
		
		byte[] b=new byte[1000];  //创建一个缓冲数组
		int len=0;
		//读取字节流，读入到byte数组中
		while((len=inputStream.read(b))!=-1){
			out.write(b,0,len);  //写入byte数组输入流
		}
		inputStream.close();
		out.close();
		return out.toByteArray(); 
	}
	
	
	

	// 将图片转换成byte[]
	private byte[] createPNG() throws IOException {
		BufferedImage img = new BufferedImage(100, 50,
				BufferedImage.TYPE_3BYTE_BGR);
		img.setRGB(50, 25, 0xffff00);
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ImageIO.write(img, "png", out);
		out.close();
		byte[] png = out.toByteArray();
		return png;
	}

	
	@RequestMapping("/export.do")
	@ResponseBody
	public byte[] export(HttpServletResponse response) throws IOException {
		String filename="excel表格.xlsx";
		// 转换编码格式为iso-8859-1
		filename = URLEncoder.encode(filename, "utf-8");
		// 设置响应头 contentType,这里是下载excel
		response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		// 设置响应头Content-Disposition
		response.setHeader("Content-Disposition", "attachment;filename=\""
				+ filename + "\"");
		return createExcel();
	}
	
	//创建excel表格，变成byte数组
	private byte[] createExcel() throws IOException{
		//使用POI生成Excel
		XSSFWorkbook workbook=new XSSFWorkbook(); //生成工作簿
		
		XSSFSheet sheet = workbook.createSheet("第一张表");  //在工作簿中创建一个工作表
		
		XSSFRow row = sheet.createRow(0);  //创建行 行号从0开始
		
		XSSFCell cell = row.createCell(0);  //在行中创建单元格，从0开始，一行中包括多个单元格
		
		cell.setCellValue("第一行第一个单元格");  //在单元格中添加数据 

		ByteArrayOutputStream outputStream=new ByteArrayOutputStream();
		
		workbook.write(outputStream);   //写入ByteOutputStream流中
		
		workbook.close();
		
		outputStream.close();
		
		return outputStream.toByteArray();
	}
	
}
