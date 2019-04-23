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

        // get test string
        boolean moreTests = true;
        System.out.println("Enter a string to test: ");
        while (moreTests == true) {
            scanner = new Scanner(System.in);
            String input = scanner.next();
            try {
            	if(c.checkAlphabet(input) == true){
            		c.testInput(input);
            	}
            	else {
            		System.out.println("Input contains a character that is not in the alphabet.");
            	}
            }
            catch(NullPointerException e) {
            	System.out.println("Input contains a character that is not in the alphabet.");
            }
            System.out.println("Do you have another string to test? (y/n)");
            String more = scanner.next();
            if (more.contains("y")){
                moreTests = true;
            }else{
                moreTests = false;
                break;
            }
            System.out.println("\nEnter another string to test:");
        }
    }
}