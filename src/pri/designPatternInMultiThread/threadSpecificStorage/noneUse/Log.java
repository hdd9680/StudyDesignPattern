package pri.designPatternInMultiThread.threadSpecificStorage.noneUse;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Log {
    private static PrintWriter writer = null;

    static {
        String fileName = System.getProperty("user.dir") + "\\src\\pri\\designPatternInMultiThread\\threadSpecificStorage\\noneUse\\log.txt";
        System.out.println(fileName);
        try {
            File file = new File(fileName);
            if(!file.exists()) {
                file.createNewFile();
            }
            writer = new PrintWriter(new FileWriter(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void println(String s) {
        writer.println(s);
    }

    public static void close() {
        System.out.println("==== END LOG ====");
        writer.close();
    }

}
