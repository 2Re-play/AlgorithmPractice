package OSPrograming;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class SemaphoreTest {
	private static final Random rd = new Random(10000);

	static class Log {
		public static void debug(String strMessage) {
			System.out.println(Thread.currentThread().getName() + " : " + strMessage);
		}
	}

	class SemaphoreResource extends Semaphore {
		private static final long serialVersionUID = 1L;

		public SemaphoreResource(final int permits) {
			super(permits);
		}

		public void use() throws InterruptedException {
			acquire(); // �������� ���ҽ� Ȯ��
			try {
				doUse();
			} finally {
				release(); // �������� ���ҽ� ����
				Log.debug("Thread ���� �� ����  permits: " + this.availablePermits());
			}
		}

		protected void doUse() throws InterruptedException {
			// ������ ���α׷��� �����ϴµ� �Ÿ��� ������ �ð�
			int sleepTime = rd.nextInt(500);
			Thread.sleep(sleepTime); // ��Ÿ�� �ð� ����
			Log.debug(" Thread ����..................." + sleepTime);
			/** something logic **/
		}
	}

	class MyThread extends Thread {
		private final SemaphoreResource resource;

		public MyThread(String threadName, SemaphoreResource resource) {
			this.resource = resource;
			this.setName(threadName);
		}

		@Override
		public void run() {
			try {
				resource.use();
			} catch (InterruptedException e) {
			} finally {
			}
		}
	}

	public static void main(String... s) {
		System.out.println("Test Start...");
		SemaphoreResource resource = new SemaphoreTest().new SemaphoreResource(4);
		for (int i = 0; i < 20; i++) {
			new SemaphoreTest().new MyThread("Thread-" + i, resource).start();
		}
	}
}
