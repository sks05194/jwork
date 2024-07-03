package thread04;

public class JoinEx {
	public static void main(String[] args) {
		MyThread thread = new MyThread();
		// Thread 시작
		thread.start();
		System.out.println("Thread가 종료될때까지 기다립니다.");
		
		try {
			// 해당 쓰레드가 멈출때까지 멈춤
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Thread가 종료되었습니다.");
	}
}

class MyThread extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println("MyThread5 : " + i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}