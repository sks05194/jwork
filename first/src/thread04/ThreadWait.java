package thread04;

public class ThreadWait {
	public static void main(String[] args) {
		// 해당 thread가 실행되면, 해당 thread는 run 메서드 안에서 자신의 모니터링 락을 휫득
		ThreadBB b = new ThreadBB();
		b.start();

		// b에 대하여 동기화 블럭을 설정
		// 만약 메인 thread가 아래의 블록을 위의 Thread보다 먼저 실행되었다면 대기를 하게 되면서
		// 모니터링 락을 놓고 대기
		System.out.println("메인스레드 중간");
		// 메인 thread는 정지
		// Thread가 5번 값을 더한 후 notify를 호출하게 되면 대기에서 깨어남
		synchronized (b) {
			System.out.println("synchronized 메인 블록 시작");
			try {
				System.out.println("b 종료까지 대기");
			} catch (Exception e) {
				e.printStackTrace();
			}

			// 깨어난 후 결과를 출력
			System.out.println("total : " + b.total);
		}
	}
}

class ThreadBB extends Thread {
	// 해당 thread가 실행되면 자기 자신의 모니터링 락을 휙득
	// 5번 반복하면서 1초씩 쉬면서 total에 값을 누적
	// 그 후에 notify() 메소드를 호출하여 대기하고 있는 thread를 깨움
	int total;

	@Override
	public void run() {
		synchronized (this) {
			for (int i = 0; i < 5; i++) {
				System.out.println("ThreadBB : " + i);
				total += i;
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			// synchronized 블록에서만 사용 가능
			// static 메소드에서는 사용 불가능
			notify();
		}
		
		System.out.println("BB종료");
		System.out.println("BB종료");
		System.out.println("BB종료");
		System.out.println("BB종료");
	}
}