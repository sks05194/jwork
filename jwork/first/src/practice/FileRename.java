package practice;

import java.io.File;

public class FileRename {
	public static void main(String[] args) {
		String dir = "C:/Users/hi/Desktop/lottos/";
		File dirFile = new File(dir);

		if (!dirFile.isDirectory()) {
			System.out.println("찾고자하는 폴더가 존재하지 않습니다.");
			return;
		}

		File[] files = dirFile.listFiles();

		if (files.length == 0) {
			System.out.println("폴더 내에 파일이 존재하지 않습니다.");
			return;
		}

		for (File f : files) {
			String oldName = f.getName();
			String newName = oldName.replace("0701_로또_", "Lotto_").replace("txt", "java");

			if (oldName != newName)
				if (f.renameTo(new File(dir + newName)))
					System.out.println(newName + "으로 파일 이름 변경 완료");
				else
					System.out.println(oldName + " 파일 이름 변경 실패");
			else
				System.out.println(oldName + " 파일 변경 보류");
		}
	}
}