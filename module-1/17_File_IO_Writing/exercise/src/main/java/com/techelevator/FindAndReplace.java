package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class FindAndReplace {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("What is the search word?");
        String searchWord = scanner.nextLine();
        System.out.println("What is the replacement word?");
        String replacementWord = scanner.nextLine();
        System.out.println("What is the source file?");
        String sourceFilePath = scanner.nextLine();
        File sourceFile = new File(sourceFilePath);

        boolean continueWriting = true;

        if (!sourceFile.exists()) {
            System.out.println("This file does not exist");
            continueWriting = false;
        } else if (sourceFile.exists()) {
            System.out.println(sourceFile.getAbsolutePath());
        }

        System.out.println("What is the destination file?");
        String destinationFilePath = scanner.nextLine();
        File destinationFile = new File(destinationFilePath);

        if (!destinationFile.exists()) {
            System.out.println("This file does not exist");
            continueWriting = false;
        } else if (destinationFile.exists()) {
            try (Scanner fileInput = new Scanner(sourceFile); PrintWriter writer = new PrintWriter(destinationFile)) {
                while (fileInput.hasNextLine()) {
                   String copyText = fileInput.nextLine();
                   writer.println(copyText.replace(searchWord, replacementWord));
                }
            } catch (FileNotFoundException e) {
                System.out.println("The entered name is not a file: " + destinationFile.getAbsolutePath());
            }
            scanner.close();
        }

    }

}
