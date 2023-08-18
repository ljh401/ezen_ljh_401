package java2.day23.Ex1;

public class Ex1_멀티스레드join {

	public static void main(String[] args) {
		// main스레드가 main함수 호출
		System.out.println("현재스레드 :" + Thread.currentThread().getName());
		
		// 1. [ main스레드 ] 작업 스레드객체 생성 [ main 외 추가적으로 작업 스레드 생성 ]
		SumThread sumThread = new SumThread();
		// 2. [ main스레드 ] 작업 스레드 실행 => 대기 상태 => CPU 스케줄링 => 실행 => 대기 상태 => 대기 => 실행
		sumThread.start();
		
		// 3. [ main스레드 ] 작업 스레드 객체 외 필드 확인
		// - 작업스레드가 1~100까지 계산이 끝나기전에 main메소드가 결과 먼저 !! 출력
		System.out.println("[JSON 하기전] 1~100 힙 :" + sumThread.getSum());
		
		try {sumThread.join(); // 합친다 .. [ 작업스레드를 호출한 스레드는 일시 정지 상태 ]
			// main스레드가 sumThread스레드의 join메소드를 호출했기 때문에 main 스레드 일시정지
			// sumThread스레드가 종료되면 main스레드 일시 정지 풀림.
		
		
		}catch (Exception e) {}
		System.out.println("[JSON 했을때] 1~100 힙 : " + sumThread. getSum());
	}
}
