package cn.tedu.store.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/upload")
public class UploadController {
	
	@RequestMapping("/showUpload.do")
	public String showUpload(){
		return "upload";
	}
	
	@RequestMapping("/upload.do")
	public String uplaod(MultipartFile file) throws IllegalStateException, IOException{
		String fileName=file.getOriginalFilename();  //获取文件名
		Long fileSize=file.getSize();   //获取文件大小
		//上传  参数是文件上传后储存的路径，最终的文件上传后的文件路径为/home/chenjiabing/Documents/Blog/fileName
		file.transferTo(new File("/home/chenjiabing/Documents/Blog",fileName));
		//重定向到首页
		return "redirect:../main/showIndex.do";
	}
	
	/**
	 * 文件下载
	 * @param fileName  文件名
	 * @param request  
	 * @throws IOException
	 */	
	@RequestMapping("/download.do")
	public ResponseEntity<byte[]> download(@RequestParam("fileName")String fileName,HttpServletRequest request) throws IOException{
		//获取下载文件的路径，在文件中的真实路径
		String path=request.getServletContext().getRealPath("/upload/");
		//下载文件的全路径
		File file=new File(path+File.separator+fileName);
		HttpHeaders headers = new HttpHeaders();  
        //下载显示的文件名，解决中文名称乱码问题  
        String downloadFielName = new String(fileName.getBytes("UTF-8"),"iso-8859-1");
        //通知浏览器以attachment（下载方式）打开图片
        headers.setContentDispositionFormData("attachment", downloadFielName); 
        //application/octet-stream ： 二进制流数据（最常见的文件下载）。
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),    
                headers, HttpStatus.CREATED); 
	}
}
