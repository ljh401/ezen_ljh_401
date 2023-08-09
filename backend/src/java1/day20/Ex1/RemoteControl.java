package java1.day20.Ex1;

public interface RemoteControl { // 인터페이스 선언
	// 인터페이스 : 두 장치(객체)를 연결하는 접속기
	// 구성멤버
		// 1. public 상수 필드		[ public static final ]
		int MAX_VOLUME = 10;
		public static final int MIN_VOLUME = 0;
		
		// 2. *public 추상 메소드	[ public abstract ] : 선언부			=> 구현객체 o
		void turnOn();
		public abstract void turnOff();
		void setVolume(int volume);
		
		// 3. public 디폴트 메소드 [ public] default  : 선언부 + 실행부		=> 구현객체 o
		default void setMute(boolean mute) {
			if(mute) {System.out.println("무음처리"); setVolume(MIN_VOLUME);}
			else {System.out.println("무음 해제");}
		}
		public default void getMute() {System.out.println();}
		// 4. public 정적(객체없이 )메소드 [ public ] static : 선언부 + 실행부 => 구현객체 x
		static void changeBattery() {System.out.println("리모콘 건전지 교체");}
		public static void checkBattery() {System.out.println("건전지 확인");}
		
		
		// --> java 9 이상 지원
		// 5. private 메소드		: 디폴트메소드 안에서만 호출 가능
		//private void defaultCommon() {System.out.println("디폴트 메소드");}
		// 6. private 정적메소드	: 디폴트메소드 , 정적메소드 호출 가능
		//private static void staticCommon() {System.out.println("정적 메소드");}
}

/*
	인스턴스멤버	: 객체 생성시 메모리 할당되는 필드,메소드		[static없는]
	정적멤버		: 객체가 없어도 메모리 우선할당된 필드,메소드	[static있는]
		- 정적멤버는 인스턴스멤버에 접근할수 없다.	[ p.249]

*/