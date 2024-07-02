package fileex;

import java.io.File;

public class FileEx09 {
	public static void main(String[] args) {
		try {
			File f = new File("C:/jwork/first/src/fileEx", "FileEx01_00.java");

			System.out.println(f.getName());
			System.out.println(f.exists());
			System.out.println(f.length());

//			boolean result = new File("C:/jwork/Exam/log").mkdir();
//			boolean result = new File("C:/jwork/Exam").mkdir();
			boolean result = new File("C:/jwork/Exam/log").mkdirs();

			if (result)
				System.out.println("Exam 디렉토리 생성 성공");
			else
				System.out.println("Exam 디렉토리 생성 실패");

			String[] listing = new File("C:/jwork/Exam").list();
			for (String x : listing)
				System.out.println("디렉토리 목록 : " + x);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}