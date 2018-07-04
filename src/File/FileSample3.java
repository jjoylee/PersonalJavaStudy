package file;

import java.io.File;

public class FileSample3 {
	
	public static void main(String args[]){
		FileSample3 sample3 = new FileSample3();
		
		String filePath = "E:\\Test\\Chapter17\\system_log.txt";
		sample3.testPermission(filePath);
	}

	public void testPermission(String filePath) {
		File file = new File(filePath);
		
		if(!file.exists()){
			System.out.println("No file at : " + filePath);
			return;
		}
		
		file.setReadOnly();
		System.out.println("permission to execute : " + file.canExecute());
		System.out.println("permission to read : " + file.canRead());
		System.out.println("permission to write : " + file.canWrite());
	}
}
