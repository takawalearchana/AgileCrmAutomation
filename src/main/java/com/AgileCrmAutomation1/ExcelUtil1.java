package com.AgileCrmAutomation1;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil1 
{
	//method to get file extension based on the provided file path
	private String getFileExtension(String filePath)
	{
		//get file path extension
		String extension=filePath.substring(filePath.indexOf("."));
		System.out.println(extension);
		return extension;
	}
	//Method to get workbook instance based on the provided file path
	protected Workbook getWorkbookInstance(String filePath) throws IOException
	{
		Workbook wb;
		FileInputStream input=new FileInputStream(filePath);
		//Based on the file extension,take the control of workbook
		if(getFileExtension(filePath).equals(".xlsx"))
		{
			wb=new XSSFWorkbook(input);
		}
		else
		{
			wb=new HSSFWorkbook(input);
		}
		return wb;
	}
	//method to get sheet reference from the workbook instance
	private Sheet getSheet(String filePath, String sheetName)
	{
		Sheet sheet=null;
		try
		{
			Workbook wb=getWorkbookInstance(filePath);
			sheet=wb.getSheet(sheetName);
		}
		catch(IOException e)
		{
		  e.printStackTrace();
		}
		return sheet;
	}
  //This method will return the excel file data in two dimensional array that is Object[][] based on provided filePath and sheetname
  // @Parameters filePath	
  // @Parameters sheetName
	public Object[][] getExcelData(String filePath,String sheetName)
	{
		Sheet sheet=getSheet(filePath,sheetName);
		int totalRow =sheet.getPhysicalNumberOfRows();
		int totalColumn =sheet.getRow(0).getPhysicalNumberOfCells();
		return getCellValue(sheet,totalRow,totalColumn);
		}
	//this method will returns the value from each cell of excel value
	private Object[][] getCellValue(Sheet sheet,int totalRows,int totalColumns)
	{
		Object[][] value=new Object[totalRows][totalColumns];
		for (int i=1;i<totalRows;i++)
		{
			//take the control on rows based on the i value
			Row row=sheet.getRow(i);
			for(int j=0;j<totalColumns;j++)
			{
			//take the control of cell using row reference 
				Cell cell=row.getCell(j);
				CellType type=cell.getCellType();
				switch (type)
				{
				case STRING:
					value[i][j]=cell.getStringCellValue();
					break;
				case NUMERIC:
					value[i][j]=cell.getNumericCellValue();
					break;
				case BOOLEAN:
					value[i][j]=cell.getBooleanCellValue();
					break;
				case _NONE:
					value[i][j]=null;
					break;
				case BLANK:
					value[i][j]=null;
					break;
				default:
					value[i][j]=null;
				
				}
			}
		}
	return value;
	}
	public static void main(String[]args)
	{
	 String filePath="E:\\Selenium Test cases\\AutomationTestData.xlsx";
	 ExcelUtil1 excel=new ExcelUtil1();
	 Object[][] data=excel.getExcelData(filePath, "TestData");
	 int rowLength = data.length;
	 int columnLength=data[0].length;
	 for (int i=1;i<=rowLength-1;i++)
	 {
		 for(int j=0;j<columnLength;j++)
		 {
			 System.out.print(data[i][j]+" ");
		 }
   System.out.println();
	 }
	
  }
}
