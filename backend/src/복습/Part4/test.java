package 복습.Part4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class test {

	public static void main(String[] args) throws IOException {
		
		while(true) {
			
			Scanner scanner = new Scanner(System.in);
			
			String filePath = "./src/복습/Part4/재고파일1.txt";
			FileOutputStream fileOutputStream = new FileOutputStream(filePath, true);
			FileInputStream fileInputStream = new FileInputStream(filePath);
			File file = new File(filePath);
			
			byte []inByteArray = new byte[(int)file.length()];
			fileInputStream.read(inByteArray);
			String fileInfo = new String(inByteArray);
			System.out.println(fileInfo);
			
			String[] 재고관리 = fileInfo.split("\n"); System.out.println("제품 별 분리 :" + Arrays.toString(재고관리));
			
			System.out.println("\n\n------------------메뉴------------------------");
			System.out.print("-1제품등록 0결제");
			
	
		}
	}
}
