package practice.io;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;

public class WriterDemo {
	public static void main(String[] args) throws Exception{
		File file = new File("e:"+ File.separator + "hello" + File.separator + "test.txt");
		if(!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}
		Writer out = new FileWriter(file);
		String str = "Œ“\n";
		out.write(str);
		out.append("cc");
		out.close();
	}
}
