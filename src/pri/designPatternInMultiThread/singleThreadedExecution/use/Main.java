package pri.designPatternInMultiThread.singleThreadedExecution.use;

public class Main {

    public static void main(String[] args) {
        Gate gate = new Gate();
        /*
         * 실행 결과 어느 순간부터 BORKEN(객체 망가짐 상태)이 발생함
         */
        new UserThread(gate, "Alice", "Alaska").start();
        new UserThread(gate, "Bobby", "Brazil").start();
        new UserThread(gate, "Chirs", "Canada").start();
    }

}