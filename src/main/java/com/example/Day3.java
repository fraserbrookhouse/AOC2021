package com.example;

import utils.GetInput;
import java.io.IOException;
import java.math.BigInteger;
import java.util.List;

public class Day3 {

    public static void main(String[] args) throws IOException {
        List<String> diagnostic = GetInput.getStrings("day3Input.txt");
        System.out.println("Diagnostic: " + diagnostic);
        System.out.println("Result: " + countNum(diagnostic));
    }

    public static Integer countNum(List<String> diagnostic) {
        int[] posBitsCount = new int [12];
        int[] negBitsCount = new int [12];

        for (String reading : diagnostic) {
            String[] readingBitArray = reading.split("");
            int i = 0;
            for (String bit : readingBitArray) {
                if (bit.equals("1")) {
                    posBitsCount[i]++;
                } else {
                    negBitsCount[i]++;
                }
                i++;
            }
        }
            String most = "";
            String least = "";
            for (int i = 0; i < posBitsCount.length; i++) {
                if (posBitsCount[i] > negBitsCount[i]) {
                    most += "1";
                    least += "0";
                } else {
                    most += "0";
                    least += "1";
                }
            }

        BigInteger mostNum = new BigInteger(most, 2);
        BigInteger leastNum = new BigInteger(least, 2);

        return (mostNum.intValue() * leastNum.intValue());

    }
}
