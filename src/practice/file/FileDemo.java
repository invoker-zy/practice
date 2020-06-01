package practice.file;

import java.io.File;

public class FileDemo {
	public static void main(String[] args) throws Exception{
		File file = new File("e:"+File.separator+"demo1"+File.separator+"test.txt");
		if(!file.getParentFile().exists()) {	//父路径不存在
			file.getParentFile().mkdirs();
		}
		if(file.exists()) {
			file.delete();
			System.out.println("文件已删除");
		} else {
			file.createNewFile();
			System.out.println("文件已创建");
		}
	}
}
