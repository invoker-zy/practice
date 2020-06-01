package practice.file;

import java.io.File;

public class FileRename {
	public static void main(String[] args) {
		File file = new File("E:"+File.separator+"test");
		long start = System.currentTimeMillis();
		renameDir(file);
		long end = System.currentTimeMillis();
		System.out.println("操作耗时"+(end-start));
	}
	public static void renameDir(File file) {
		if(file.isDirectory()) {	//是一个目录
			File results [] = file.listFiles();	//列出子目录中的内容
			if(results != null) {
				for (int i = 0; i < results.length; i++) {
					renameDir(results[i]);
				}
			}
		} else {
			if(file.isFile()) {
				String fileName = null;
				if(file.getName().contains(".")) {
					fileName = file.getName().substring(0,file.getName().lastIndexOf("."))+".txt";
				} else {
					fileName = file.getName()+".txt";
				}
				File newFile = new File(file.getParentFile(),fileName);
				file.renameTo(newFile);
			}
		}
	}
}
