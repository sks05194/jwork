package fileex;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FileEx08 {
	public static void main(String[] args) throws Exception {
		// 파일 출력용
		FileOutputStream fos1 = new FileOutputStream("C:/jwork/out_utf8.txt", true);
		FileOutputStream fos2 = new FileOutputStream("C:/jwork/out_ansi.csv");

		// ANSI 계열 인코딩 유형 - ms949 : 확장완성형
		// 한글 깨짐을 보완하려면 ms949를 사용하는 것이 좋다.
		// unicode 기반의 인코딩 유형 - utf-8 : 조합형
		OutputStreamWriter osw1 = new OutputStreamWriter(fos1, "utf-8");
		OutputStreamWriter osw2 = new OutputStreamWriter(fos2, "ms949");

		int c;

		System.out.println("아무 내용이나 입력하세요. 꼭 엔터를 해 주어야만 글이 입력됩니다.\n종료를 원하시면 ctrl+z를 눌러주세요");
		InputStreamReader isr = new InputStreamReader(System.in);
		while ((c = isr.read()) != -1) {
			osw1.write(c);
			osw2.write(c);
		}

		System.out.println("작업 완료\n");

		// 닫을 때는 꼭 선언된 순서의 역순으로 닫아준다.
		// 서로 독립적인 객체는 선언 순서 상관없이 닫아줘도 상관없다.
		osw1.close();
		fos1.close();
		
		osw2.close();
		fos2.close();
		
		isr.close();

		FileInputStream fis = new FileInputStream("C:/jwork/out_ansi.csv");
		isr = new InputStreamReader(fis, "ms949");
		c = 0;
		while ((c = isr.read()) != -1)
			System.out.print((char) c);

		System.out.println();
		System.out.println("출력 끝");

		isr.close();
		fis.close();
	}
}