package thread04;

public class User1 extends Thread {
	@Override
	public void run() {
		System.out.println("User1스레드 시작");
		for (int i = 0; i < 5; i++) {
			System.out.println("동");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}