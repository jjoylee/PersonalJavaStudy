package File;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CopySample2 {
	
	public static void main(String[] args){
		CopySample2 sample = new CopySample2();
		sample.print("E:\\Test\\Chapter17\\system_gilbut.log");
	}

	private void print(String filePath) {
		File file = new File(filePath);
		if(!file.exists() && !file.isFile())
			throw new IllegalArgumentException("Argument should be text file");
		
		BufferedReader reader = null;
		try{
			reader = new BufferedReader(new FileReader(file));
			String tmp = null;
			while((tmp = reader.readLine()) != null){
				System.out.println(tmp);
			}
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			try{
				if(reader != null)
					reader.close();
			}catch(IOException ignorable){}
		}
		
	}
}
