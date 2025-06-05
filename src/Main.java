import java.io.File;
import java.io.FileWriter;

public class Main {
    public static void main(String[] args) {
        File rootDir = new File("D://Games");
        StringBuilder log = new StringBuilder();

        if (rootDir.isDirectory()) {
            String netologyDir = rootDir + "//Netology";
            log.append(createDirAndAppendLog(netologyDir));

            String srcDir = netologyDir + "//src";
            String resDir = netologyDir + "//res";
            String savegamesDir = netologyDir + "//savegames";
            String tempDir = netologyDir + "//temp";
            log.append(createDirAndAppendLog(srcDir));
            log.append(createDirAndAppendLog(resDir));
            log.append(createDirAndAppendLog(savegamesDir));
            log.append(createDirAndAppendLog(tempDir));

            String mainDir = srcDir + "//main";
            String testDir = srcDir + "//test";
            log.append(createDirAndAppendLog(mainDir));
            log.append(createDirAndAppendLog(testDir));

            log.append(createFileAndAppendLog(mainDir + "//Main.java"));
            log.append(createFileAndAppendLog(mainDir + "//Utils.java"));

            log.append(createDirAndAppendLog(resDir + "//drawables"));
            log.append(createDirAndAppendLog(resDir + "//vectors"));
            log.append(createDirAndAppendLog(resDir + "//icons"));

            String tempFile = tempDir + "//temp.txt";
            log.append(createFileAndAppendLog(tempFile));

            try (FileWriter writer = new FileWriter(tempFile)) {
                writer.write(log.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static String createDirAndAppendLog(String path) {
        File dir = new File(path);
        return "Каталог " + dir.getAbsolutePath() + (dir.mkdir() ? " создан\n" : " не создан\n");
    }

    private static String createFileAndAppendLog(String path) {
        File file = new File(path);
        try {
            return "Файл " + file.getAbsolutePath() + (file.createNewFile() ? " создан\n" : " не создан\n");
        } catch (Exception e) {
            e.printStackTrace();
            return "Файл " + file.getAbsolutePath() + " не создан\n";
        }
    }
}