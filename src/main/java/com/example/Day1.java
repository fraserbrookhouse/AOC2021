package com.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day1 {

    public static void main(String[] args) {
        List<List<String>> depths = getDepths("depths.txt");
        System.out.println("Final Part A count: " + countDepths(depths));
        System.out.println("Final Part B count: " + sumDepths(depths));

        if (countDepths(depths) != 1583) {
            throw new AssertionError();
        }
        if (sumDepths(depths) != 1627) {
            throw new AssertionError();
        }
    }



    public static List<List<String>> getDepths(String input) {
        String file = ClassLoader.getSystemResource(input).getFile();
        List<List<String>> depths = new ArrayList<>();
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                while((line = br.readLine()) != null) {
                    String[] values = line.split(",");
                    depths.add(Arrays.asList(values));
                }
            }
            catch(Exception e) {
                e.printStackTrace();
            }

            return depths;
    }

    public static Integer countDepths(List<List<String>> depths) {
        Integer count = 0;
        for(int i = 1; i < depths.size(); i++) {
            Integer x = i;
            Integer y = i - 1;
            Integer depthX = Integer.parseInt(depths.get(x).get(0));
            Integer depthY = Integer.parseInt(depths.get(y).get(0));
            if(depthX > depthY) {
                count++;
            }
        }

        return count;
    }

    public static Integer sumDepths(List<List<String>> depths) {
        Integer count = 0;
        for(int i = 3; i < depths.size(); i++) {
            Integer x = i;
            Integer y = i - 1;
            Integer depthX = Integer.parseInt(depths.get(x).get(0)) + Integer.parseInt(depths.get(x-1).get(0)) + Integer.parseInt(depths.get(x-2).get(0));
            Integer depthY = Integer.parseInt(depths.get(y).get(0)) + Integer.parseInt(depths.get(y-1).get(0)) + Integer.parseInt(depths.get(y-2).get(0));
            if(depthX > depthY) {
                count++;
            }
        }

        return count;
    }

}
