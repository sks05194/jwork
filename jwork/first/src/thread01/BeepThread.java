package thread01;

public class BeepThread extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println("동");
			try { Thread.sleep(500); } catch (Exception e) {}
		}
	}
}