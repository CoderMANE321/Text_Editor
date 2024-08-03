import textEditor.FileHandler;
import textEditor.OpenEditor;
import java.util.Scanner;
import Structs.Stack;

//next add a way to input a specific file

public class Main {
    public static void main(String[] args) {
        OpenEditor editFile = new OpenEditor();
        FileHandler fileHandler = new FileHandler();
        Stack stack = new Stack(10);
        Scanner input = new Scanner(System.in);
        while (true) {
            String option = input.nextLine().toLowerCase();
            if (option.equals("exit")) {
                break;
            }
            if (option.equals("ov")) {
                System.out.println("Enter text to overwrite the file: ");
                editFile.fileOverWrite();
            } else if (option.equals("ap")) {
                System.out.println("Enter text to modify the file: ");
                editFile.fileAppend();
            } else if (option.equals("c")) {
                System.out.println("File clear");
                editFile.fileClear();
            } else if (option.equals("u")) {
                System.out.println("File undo");
                editFile.fileUndo();
            } else if (option.equals("r")) {
                System.out.println("File redo");
                editFile.fileRedo();
            }


        }



    }
}