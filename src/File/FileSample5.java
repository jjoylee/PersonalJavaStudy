package File;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

public class FileSample5 {

	public static void main(String args[]){
		FileSample5 sample = new FileSample5();
		sample.printDirectoryInfo("./");
	}

	public void printDirectoryInfo(String path) {
		File file = new File(path);
		if(!file.exists() || !file.isDirectory())
			return;
		
		System.out.println("Path : " + file.getPath());
		System.out.println("Absolute Path : " + file.getAbsolutePath());
		try{
			System.out.println("Canonical Path : " + file.getCanonicalPath());
		}catch(IOException e){
			e.printStackTrace();
		}
		
		System.out.println("=========================");
		
		String[] fileList = file.list();
		for(String fileItem : fileList){
			System.out.println(" - " + fileItem);
		}
		
		System.out.println("=========================");
		
		fileList = file.list(new FilenameFilter(){
			@Override
			public boolean accept(File dir, String name) {
				// TODO Auto-generated method stub
				return name.startsWith(".git");
			}
		});
		
		for(String fileItem : fileList){
			System.out.println(" - " + fileItem);
		}
		
		System.out.println("=========================");
		
		File[] fileObject = file.listFiles((pathName) -> {
			return pathName.getName().startsWith(".");
		});
		
		for(File fileObj : fileObject){
			System.out.println(" - " + fileObj.getName());
		}
	}
}
