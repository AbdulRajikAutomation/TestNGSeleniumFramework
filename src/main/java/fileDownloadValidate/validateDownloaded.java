package fileDownloadValidate;

import java.io.File;

public class validateDownloaded {

	public static void main(String[] args) {
		String downPath =System.getProperty("user.home")+"\\Downloads";
		System.out.println(downPath);
		File d = new File(downPath);
		File [] files = d.listFiles();
		for(File val : files) {
			String n = val.getName();
			System.out.println(n);
		}
	}

}
