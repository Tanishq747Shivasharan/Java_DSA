import java.io.*;

public class ReversingFileContent {
    public static void main(String[] args) {
        String file = "Content.txt";
        String revfile = "Output.txt";

        try (BufferedReader r = new BufferedReader(new FileReader(file));
             BufferedWriter w = new BufferedWriter(new FileWriter(revfile))) {
            String line;
            System.out.println("Reversed file content:");
            while((line = r.readLine()) != null) {
                String reversed = "";
                int i = line.length() - 1;
                while(i >= 0) {
                    reversed += line.charAt(i);
                    i--;
                }
                w.write(reversed);
                w.newLine();
            } 
            System.out.println("File reversed successfully");
        }
        catch(IOException e) {
            System.out.println("Error reading file: "+e.getMessage());
        } 
    }
}
