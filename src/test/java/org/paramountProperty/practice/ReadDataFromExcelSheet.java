package org.paramountProperty.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelSheet {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// Step 1 :read the file using file inputStream
		FileInputStream fis = new FileInputStream(".\\Data\\Book1.xlsx");
		
		// step 2:create workbook
		Workbook workbook = WorkbookFactory.create(fis);
		
		// step3 : load the sheet
		Sheet sh = workbook.getSheet("Sheet1");
		
		// step4 :navigate to row
		Row row = sh.getRow(1);
		
		// step5 :navigate to the cell
		Cell cell = row.getCell(2);
		
		// step 6: read the value inside the cell
		System.out.println(cell.getStringCellValue());

	}

}
