/**
 * 
 */
package excelConfiguration;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author admn
 *
 */
public class ExcelGenerator {

	XSSFWorkbook wb;

	// FileInputStream fis;

	public Object[][] getExcelData(String excelLocation, String sheetname) {

		// String path =
		// System.getProperty("user.dir")+"\\TestData\\Login.xlsx";

		try {
			File src = new File(excelLocation);

			FileInputStream fis = new FileInputStream(src);

			wb = new XSSFWorkbook(fis);

			System.out.println("=====================Excel Loaded============================");

			int rows = wb.getSheet(sheetname).getPhysicalNumberOfRows();
			
			System.out.println("The number of rows are: "+rows);

			int columns = wb.getSheet(sheetname).getRow(0).getLastCellNum();
			
			System.out.println("The number of columns are:"+columns);

			Object[][] arr = new Object[rows][columns];

			DataFormatter df = new DataFormatter();
			
			
			for (int i = 0; i < rows; i++) {

				for (int j = 0; j < columns; j++) {

					XSSFCell cell = wb.getSheet(sheetname).getRow(i).getCell(j);

					if (cell != null) {

						arr[i][j] = df.formatCellValue(cell);

					}

				}
			}
			
			return arr;

		} catch (Exception e) {

			System.out.println("=========================Unable to load excel======================");

			System.out.println(e.getMessage());
		}
		return null;

		

		
	}

}
