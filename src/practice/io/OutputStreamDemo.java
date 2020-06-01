package practice.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class OutputStreamDemo {
	public static void main(String[] args) throws Exception{
		File file = new File("e:"+ File.separator + "hello" + File.separator + "test.txt");
		if(!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}
		String str = "abc";
		OutputStream out = new FileOutputStream(file);
		out.write(str.getBytes());
		out.close();
	}
}
