package file;

import java.io.File;
import java.io.IOException;

public class FileSample2 {

	public static void main(String args[]){
		FileSample2 sample = new FileSample2();
		String path = "E:\\Test\\Chapter17";
		String logPrefix = "System_";
		String tracePrefix = "trace_";
		String suffix = ".log";
		
		File tempTraceFile = sample.createTempFile(path,tracePrefix,suffix);
		File tempLogFile = sample.createTempFile(path, logPrefix, suffix);
		if(tempTraceFile == null || tempLogFile == null)
			System.out.println("fail to create");
		
		System.out.println("success to create : " + tempTraceFile.getName());
		System.out.println("success to create : " + tempLogFile.getName());
		
		tempLogFile.deleteOnExit();
	}

	private File createTempFile(String path, String prefix, String suffix) {
		File tempDir = new File(path);
		if(!tempDir.exists())
			tempDir.mkdirs();
		
		File tempFile = null;
		try{
			tempFile = File.createTempFile(prefix, suffix, tempDir);
		}catch(IOException e){
			e.printStackTrace();
		}
		return tempFile;
	}
}
