package assignment6;

import java.io.*;


public class CopyFiles {
	
	public static void main(String[] args) throws InterruptedException, IOException {
		File source_file = new File(args[0]);
		File target_file = new File(args[1]);
		InputStream in = null;
		OutputStream out = null;
		in = new FileInputStream(source_file);
		out = new FileOutputStream(target_file);
		byte[] buffer = new byte[1024];
		int length;
		while ((length = in.read(buffer)) > 0){
			out.write(buffer, 0, length);
		}
		
	}

}
