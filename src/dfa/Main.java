package dfa;

import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean fileAccepted = false;
        String filename;
        File file;
        Controller c = null;
        Scanner scanner;

        // get file from argument
        if (args.length == 1) {
            filename = args[0];
            file = new File(filename);

            if (file.isFile()) {
                c = new Controller(file);
            } else {
                System.out.println("File not found.");
            }
        } else { // get file from input
           scanner = new Scanner(System.in);
            while (fileAccepted == false) {
                System.out.println("Please enter the Controller Description file name: ");
                String input = scanner.next();
                filename = input;
                file = new File(filename);
                if (file.isFile()) {
                    c = new Controller(file);
                    fileAccepted = true;
                } else {
                    System.out.println("File not found.");
                }
            }
        }

        // print description
        //c.printDescription();

        // Get test string
        System.out.println("Enter a string to test: ");
        while (true) {
            scanner = new Scanner(System.in);
            String input = scanner.next();
            if(c.checkAlphabet(input)){
                c.testInput(input);
            }else{
                System.out.println("Input contains a character that is not in the alphabet.");
            }
            System.out.println("Enter another string to test:");
        }
    }
}