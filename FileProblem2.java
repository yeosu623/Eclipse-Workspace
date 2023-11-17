import java.io.*;

public class FileProblem2 {

	public static void main(String[] args) {
		try {
			int c;
			String filename = "C:\\Temp\\data.dat";
			FileOutputStream fos = new FileOutputStream(filename);
			FileInputStream fis = new FileInputStream(filename);
			
			for(byte i = 1; i <= 10; i++)
				fos.write(i);
			
			while((c = fis.read()) != -1) {
				System.out.print(c + " ");
			}
			
			fos.close();
			fis.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

}
