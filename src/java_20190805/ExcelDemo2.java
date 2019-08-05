package java_20190805;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
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
		FileWriter fw = null;
		BufferedWriter bw = null;
		
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("새 파일");
		HSSFRow row = sheet.createRow(0);
		HSSFCell cell = row.createCell(0);
		cell.setCellValue(data[i]);
		cell = row.createCell(1);
		
		
		try {
			fr = new FileReader("C:\\dev\\test\\test1.txt");
			br = new BufferedReader(fr);
			
			
			FileOutputStream fos = new FileOutputStream("C:\\dev\\test\\test2.xls");
			workbook.write(fos);
			String readLine = null;
			
			while ((readLine = br.readLine()) != null) {
				String[] data = readLine.split("#");
				
				for (int i = 0; i < readLine.length(); i++) {
					data[i] = br.readLine();
				}
			}
			fos.close();
			System.out.println("Clear!");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fr != null) fr.close();
				if (br != null) br.close();
				if (fw != null) fw.close();
				if (bw != null) bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}