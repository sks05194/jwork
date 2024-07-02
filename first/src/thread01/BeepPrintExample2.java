package thread01;

public class BeepPrintExample2 {
	public static void main(String[] args) {
		// Runnable 객체를 직접 생성하여 스레드 생성자의 매개인자로 보내어 스레드 객체 생성
		Runnable beepTask = new BeepTask();
		Thread thread = new Thread(beepTask);
		thread.start();

		// Runnable 객체를 익명클래스로 생성하여 스레드 생성자의 매개인자로 보내어 스레드 객체 생성
		Thread thread0 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 5; i++) {
					System.out.println("동");
					try {
						Thread.sleep(500);
					} catch (Exception e) {
					}
				}
			}
		});
		thread0.start();

		// Runnable 객체를 람다식으로 생성하여 스레드 생성자의 매개인자로 보내어 스레드 객체 생성
		Thread thread1 = new Thread(() -> {
			for (int i = 0; i < 5; i++) {
				System.out.println("동");
				try {
					Thread.sleep(500);
				} catch (Exception e) {
				}
			}
		});
		thread1.start();

		for (int i = 0; i < 5; i++) {
			System.out.println("띵");
			try {
				Thread.sleep(500);
			} catch (Exception e) {
			}
		}
	}
}