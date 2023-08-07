package java1.day18.Ex1;
// 클래스에 인터페이스를 구현하기
public class Television implements RemoteControl {
	// 클래스명 implements 인터페이스명
	// 인터페이스가 선언한 추상메소드를 해당 클래스가 구현하기.
	// 해당 추상메소드를 구현하기 전까지는 오류.
	
	// 필드
	private int volume; // 인스턴스 필드
	
	// 추상메소드 구현 : implements 인터페이스명을 하게 되면 해당 인터페이스의 추상메소드 모두 구현
	// !!!! : implements 키워드 사용했으면 추상메소드를 꼭 구현하기
	@Override
	public void turnOn() {System.out.println("TV를 켭니다.");}
	
	@Override
	public void turnOff() {System.out.println("TV를 끕니다.");}
	
	@Override
	public void setVolume(int volume) {
		if(volume > RemoteControl.MAX_VOLUME) {
			// 만약에 볼륨이 최대 볼륨보다 크면 해당 객체는 최대볼륨으로 대입
			this.volume = RemoteControl.MAX_VOLUME; // this : 해당메소드를 호출한 객체
		} else if (volume < RemoteControl.MIN_VOLUME) {
			// 만약에 볼륨이 최소볼륨보다 작으면 해당 객체의 소음을 최소볼륨으로 대입/설정
			this.volume = RemoteControl.MIN_VOLUME;
		} else {this.volume = volume;}
		System.out.println("현재 TV 소음 : " + this.volume);
	}
}
