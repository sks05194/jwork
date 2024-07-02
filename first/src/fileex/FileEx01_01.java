package fileex;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileEx01_01 {
	public static void main(String[] args) throws IOException {
		String path = "C:/upload";
		File file = new File(path);
		if (!file.isDirectory())
			file.mkdirs();
//		if(!file.exists()) file.mkdirs();
		path = path + "/file.txt";

		// FileWriter(file, true); true는 뒷 줄에 추가됨.
		// 디폴트는 false임. false는 덮어쓰기 됨.
		FileWriter fw = new FileWriter(path, true);
		fw.write("FileWriter는 한글로 된 " + "\n");
		fw.write("문자열을 바로 출력할 수 있다." + "\n");
		fw.flush();
		fw.close(); // close에는 flush가 숨겨져있다.

		System.out.println("파일에 저장되었습니다.");
	}
}