package helper;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.nio.file.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

public class Utils {

    public static void createDirectory(String directoryToCreate) {
        try {
            Files.createDirectories(Paths.get(directoryToCreate));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String matchPath(String basePath, String nameToMatch) {
        File dir = new File(basePath);
        File[] files = dir.listFiles((d, name) -> name.startsWith(nameToMatch));
        return files[0].getName();
    }
}
