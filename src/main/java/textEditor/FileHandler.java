package textEditor;

import Structs.Stack;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


public class FileHandler {
    static String filePath = "text.txt";
    static String directoryPath = "tmp/";
    static String redoFilePath = "redo.txt";
    static  String undoFilePath = "undo.txt";
    Stack stack = new Stack(10);
    public static void fileCreator(){
        try {
            File file = new File(filePath);
            if (file.createNewFile()) {
                System.out.println("Operation successful. ");
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void tempFileCreator(){
        try {
            File file = new File(directoryPath+redoFilePath);
            if (file.createNewFile()) {
                System.out.println("Operation successful. ");
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void deleteFile(){
        File file = new File(filePath);
        if (file.delete()) {
            System.out.println("Operation successful.");
        } else {
            System.out.println("Failed to delete the file.");
        }
    }

    public static String readFile() {
        StringBuilder text = new StringBuilder();
        String textFromFile;
        try {
            File file = new File(filePath);
            Scanner readFile = new Scanner(file);
            while (readFile.hasNextLine()) {
                text.append(readFile.nextLine()).append("\n");
            }
            readFile.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        textFromFile = text.toString();
        System.out.println("Existing text: " + textFromFile);
        return textFromFile;
    }

    public static String UndoReadFile() {
        StringBuilder text = new StringBuilder();
        String textFromFile;
        try {
            File file = new File(directoryPath+undoFilePath);
            Scanner readFile = new Scanner(file);
            while (readFile.hasNextLine()) {
                text.append(readFile.nextLine()).append("\n");
            }
            readFile.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        textFromFile = text.toString();
        System.out.println("Existing text: " + textFromFile);
        return textFromFile;
    }

    public static String RedoReadFile() {
        StringBuilder text = new StringBuilder();
        String textFromFile;
        try {
            File file = new File(directoryPath+redoFilePath);
            Scanner readFile = new Scanner(file);
            while (readFile.hasNextLine()) {
                text.append(readFile.nextLine()).append("\n");
            }
            readFile.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        textFromFile = text.toString();
        System.out.println("Existing text: " + textFromFile);
        return textFromFile;
    }

    public static void mkDir() {
        File file = new File(directoryPath);
        if (file.mkdir()) {

            // display that the directory is created
            // as the function returned true
            System.out.println("Directory is created");
        }
        else {
            // display that the directory cannot be created
            // as the function returned false
            System.out.println("Directory cannot be created");
        }
    }




}