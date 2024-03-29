package pri.designPatternInMultiThread.future.practice1;

import pri.designPatternInMultiThread.future.practice1.content.Content;
import pri.designPatternInMultiThread.future.practice1.content.Retriever;

import java.io.FileOutputStream;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        long start = System.nanoTime();

        Content content1 = Retriever.asyncRetrieve("https://www.yahoo.com/");
        Content content2 = Retriever.asyncRetrieve("https://www.google.com/");
        Content content3 = Retriever.asyncRetrieve("https://www.hyuki.com/");

        saveToFile("yahoo.html", content1);
        saveToFile("google.html", content2);
        saveToFile("hyuki.html", content3);

        long end = System.nanoTime();
        System.out.println("Elapsed time = " + (end - start) + " nano sec.");
    }

    private static void saveToFile(String filename, Content content) {
        byte[] bytes = content.getBytes();
        try {
            System.out.println(Thread.currentThread().getName() + ": Saving to " + filename);
            FileOutputStream out = new FileOutputStream(filename);
            out.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
