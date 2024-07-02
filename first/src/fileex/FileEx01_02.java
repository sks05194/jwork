package fileex;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileEx01_02 {
	public static void main(String[] args) throws IOException {
		// \r : 캐리지리턴, 그 줄의 처음으로 이동하라는 의미
		// \n : 한 줄 바꿈의 의미
		// \r\n : 개행문자, 다음 줄의 처음으로 이동하라는 의미
		String currDir = System.getProperty("user.dir");
		System.out.println(currDir);
		File file = new File(currDir + "/test.txt");
		if (!file.exists())
			file.createNewFile();

		FileWriter fw = new FileWriter(file);
		char[] buf = { 'm', 'e', 's', 'a', 'g', 'e' };
		for (int i = 0; i < buf.length; i++)
			fw.write(buf[i]);

		fw.write("이 줄의 마지막에서 개행문자 \r\n");
		fw.close();

		FileReader fr = new FileReader(file);
		int EOF = -1;
		int c;
		while ((c = fr.read()) != EOF)
			System.out.print((char) c);
		fr.close();
	}
}