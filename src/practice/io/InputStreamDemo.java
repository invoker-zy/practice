package practice.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class InputStreamDemo {
	public static void main(String[] args) throws Exception{
		File file = new File("e:"+ File.separator + "hello" + File.separator + "test.txt");
		InputStream input = new FileInputStream(file);
		byte data[] = new byte[1024]; 
		int len = input.read(data);
		System.out.println("¡¾"+new String(data,0,len)+"¡¿");
		input.close();
	}
}
