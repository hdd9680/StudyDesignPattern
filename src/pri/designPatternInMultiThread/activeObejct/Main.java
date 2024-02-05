package pri.designPatternInMultiThread.activeObejct;

import pri.designPatternInMultiThread.activeObejct.active.ActiveObject;
import pri.designPatternInMultiThread.activeObejct.active.ActiveObjectFactory;

public class Main {

    public static void main(String[] args) {
        ActiveObject activeObject = ActiveObjectFactory.createActiveObject();
        new MakerClientThread("Alice", activeObject).start();
        new MakerClientThread("Bobby", activeObject).start();
        new DisplayClientThread("Chris", activeObject).start();
    }

}
