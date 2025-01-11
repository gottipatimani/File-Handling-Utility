import java.io.*;
import java.nio.file.*;

public class FileHandlingUtility {
    public static void writeToFile(String filePath, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(content);
            writer.newLine();
            System.out.println("Content written to file.");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
    public static String readFromFile(String filePath) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append(System.lineSeparator());
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return content.toString();
    }
    public static void listFiles(String directoryPath) {
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(directoryPath))) {
            for (Path path : stream) {
                System.out.println(path.getFileName());
            }
        } catch (IOException e) {
            System.err.println("Error listing files: " + e.getMessage());
        }
    }
    public static void main(String[] args) {
        String filePath = "Peta.txt";
        writeToFile(filePath, "Welcome To Muthayammal Engineering College");
        String content = readFromFile(filePath);
        System.out.println("File Content:\n" + content);
        System.out.println("Files in directory:");
        listFiles(".");
    }
}