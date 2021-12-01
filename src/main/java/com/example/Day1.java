package com.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Day1 {

    public static void main(String[] args) {
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



    public static List<Integer> getDepths(String input) {
        String file = ClassLoader.getSystemResource(input).getFile();
        List<Integer> depths = new ArrayList<>();
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                while((line = br.readLine()) != null) {
                    depths.add(Integer.parseInt(line));
                }
            }
            catch(Exception e) {
                e.printStackTrace();
            }

            return depths;
    }

    public static Integer countDepths(List<Integer> depths) {
        Integer count = 0;
        for(int i = 1; i < depths.size(); i++) {
            Integer x = i;
            Integer y = i - 1;
            Integer depthX = depths.get(x);
            Integer depthY = depths.get(y);
            if(depthX > depthY) {
                count++;
            }
        }

        return count;
    }

    public static Integer sumDepths(List<Integer> depths) {
        Integer count = 0;
        for(int i = 3; i < depths.size(); i++) {
            Integer x = i;
            Integer y = i - 1;
            Integer depthX = depths.get(x) + depths.get(x-1) + depths.get(x-2);
            Integer depthY = depths.get(y) + depths.get(y-1) + depths.get(y-2);
            if(depthX > depthY) {
                count++;
            }
        }

        return count;
    }

}
