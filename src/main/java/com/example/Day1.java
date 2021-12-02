package com.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class Day1 {

    public static void main(String[] args) throws IOException {
        List<Integer> depths = getDepths("depths.txt");
        System.out.println("Final Part A count: " + countDepths(depths));
        System.out.println("Final Part B count: " + sumDepths(depths));

        if (countDepths(depths) != 1583) {
            throw new AssertionError();
        }
        if (sumDepths(depths) != 1627) {
            throw new AssertionError();
        }
    }



    public static List<Integer> getDepths(String input) throws IOException {
        String file = ClassLoader.getSystemResource(input).getFile();
        return Files.lines(Paths.get(file))
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }

    public static int countDepths(List<Integer> depths) {
        int count = 0;
        for(int i = 1; i < depths.size(); i++) {
            int x = i;
            int y = i - 1;
            int depthX = depths.get(x);
            int depthY = depths.get(y);
            if(depthX > depthY) {
                count++;
            }
        }

        return count;
    }

    public static int sumDepths(List<Integer> depths) {
        int count = 0;
        for(int i = 3; i < depths.size(); i++) {
            int x = i;
            int y = i - 1;
            int depthX = depths.get(x) + depths.get(x-1) + depths.get(x-2);
            int depthY = depths.get(y) + depths.get(y-1) + depths.get(y-2);
            if(depthX > depthY) {
                count++;
            }
        }

        return count;
    }

}
