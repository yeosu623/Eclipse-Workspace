import java.io.*;

public class FileProblem1 {

	public static void main(String[] args) {
		try {
			int c;
			String filename = "C:\\Temp\\ganada.txt";
			FileReader fr = new FileReader(filename);
			
			while((c = fr.read()) != -1)
				System.out.print((char)c);
			
			fr.close();
		} catch(IOException e) {
			e.printStackTrace();
		}

	}

}
