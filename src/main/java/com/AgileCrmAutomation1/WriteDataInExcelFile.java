package com.AgileCrmAutomation1;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class WriteDataInExcelFile extends ExcelUtil
{
	//To add data into excel file
	public void setDataExcel( String filePath,String sheetName, int rowNum,int cellNum,Object value)
	{
	try
	{
		//Workbook wb=getWorkbookInstance(filePath);
		Sheet sheet;
		//get the sheet details if it is present in the workbook
		if(wb.getSheet(sheetName)!=null)
		{
			sheet=wb.getSheet(sheetName);
		}
		else {
			//create new sheet in the workbook
			sheet=wb.createSheet(sheetName);
		}
		//create cell if not present else get the cell control
		 Row row;
		 if(sheet.getRow(rowNum)!=null)
			{
				row=sheet.getRow(rowNum);
			}
			else
			{
				row=sheet.createRow(rowNum);
			}
		 Cell cell;
		if(row.getCell(cellNum)!=null)
		{
			cell=row.getCell(cellNum);
		}
		else
		{
			cell=row.createCell(cellNum);
		}
	setCellValue(cell,value);
	FileOutputStream output=new FileOutputStream(filePath);
	wb.write(output);
	wb.close();
	}
	catch(IOException e)
	{
		e.printStackTrace();
	}

	}

public void setCellValue(Cell cell,Object val)
{
	if(val instanceof Integer)
	{
		cell.setCellValue((int) val);
	}
	else if(val instanceof String)
	{
		cell.setCellValue(val.toString());
	}
	else if(val instanceof Boolean)
	{
		cell.setCellValue((boolean)val);
	}
}
/* @DataProvider(name="getData")
public Object[][]getTestData()
{
String filePath= "E:\\Selenium Test cases\\AutomationTestDataxlsx";
ExcelUtil excelValues = new ExcelUtil();
Object[][] data=excelValues.getExcelData(filePath,"Data");
return data;
}
@Test(dataProvider="getData")
public void loginTestCase(Object username,Object password)
{
	System.out.println(username+" : "+ password);
}
*/
}
