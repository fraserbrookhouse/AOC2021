package com.example;

import utils.GetInput;
import java.io.IOException;
import java.util.List;

public class Day2 {

    public static void main(String[] args) throws IOException {
        List<String> directions = GetInput.getStrings("day2input.txt");
        System.out.println("Part 1 answer: " + getPosition(directions, 1));
        System.out.println("Part 2 answer: " + getPosition(directions, 2));

    }

    public static Integer getPosition(List<String> directions, Integer part) {
        int horizontalPos = 0;
        int depth = 0;
        int aim = 0;
        int multipliedLocations;
        if (part == 1) {
            for (String instructions : directions) {
                String[] instruction = instructions.split(" ");
                String direction = instruction[0];
                int distance = Integer.parseInt(instruction[1]);
                switch (direction) {
                    case "forward" -> horizontalPos += distance;
                    case "down" -> depth += distance;
                    case "up" -> depth -= distance;
                }
            }
        } else if (part == 2) {
            for (String instructions : directions) {
                String[] instruction = instructions.split(" ");
                String direction = instruction[0];
                int distance = Integer.parseInt(instruction[1]);
                switch (direction) {
                    case "forward" -> {
                        horizontalPos += distance;
                        depth += (aim * distance);
                    }
                    case "down" ->
                        aim += distance;
                    case "up" ->
                        aim -= distance;
                }
            }
        }
        multipliedLocations = horizontalPos * depth;
        return multipliedLocations;
    }
}
