package cn.tedu.store.utils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XSSFUtils {
	
	public static byte[] getExcel(String sheetName,String heandName,List<String> title,List<Object> objects) throws Exception{
		//创建工作簿
		XSSFWorkbook workbook=new XSSFWorkbook();

		//合并单元格  第一行第5列到第一行第10列
		CellRangeAddress cellRangeAddress=new CellRangeAddress(0,0,4,9);
		
		//设置style
		XSSFCellStyle cellStyle=setCellStyle(workbook);
		
		//设置字体的样式
		XSSFFont font=setFont(workbook);
		
		//字体的样式作用cellstyle
		cellStyle.setFont(font);
		
		XSSFSheet sheet=workbook.createSheet(sheetName);
		
		//加载合并单元格
		sheet.addMergedRegion(cellRangeAddress);
		sheet.setColumnWidth(0, 20*256);
		
		//创建第一行
		XSSFRow row1=sheet.createRow(0);
		XSSFCell cell=row1.createCell(4);
		cell.setCellStyle(cellStyle);
		//设置表的标题
		cell.setCellValue(heandName);
		
		//创建第二行
		XSSFRow row2=sheet.createRow(1);
		//设置表的属性字段
		for (int i = 0; i < title.size(); i++) {
			row2.createCell(i).setCellValue(title.get(i));
		}
		
		
		
		//创建内存操作流
		ByteArrayOutputStream outputStream=new ByteArrayOutputStream();
		//写入流
		workbook.write(outputStream);
		workbook.close();
		outputStream.close();
		return outputStream.toByteArray();
		
	}

	// 设置cellstyle
	public static XSSFCellStyle setCellStyle(XSSFWorkbook workbook) {
		// 创建单元格样式
		XSSFCellStyle cellStyle = workbook.createCellStyle();
		// 设置水平居中
		cellStyle.setAlignment(HorizontalAlignment.CENTER);
		// 设置垂直居中
		cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
		return cellStyle;
	}

	// 设置字体样式
	public static XSSFFont setFont(XSSFWorkbook workbook) {
		// 创建字体
		XSSFFont font = workbook.createFont();
		// 设置字体
		font.setFontName("黑体");
		// 设置为蓝色
		font.setColor(HSSFColor.BLUE.index);
		// 设置字体的大小
		font.setFontHeightInPoints((short) 16);
		return font;
	}

}
