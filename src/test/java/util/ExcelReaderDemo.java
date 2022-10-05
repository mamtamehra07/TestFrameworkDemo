package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReaderDemo {

	public static void main(String[] args) throws IOException {

		String excelFilePath = ".\\src\\test\\resources\\testData\\TestData.xlsx";
		FileInputStream ip = new FileInputStream(excelFilePath);

		try (XSSFWorkbook workbook = new XSSFWorkbook(ip)) {
			XSSFSheet sheet = workbook.getSheetAt(0);

			// using for loop to iterate sheet

			int rows = sheet.getLastRowNum();
			int cols = sheet.getRow(1).getLastCellNum();

			/*
			 * for(int r=0;r<=rows;r++) { XSSFRow row = sheet.getRow(r);
			 * 
			 * 
			 * for(int c=0;c<cols;c++) { XSSFCell cell = row.getCell(c);
			 * 
			 * //find data type of the cell to extract value from cell
			 * 
			 * switch (cell.getCellType()) {
			 * 
			 * 
			 * case STRING: System.out.println(cell.getStringCellValue()); break;
			 * 
			 * 
			 * case NUMERIC: System.out.println(cell.getNumericCellValue()); break;
			 * 
			 * case BOOLEAN: System.out.println(cell.getBooleanCellValue()); break;
			 * default:System.out.println(cell.getStringCellValue()); break;
			 * 
			 * } System.out.print(" | "); } System.out.println(); }
			 */

			// Looping using Iterator interface
			Iterator itr = sheet.iterator();

			while (itr.hasNext()) {
				XSSFRow row = (XSSFRow) itr.next();
				Iterator citr = row.cellIterator();

				while (citr.hasNext()) {
					XSSFCell cell = (XSSFCell) citr.next();

					switch (cell.getCellType()) {

					case STRING:
						System.out.println(cell.getStringCellValue());
						break;

					case NUMERIC:
						System.out.println(cell.getNumericCellValue());
						break;

					case BOOLEAN:
						System.out.println(cell.getBooleanCellValue());
						break;
					default:
						System.out.println(cell.getStringCellValue());
						break;
					}

					System.out.print(" | ");
				}

				System.out.println();

			}

		}
	}
}
