package java2.day22;

public class 작업스레드1 implements Runnable { // 구현

	@Override
	public void run() { // 추상메소드 구현
		try {
			int count = 1;
			while(true) {
			Thread.sleep(5000); // 5초동안 일시정지 [ 예외처리필수 ]
			System.out.println(Thread.currentThread().getName() + "[작업1 Thread] output :" + count );
			count++;
			}
		} catch(Exception e) {
			System.out.println(e);
		}
	}		
}
