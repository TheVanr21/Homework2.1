import java.io.File;
import java.io.FileWriter;
import java.util.List;

public class Main {
    static StringBuilder log = new StringBuilder();

    public static void main(String[] args) {
        File rootDirectory = new File("D://Games");

        if (rootDirectory.isDirectory()) {
            List<String> directoriesToCreate = List.of(
                    rootDirectory + "//Netology",
                    rootDirectory + "//Netology//src",
                    rootDirectory + "//Netology//src//main",
                    rootDirectory + "//Netology//src//test",
                    rootDirectory + "//Netology//res",
                    rootDirectory + "//Netology//res//drawables",
                    rootDirectory + "//Netology//res//vectors",
                    rootDirectory + "//Netology//res//icons",
                    rootDirectory + "//Netology//savegames",
                    rootDirectory + "//Netology//temp"
            );

            for (String directory : directoriesToCreate) {
                createDirectory(directory);
            }

            createFile(rootDirectory + "//Netology//src//main", "Main.java");
            createFile(rootDirectory + "//Netology//src//main", "Utils.java");
            createFile(rootDirectory + "//Netology//temp", "temp.txt");

            try (FileWriter writer = new FileWriter(rootDirectory + "//Netology//temp//temp.txt")) {
                writer.write(log.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void createDirectory(String path) {
        File dir = new File(path);
        if (dir.mkdir()) {
            log.append("Каталог ").append(dir).append(" создан\n");
        }
    }

    public static void createFile(String path, String filename) {
        File file = new File(path + "//" + filename);
        try {
            if (file.createNewFile()) {
                log.append("Файл ").append(file).append(" создан\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}