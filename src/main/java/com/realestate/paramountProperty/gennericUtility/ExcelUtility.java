package com.realestate.paramountProperty.gennericUtility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	public String getExcelData(String sheetName, int rowNum, int celNum)	throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(IConstatants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		String value = wb.getSheet(sheetName).getRow(rowNum).getCell(celNum).getStringCellValue();
		return value;

	}

}
