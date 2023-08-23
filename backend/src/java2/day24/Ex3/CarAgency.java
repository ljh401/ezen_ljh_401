package java2.day24.Ex3;

public class CarAgency implements Rentable<Car>{
			// implements : 인터페이스 (추상메소드) 구현(정의)하다.
	@Override
	public Car rent() {
		return new Car();
	}
}
