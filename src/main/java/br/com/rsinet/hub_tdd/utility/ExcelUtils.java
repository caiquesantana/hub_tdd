package br.com.rsinet.hub_tdd.utility;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	private static XSSFSheet ExcelWSheet;

	private static XSSFWorkbook ExcelWBook;

	private static XSSFCell cell;

	//private static XSSFRow Row;

	public static void setExcelFile(String path, String sheetName) throws Exception {

		try {
			FileInputStream excelFile = new FileInputStream(path);

			ExcelWBook = new XSSFWorkbook(excelFile);

			ExcelWSheet = ExcelWBook.getSheet(sheetName);

		} catch (Exception e) {

			throw (e);
		}
	}

public static String getCellData(int linha, int coluna) throws Exception{
	 
    try{

        cell = ExcelWSheet.getRow(linha).getCell(coluna);

        String cellData = cell.getStringCellValue();

        return cellData;

        }catch (Exception e){

return"";

}
    
}

}