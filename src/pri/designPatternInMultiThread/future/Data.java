package pri.designPatternInMultiThread.future;

import java.lang.reflect.InvocationTargetException;

public interface Data {
    public String getContent() throws InvocationTargetException;
}
