package java2.day22;

import java.awt.Toolkit;

public class 비프음 implements Runnable {
			// implements 구현하다.
	@Override
	public void run() { // 추상메소드 구현
		for( int i = 0; i<5; i++) {
			Toolkit toolkit = Toolkit.getDefaultToolkit();
			try {Thread.sleep(500);}catch (Exception e) {System.out.println(e);}
		}
	}		
}
