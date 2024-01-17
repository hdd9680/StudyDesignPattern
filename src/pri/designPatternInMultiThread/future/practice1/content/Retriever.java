package pri.designPatternInMultiThread.future.practice1.content;

public class Retriever {
    public static Content asyncRetrieve(final String url) {

        final AsyncContentImpl asyncContent = new AsyncContentImpl();

        new Thread() {

            @Override
            public void run() {
                asyncContent.setContent(new SyncContentImpl(url));
            }

        }.start();

        return asyncContent;
    }

    public static Content syncRetrieve(final String url) {
        return new SyncContentImpl(url);
    }
}
