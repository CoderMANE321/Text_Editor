package textEditor;

import Structs.Stack;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class OpenEditor {
    static String filePath = "text.txt";
    static String directoryPath = "tmp/";
    static Scanner scan = new Scanner(System.in);
    static FileHandler fileHandler = new FileHandler();
    static Stack stack = new Stack(10);

    public static void fileOverWrite() {
        try {
            String fileInput = scan.nextLine();
            FileWriter myWriter = new FileWriter(filePath);
            myWriter.write(fileInput);
            myWriter.close();
            stack.push(filePath);
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
            FileWriter tempWriter = new FileWriter(directoryPath + filePath);
            tempWriter.write(existingText);
            tempWriter.close();
            myWriter.write(existingText + fileInput);
            myWriter.close();
            stack.push(filePath);
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

    public static void undoFIle() {
        stack.pop();
    }

    public static void redoFIle() {
        stack.push(directoryPath + filePath);
    }
}

