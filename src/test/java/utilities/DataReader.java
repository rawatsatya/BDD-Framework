package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataReader {
	
	public static HashMap<String, String> storeValues = new HashMap<String, String>();

	public static List<HashMap<String, String>> data(String filepath, String sheetName) {
		
		List<HashMap<String, String>> mydata = new ArrayList<>();
		
		try {
			FileInputStream fs = new FileInputStream(filepath);
			XSSFWorkbook workbook = new XSSFWorkbook(fs);
			XSSFSheet sheet = workbook.getSheet(sheetName);
			Row HeaderRow = sheet.getRow(0);
			for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) 
				{
				Row currentRow = sheet.getRow(i);
				HashMap<String, String> currentHash = new HashMap<String, String>();
				for (int j = 0; j < currentRow.getPhysicalNumberOfCells(); j++) 
					{
					Cell currentCell = currentRow.getCell(j);
					switch (currentCell.getCellType()) 
						{
							case STRING:
								currentHash.put(HeaderRow.getCell(j).getStringCellValue(), currentCell.getStringCellValue());
							break;
						}
					}
				mydata.add(currentHash);
				}
			fs.close();
			} catch (Exception e) {
			e.printStackTrace();
		}
		return mydata;
	}
	
	
	public static HashMap<String, String> mydata(String filepath, String sheetname) throws Exception{
		
		HashMap<String, String> map = new HashMap<String, String>();
		ExcelUtility xlutil = new ExcelUtility(filepath);
		int row = xlutil.getRowCount(sheetname);
		xlutil.getCellCount(sheetname, 1);
		for(int i = 1;i<=row;i++) {
			map.put(xlutil.getCellData(sheetname, i, 0),xlutil.getCellData(sheetname, i, 1));
		}
		return map;
	} 
}
