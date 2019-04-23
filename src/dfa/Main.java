package dfa;

import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean fileAccepted = false;
        String filename;
        File file;
        Controller c = null;

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
           Scanner scanner = new Scanner(System.in);
            while (fileAccepted == false) {
                System.out.println("Please enter the Controller Description file name: ");
                String input = scanner.next();
                filename = input;
                file = new File(filename);
                if (file.isFile()) {
                    c = new Controller(file);
                    scanner.close();
                    fileAccepted = true;
                } else {
                    System.out.println("File not found.");
                }
            }
        }

        // print description
        //c.printDescription();
        // Get test string
       System.out.print("Enter a string to test: ");
       Scanner testInput = new Scanner(System.in);
       while(true){
    	  // Scanner testInput = new Scanner(System.in);
    	   String input = testInput.next();
           //run Controller on text string
          c.testInput(input);
           
    	   System.out.println("Do you have any more inputs to test? (y/n)");
    	   Scanner moreTests = new Scanner(System.in);
    	   moreTests.next();
    	   String moreInputs = moreTests.next();
    	   while(moreInputs=="y") {
    		   System.out.print("\nEnter another string to test: ");
    		   Scanner anotherTest = new Scanner(System.in);
    		  // input = anotherTest.next();
    		 //  c.testInput(input);
    	   }
    	   if(moreInputs=="n") {
    		   break;
    	   }
       }
    //  c.testInput("0100000001");
    }
}