package _08;

import java.util.concurrent.Semaphore;

public class App {
	//mutex
	static Semaphore semaphore = new Semaphore(1);

	static class LockerThread extends Thread {
		private String name = "";

		public LockerThread(String name) {
			this.name = name;
		}

		public void run() {
			try {
				semaphore.acquire();
				System.out.println(name + " : got the permit!");
				try {
					for (int i = 1; i <= 5; i++) {
						System.out.println(name + " : is performing operation " + i + ", available Semaphore permits : "
								+ semaphore.availablePermits());

						Thread.sleep(1000);
					}
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					System.out.println(name + " : releasing lock...");
					semaphore.release();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
