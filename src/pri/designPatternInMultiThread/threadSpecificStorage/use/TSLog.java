package pri.designPatternInMultiThread.threadSpecificStorage.use;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TSLog {
    private PrintWriter writer = null;

    public TSLog(String fileName) {
        fileName = System.getProperty("user.dir") + "\\src\\pri\\designPatternInMultiThread\\threadSpecificStorage\\use\\" + fileName;
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

    public void println(String s) {
        writer.println(s);
    }

    public void close() {
        writer.close();
    }

}
