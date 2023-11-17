import java.io.*;

public class FileProblem3 {

	public static void main(String[] args) {
		try {
			int b[] = {7, 51, 3, 4, -1, 24};
			int c;
			String filename = "C:\\Temp\\test.dat";
			FileOutputStream fos = new FileOutputStream(filename);
			FileInputStream fis = new FileInputStream(filename);
			
			for(byte i = 0; i < b.length; i++)
				fos.write(b[i]);
			
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
