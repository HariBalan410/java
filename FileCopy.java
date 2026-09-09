import java.io.*;
public class FileCopy {
    public static void main(String[] args) {
        String source = "input.txt";
        String destination = "output.txt";
        try {
            FileInputStream fin = new FileInputStream(source);
            FileOutputStream fout = new FileOutputStream(destination);
            int ch;
            while ((ch = fin.read()) != -1) {
                fout.write(ch);
            }
            fin.close();
            fout.close();
            System.out.println("File copied successfully.");
            System.out.println("Destination File Created: " + destination);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
