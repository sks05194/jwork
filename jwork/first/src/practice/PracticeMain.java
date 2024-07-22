package practice;

public class PracticeMain {
    public static void main(String[] args) {

        // 메인 스레드 참조 저장
        Thread mainThread = Thread.currentThread();

        // 서브 스레드 생성
        Thread subThread = new Thread(() -> {
            try {
                Thread.sleep(5000); // 서브 스레드에서 5초 대기
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 메인 스레드에 인터럽트 신호를 보냄
            mainThread.interrupt();
            System.out.println("SubThread: Sent interrupt signal to MainThread.");
        });

        subThread.start();

        try {
            while (true) {
                System.out.println("MainThread: Running...");
                Thread.sleep(1000); // 메인 스레드 작업 중 잠시 대기
            }
        } catch (InterruptedException e) {
            System.out.println("MainThread: Interrupted, exception caught!");
            e.printStackTrace();
        }

        System.out.println("MainThread: Exiting.");
    }
}