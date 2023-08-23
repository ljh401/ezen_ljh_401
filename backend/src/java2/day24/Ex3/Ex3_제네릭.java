package java2.day24.Ex3;

public class Ex3_제네릭 {

	public static void main(String[] args) {
		
		// 1. 홈 렌탈을 조작하는 구현체
		HomeAgency homeAgency = new HomeAgency();
		Home home = homeAgency.rent();
		home.turnOnLight();
		
		// 2. 자동차 렌탈 구현체
		CarAgency carAgency = new CarAgency();
		Car car = carAgency.rent();
		car.run();
	}
}
