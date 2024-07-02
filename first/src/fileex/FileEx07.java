package fileex;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class FileEx07 {
	public static void main(String[] args) {
		try {
			OutputStream output = new FileOutputStream("C:/jwork/Output.txt");
			String str = "오늘 날씨는 아주 덥습니다.";
			byte[] by = str.getBytes();

			output.write(by);
			output.close();

			FileInputStream fis = new FileInputStream("C:/jwork/Output.txt");
			InputStreamReader isr = new InputStreamReader(fis);
			int c;
			while ((c = isr.read()) != -1)
				System.out.print((char) c);
			// 역순으로 닫아주어야 한다.
			isr.close();
			fis.close();

			System.out.println();
			System.out.println("작업 완료\n");
		} catch (Exception e) {
			e.getStackTrace();
		}
		System.out.println("프로그램 종료");
	}
}