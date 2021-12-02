package com.example;

import utils.GetInput;
import java.io.IOException;
import java.util.List;

public class Day1 {

    public static void main(String[] args) throws IOException {
        List<Integer> depths = GetInput.getIntegers("depths.txt");
        System.out.println("Final Part A count: " + countDepths(depths));
        System.out.println("Final Part B count: " + sumDepths(depths));

        if (countDepths(depths) != 1583) {
            throw new AssertionError();
        }
        if (sumDepths(depths) != 1627) {
            throw new AssertionError();
        }
    }

    public static int countDepths(List<Integer> depths) {
        int count = 0;
        for(int x = 1; x < depths.size(); x++) {
            int y = x - 1;
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
        for(int x = 3; x < depths.size(); x++) {
            int y = x - 1;
            int depthX = depths.get(x) + depths.get(x-1) + depths.get(x-2);
            int depthY = depths.get(y) + depths.get(y-1) + depths.get(y-2);
            if(depthX > depthY) {
                count++;
            }
        }

        return count;
    }

}
