package com.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day1 {

    public static void main(String[] args) {
        System.out.println(getDepths());

    }



    public static List<List<String>> getDepths() {
        String file = ClassLoader.getSystemResource("depths.txt").getFile();
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

}
