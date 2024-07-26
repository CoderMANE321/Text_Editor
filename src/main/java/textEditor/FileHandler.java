package textEditor;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class FileHandler {
    Scanner input = new Scanner(System.in);
    static String filePath = "text.txt";
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




}