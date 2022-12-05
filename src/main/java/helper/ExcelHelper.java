package helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelHelper {
	private XSSFSheet sh;

	public ExcelHelper(String fileName, String sheetName) {
		try {
			File f = new File(System.getProperty("user.dir") + "\\" + fileName);
			FileInputStream fis = new FileInputStream(f);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			sh = wb.getSheet(sheetName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ArrayList<String> getKeysListFromFile() {
		ArrayList<String> keys = new ArrayList<>();
		for (int i = 1; i <= sh.getLastRowNum(); i++) {
			XSSFRow row = sh.getRow(i);
			XSSFCell cel = row.getCell(0);
			String kk = getCelValuesAccordingToCellType(cel);
			keys.add(kk);
		}
		return keys;
	}
	
	public ArrayList<String> getValuesListFromFile() {
		ArrayList<String> values = new ArrayList<>();
		for (int i = 1; i <= sh.getLastRowNum(); i++) {
			XSSFRow row = sh.getRow(i);
			XSSFCell cel = row.getCell(1);
			String kk = getCelValuesAccordingToCellType(cel);
			values.add(kk);
		}
		return values;
	}
	public HashMap<String, String> getKeyValuePairFromFile() {
		HashMap<String, String> data = new HashMap<>();
		for (int i = 1; i <= sh.getLastRowNum(); i++) {
			XSSFRow row = sh.getRow(i);
			XSSFCell cel = row.getCell(0);
			String k = getCelValuesAccordingToCellType(cel);
			cel = row.getCell(1);
			String v = getCelValuesAccordingToCellType(cel);
			data.put(k, v);
		}
		return data;
	}
	

	public ArrayList<String> getValuesFromRequiredColumn(int columnIndex)
	{
		ArrayList<String> keys = new ArrayList<>();
		for (int i = 1; i <= sh.getLastRowNum(); i++) {
			XSSFRow row = sh.getRow(i);
			XSSFCell cel = row.getCell(columnIndex);
			String kk = getCelValuesAccordingToCellType(cel);
			keys.add(kk);
		}
		return keys;
	}

	private static String getCelValuesAccordingToCellType(XSSFCell cel) {
		Object data = null;

		switch (cel.getCellType()) {
		case STRING:
			data = cel.getStringCellValue();
			break;
		case BOOLEAN:
			data = cel.getBooleanCellValue();
			break;
		case NUMERIC:
			data = cel.getNumericCellValue();
			break;
		case FORMULA:
			data = cel.getCellFormula();
			break;

		default:
			System.out.println("Can not decide cell type");
			break;
		}

		return data.toString();
	}

}
