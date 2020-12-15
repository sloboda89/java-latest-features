package com.psv;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileMismatch {
    public static void main(String[] args) throws IOException {
        Path filePath1 = Files.createTempFile("file1", ".txt");
        Path filePath2 = Files.createTempFile("file2", ".txt");
        Files.writeString(filePath1,"Our Test String");
        Files.writeString(filePath2,"Our Test String");

        System.out.println(Files.mismatch(filePath1, filePath2)); // -1

        filePath1.toFile().deleteOnExit();
        filePath2.toFile().deleteOnExit();

        Path filePath3 = Files.createTempFile("file3", ".txt");
        Path filePath4 = Files.createTempFile("file4", ".txt");
        Files.writeString(filePath3,"Our Test String");
        Files.writeString(filePath4,"Our Another Test String"); // 4

        System.out.println(Files.mismatch(filePath3, filePath4));

        filePath3.toFile().deleteOnExit();
        filePath4.toFile().deleteOnExit();
    }
}
