package java_20190806;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import Bonus.Utility;

public class CrawlingThread extends Thread {
	private String coinName;
	private String fileName;

	public CrawlingThread(String coinName, String fileName) {
		this.coinName = coinName;
		this.fileName = fileName;
	}

	@Override
	public void run() {
		while (true) {
			Document doc = null;
			String url = "https://coinmarketcap.com/currencies/" + coinName
					+ "/historical-data/?start=20190101&end=20190806";

			try {
				doc = Jsoup.connect(url).get();

				System.out.println("Clear!");
				System.out.println(
						"*************************************************************************************************************************");
				System.out.println("Date\tOpen\tHigh\tLow\tClose\tVolume\tMarket Cap");

				Elements bodyElements = doc.select(".table-responsive .table tbody tr");

				HSSFWorkbook workbook = new HSSFWorkbook(); // 새 엑셀파일 생성
				HSSFSheet sheet = workbook.createSheet("새 파일"); // 새 시트 생성
				HSSFRow row = null;
				HSSFCell cell = null;

				row = sheet.createRow(0);
				cell = row.createCell(0);
				cell.setCellValue("Date");

				cell = row.createCell(1);
				cell.setCellValue("Open");

				cell = row.createCell(2);
				cell.setCellValue("High");

				cell = row.createCell(3);
				cell.setCellValue("Low");

				cell = row.createCell(4);
				cell.setCellValue("Close");

				cell = row.createCell(5);
				cell.setCellValue("Volume");

				cell = row.createCell(6);
				cell.setCellValue("MarketCap");

				for (int i = 0; i < bodyElements.size(); i++) {
					int index = 0;
					Element trElement = bodyElements.get(i);

//					Element dateElement = trElement.child(0);
					String date = trElement.child(index++).text();
					date = Utility.getKoreanDate(date);

//					Element openElement = trElement.child(1);
					String open = trElement.child(index++).text();

//					Element highElement = trElement.child(2);
					String high = trElement.child(index++).text();

//					Element lowElement = trElement.child(3);
					String low = trElement.child(index++).text();

//					Element closeElement = trElement.child(4);
					String close = trElement.child(index++).text();

//					Element volumeElement = trElement.child(5);
					String volume = trElement.child(index++).text();

//					Element marketcapElement = trElement.child(6);
					String marketcap = trElement.child(index++).text();

					System.out.printf("%s \t %s \t %s \t %s \t %s \t %s \t %s \n", date, open, high, low, close, volume,
							marketcap);

					row = sheet.createRow(i + 1);
					cell = row.createCell(0);
					cell.setCellValue(date);

					cell = row.createCell(1);
					cell.setCellValue(open);

					cell = row.createCell(2);
					cell.setCellValue(high);

					cell = row.createCell(3);
					cell.setCellValue(low);

					cell = row.createCell(4);
					cell.setCellValue(close);

					cell = row.createCell(5);
					cell.setCellValue(volume);

					cell = row.createCell(6);
					cell.setCellValue(marketcap);
				}

				FileOutputStream fos = new FileOutputStream("C:\\dev\\test\\" + fileName + "");
				workbook.write(fos);
				fos.close();
				workbook.close();
				System.out.println("Clear!");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			try {
				Thread.sleep(1000 * 60 * 60);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}