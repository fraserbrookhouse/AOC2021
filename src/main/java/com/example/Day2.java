package com.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Day2 {

    public static void main(String args[]) throws IOException {
        List<String> directions = getDirections("day2Input.txt");
        System.out.println("Directions: " + directions);

    }

    public static List<String> getDirections(String input) throws IOException {
        String file = ClassLoader.getSystemResource(input).getFile();
        return Files.lines(Paths.get(file))
                .collect(Collectors.toList());
    }
}
