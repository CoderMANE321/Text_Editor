package textEditor;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class OpenEditor {
    static String filePath = "text.txt";
    static Scanner scan = new Scanner(System.in);
    static FileHandler fileHandler = new FileHandler();
    public static void fileOverWrite() {
        try {
            String fileInput = scan.nextLine();
            FileWriter myWriter = new FileWriter(filePath);
            myWriter.write(fileInput);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void fileAppend(){
        String existingText = FileHandler.readFile();
        try {
            String fileInput = scan.nextLine();
            FileWriter myWriter = new FileWriter(filePath);
            myWriter.write(existingText + fileInput);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void fileClear() {
        fileHandler.deleteFile();
        fileHandler.fileCreator();
    }
}

