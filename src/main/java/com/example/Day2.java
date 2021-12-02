package com.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class Day2 {

    public static void main(String[] args) throws IOException {
        List<String> directions = getDirections("day2Input.txt");
        System.out.println("Part 1 answer: " + getPosition(directions, 1));
        System.out.println("Part 2 answer: " + getPosition(directions, 2));

    }

    public static List<String> getDirections(String input) throws IOException {
        String file = ClassLoader.getSystemResource(input).getFile();
        return Files.lines(Paths.get(file))
                .collect(Collectors.toList());
    }

    public static Integer getPosition(List<String> directions, Integer part) {
        int x = 0;
        int y = 0;
        int a = 0;
        int multipliedLocations;
        if (part == 1) {
            for (String instructions : directions) {
                String[] instruction = instructions.split(" ");
                String direction = instruction[0];
                int distance = Integer.parseInt(instruction[1]);
                switch (direction) {
                    case "forward" -> x += distance;
                    case "down" -> y += distance;
                    case "up" -> y -= distance;
                }
            }
        } else if (part == 2) {
            for (String instructions : directions) {
                String[] instruction = instructions.split(" ");
                String direction = instruction[0];
                int distance = Integer.parseInt(instruction[1]);
                switch (direction) {
                    case "forward": {
                        x += distance;
                        y += (a * distance);
                    }
                    case "down":
                        a += distance;
                    case "up":
                        a -= distance;
                }
            }
        }
        multipliedLocations = x * y;
        return multipliedLocations;
    }
}
