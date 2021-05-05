package setup;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.nio.file.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

public class Utils {

    public static void emptyDirectory(String directory) {
        Path pathToBeDeleted = Paths.get(directory);
        try {
            Files.walk(pathToBeDeleted)
                    .sorted(Comparator.reverseOrder())
                    .map(Path::toFile)
                    .forEach(File::delete);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void copyFolder(String src, String dest) throws IOException {
        Path sourceDirectory = Paths.get(src); // System.getProperty("user.dir") + "/output/current/"
        Path destinationDirectory = Paths.get(dest); // System.getProperty("user.dir") + "/output/archived/"

        try (Stream<Path> stream = Files.walk(sourceDirectory)) {
            stream.forEach(source -> copy(source, destinationDirectory.resolve(sourceDirectory.relativize(source))));
        }
    }

    private static void copy(Path source, Path dest) {
        try {
            Files.copy(source, dest, StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

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
