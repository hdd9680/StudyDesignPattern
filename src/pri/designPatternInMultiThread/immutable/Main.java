package pri.designPatternInMultiThread.immutable;

import java.lang.reflect.Field;

public class Main {

    public static void main(String[] args) throws Exception {
        // 만약 생성자의 인수로 mutable한 참조 자료형을 넣게 되면 그 클래스는 immutable 하지 않음(넣고 나서 인수로 넣은 참조 자료형의 필드로를 set할 수 있어서)
        Person alice = new Person("Alice", "Alaska");
        new PrintPersonThread(alice).start();
        new PrintPersonThread(alice).start();
        new PrintPersonThread(alice).start();
    }

}
