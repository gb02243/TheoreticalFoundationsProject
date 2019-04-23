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
                filename =input;
                file = new File(filename);
                if (file.isFile()) {
                    c = new Controller(file);
                   // scanner.close();
                    fileAccepted = true;
                } else {
                    System.out.println("File not found.");
                }
            }
        }

        // print description
        //c.printDescription();
        // Get test string
       //System.out.print("Enter a string to test: ");
       boolean moreTests=true;
       scanner= new Scanner(System.in);
       while(moreTests==true){
    	   System.out.print("Enter a string to test: ");
    	   String input = scanner.next();
           //run Controller on text string
          c.testInput(input);
          System.out.println("Do you have more strings to test? (y/n)");
          scanner = new Scanner(System.in);
          String more=scanner.next();
    	   if(more.contains("y")) {
    		   moreTests=true;
    	   }
    	   else {
    		   moreTests = false;
    		   break;
    	   }
       }
    }
}