package file;

import java.io.File;
import java.util.Date;

public class FileSample4 {

	private final static String UNIT_BYTE = "Byte";
	private final static String UNIT_KILO = "KByte";
	private final static String UNIT_MEGA = "MByte";
	private final static String UNIT_GIGA = "GByte";
	
	private final static long SIZE_KILO = 1024;
	private final static long SIZE_MEGA = 1024*1024;
	private final static long SIZE_GIGA = 1024*1024*1024;
	
	public static void main(String args[]){
		FileSample4 sample = new FileSample4();
		sample.printStaus("E:\\Test\\Chapter17");
		sample.printStaus("E:\\Test\\Chapter17\\system_log.txt");
	}

	public void printStaus(String pathName) {
		File file = new File(pathName);
		if(!file.exists())
			return;
		
		if(file.isDirectory()){
			System.out.println("Directory name : " + file.getName());
			System.out.println("Total : " + FileSample4.getSizeWithUnit(file.getTotalSpace()));
			System.out.println("Free : " + FileSample4.getSizeWithUnit(file.getFreeSpace()));
		}
		
		if(file.isFile()){
			Date lastModified = new Date(file.lastModified());
			long size = file.length();
			System.out.println("File name : " + file.getName());
			System.out.println("Last Modified Date : " + lastModified.toString());
			System.out.println("Size : " + FileSample4.getSizeWithUnit(size));
		}
	}

	private static String getSizeWithUnit(long size) {
		StringBuffer sb = new StringBuffer();
		
		if(size >= SIZE_GIGA)
			sb.append(size / SIZE_GIGA).append(" ").append(UNIT_GIGA);
		else if(size < SIZE_GIGA && size >= SIZE_MEGA)
			sb.append(size / SIZE_MEGA).append(" ").append(UNIT_MEGA);
		else if(size < SIZE_MEGA && size >= SIZE_KILO)
			sb.append(size / SIZE_KILO).append(" ").append(UNIT_KILO);
		else if(size < SIZE_KILO)
			sb.append(size / SIZE_MEGA).append(" ").append(UNIT_BYTE);
		
		return sb.toString();
	}
}
