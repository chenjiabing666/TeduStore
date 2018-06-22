
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Color;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import com.oracle.webservices.internal.api.EnvelopeStyle.Style;


public class TestXSSF {

		@Test
		public void test() throws Exception{
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
			
			XSSFSheet sheet=workbook.createSheet("第一张表");
			
			//加载合并单元格
			sheet.addMergedRegion(cellRangeAddress);
			sheet.setColumnWidth(0, 20*256);
			
			//创建第一行
			XSSFRow row1=sheet.createRow(0);
			XSSFCell cell=row1.createCell(4);
			cell.setCellStyle(cellStyle);
			cell.setCellValue("成绩统计表");
			
			XSSFRow row2=sheet.createRow(1);
			for (int i = 0; i < 10; i++) {
				row2.createCell(i).setCellValue("字段");
			}
			
			
			
			FileOutputStream outputStream=new FileOutputStream(new File("/home/chenjiabing/Documents/demo.xls"));
			workbook.write(outputStream);
			workbook.close();
			outputStream.close();
		}
		
		//设置cellstyle
		public XSSFCellStyle setCellStyle(XSSFWorkbook workbook){
			//创建单元格样式
			XSSFCellStyle cellStyle=workbook.createCellStyle();
			//设置水平居中
			cellStyle.setAlignment(HorizontalAlignment.CENTER);
			//设置垂直居中
			cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
			return cellStyle;
		}
		
		//设置字体样式
		public XSSFFont setFont(XSSFWorkbook workbook){
			//创建字体
			XSSFFont font=workbook.createFont();
			//设置字体
			font.setFontName("黑体");
			//设置为蓝色
			font.setColor(HSSFColor.BLUE.index);
			//设置字体的大小
			font.setFontHeightInPoints((short) 16);
			return font;
		}
}	
