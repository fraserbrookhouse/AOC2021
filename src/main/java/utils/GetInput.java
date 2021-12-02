package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class GetInput {

    public static List<String> getStrings(String input) throws IOException {
        String file = ClassLoader.getSystemResource(input).getFile();
        return Files.lines(Paths.get(file))
                .collect(Collectors.toList());
    }

    public static List<Integer> getIntegers(String input) throws IOException {
        String file = ClassLoader.getSystemResource(input).getFile();
        return Files.lines(Paths.get(file))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
