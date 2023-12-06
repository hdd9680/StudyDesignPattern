package pri.designPatternInMultiThread.balking;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Data {

    private String fileName;
    private String content;
    private boolean changed;

    public Data(String fileName, String content) {
        this.fileName = fileName;
        this.content = content;
        changed = true;
    }

    public synchronized void change(String newContent) {
        this.content = newContent;
        changed = true;
    }

    public synchronized void save() throws IOException {
        if(!changed) {
            return;
        }

        doSave();
        changed = false;
    }

    private void doSave() throws IOException {
        System.out.println(Thread.currentThread().getName() + " calls doSave, content = " + content);
        try(Writer writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(content);
        }
    }

}
