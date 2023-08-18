package java2.day23.Ex1;

public class SumThread extends Thread {
	// 필드
	private long sum;
	// 생성자
	// 메소드
	public long getSum() {
		return sum;
	}
	public void setSum(long sum) {
		this.sum = sum;
	}
	// !! 작업스레드가 실행할 작업코드 재정의
	@Override
	public void run() { // 1부터 100 이하까지 1씩증가하면서 누적합계
		for( int i = 1; i<= 100; i++) {
			sum +=i;
		}
		
	}
}
