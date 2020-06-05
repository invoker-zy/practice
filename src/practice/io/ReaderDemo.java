package practice.io;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;

public class ReaderDemo {
	public static void main(String[] args) throws Exception{
		File file = new File("e:"+ File.separator + "hello" + File.separator + "test.txt");
		if(file.exists()) {
			Reader in = new FileReader(file);
			char data[] = new char[1024];
			int len = in.read(data);
			System.out.println("¶ÁÈ¡ÄÚÈÝ£º"+new String(data,0,len));
			in.close();
		}
	}
}
