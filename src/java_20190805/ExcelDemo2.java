package java_20190805;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

// 1. C:\\dev\\test\\test1.txt 읽어온다. BufferedReader(); 로
// 2. BufferedReader의 readLine() 메서드를 이용해서 한줄씩 읽어온다.
// 3. 한 줄 읽은 문자열을 String의 split("#");을 이용해서 String[] 반환한다.
// 4. [0] => cell에 입력한다. [1] => cell에 입력한다.
// 	  [2] => cell에 입력한다. [3] => cell에 입력한다.
//	  2 ~ 4의 과정을 반복하여 엑셀에 입력한다. 
// 6. 엑셀 파일명 : C:\dev\test\test2.xls 파일로 저장한다.

public class ExcelDemo2 {
	public static void main(String[] args) {
		FileReader fr = null;
		BufferedReader br = null;
		String readLine = null;
		FileOutputStream fos = null;
		int rowIndex = 0;
		HSSFRow row = null;
		HSSFCell cell = null;
		
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("새 파일");		
		
		try {
			fr = new FileReader("C:\\dev\\test\\test1.txt");
			br = new BufferedReader(fr);
			
			while((readLine = br.readLine()) != null) {
				row = sheet.createRow(rowIndex++);
				String[] data = readLine.split("#");
				for (int i = 0; i < data.length; i++) {
					cell = row.createCell(i);
					cell.setCellValue(data[i]);
				}
			}
			
			fos = new FileOutputStream("C:\\dev\\test\\test2.xls");
			workbook.write(fos);
			fos.close();
			System.out.println("Clear!");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fr != null) fr.close();
				if (br != null) br.close();
				if (fos != null) fos.close();
				if (workbook != null) workbook.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}