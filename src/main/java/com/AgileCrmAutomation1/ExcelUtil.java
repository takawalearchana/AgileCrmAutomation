package com.AgileCrmAutomation1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	static Workbook wb;
	public static void main(String[] args) throws IOException {
		//File path
		String filePath="E:\\Selenium Test cases\\AutomationTestData.xlsx";
		//get the file path extension
		String extension=filePath.substring(filePath.indexOf("."));
		System.out.println(extension);
		//get the control of excel file
		FileInputStream input=new FileInputStream(filePath);
		//Based on the file extension,take the control of workbook
		if(extension.equals(".xlsx"))
		{
			wb=new XSSFWorkbook(input);
		}
		else
		{
			wb=new HSSFWorkbook(input);
		}
		//take the control on sheet using workbook reference
		Sheet sheet=wb.getSheet("TestData");
		//get total number of rows from the sheet
		int totalRows=sheet.getPhysicalNumberOfRows();
		int totalColumns=sheet.getRow(0).getPhysicalNumberOfCells();
		for(int i=1;i<totalRows;i++)
		{
			//take the control on rows based on the i value
			Row row=sheet.getRow(i);
			for(int j=0;j<totalColumns;j++)
			{
				//take the control of cells using row reference
				Cell cell=row.getCell(j);
				//get the cell value using cell reference
				String value=cell.getStringCellValue();
				System.out.println(value);
			}
		}
		wb.close();
		input.close();
	}
	}
