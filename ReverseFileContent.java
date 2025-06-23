import java.io.*;

public class ReverseFileContent {

      
    public static void main(String[] args) {
        String inputFilePath = "large_input.txt";
        String outputFilePath = "reversed_output.txt";



        try {
            processFile(inputFilePath, outputFilePath);
            System.out.println("File reversed successfully!");
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }

      

    public static void processFile(String inputPath, String outputPath) throws IOException {
        try (BufferedReader r = new BufferedReader(new FileReader(inputPath));
             BufferedWriter w = new BufferedWriter(new FileWriter(outputPath))) {



            String line;
            while ((line = r.readLine()) != null) {
                String reversedLine = reverseLine(line);
                writeLine(w, reversedLine);
            }
        }
    }

      

    public static String reverseLine(String line) {
        return new StringBuilder(line).reverse().toString();
    }

      

    public static void writeLine(BufferedWriter w, String line) throws IOException {
        w.write(line);
        w.newLine();
    }
}