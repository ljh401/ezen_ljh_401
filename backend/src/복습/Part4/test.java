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
			String filePath = "./src/복습/Part4/재고파일.txt";
			FileOutputStream fileOutputStream = new FileOutputStream(filePath, true);
			FileInputStream fileInputStream = new FileInputStream(filePath);
			File file = new File(filePath);
			
			byte[] inByteArray = new byte[(int)filePath.length()];
			fileInputStream.read(inByteArray);
			String fileInfo = new String(inByteArray);
			System.out.println(fileInfo);
			
			String[] 재고관리 = fileInfo.split("\n"); System.out.println("제품 분리" + Arrays.toString(재고관리));
			
			System.out.println("\n\n----------------메뉴-------------------------");
			System.out.println("-1제품등록0결제");
			
			for(int i =0 ; i<재고관리.length; i++) {
				if(!재고관리[i].equals("")) {
					String name = 재고관리[i].split(",")[0];
					int stock = Integer.parseInt(재고관리[i].split(",")[1]);
					int price = Integer.parseInt(재고관리[i].split(",")[2]);
					int basket = Integer.parseInt(재고관리[i].split(",")[3]);
					
					if(stock == 0) {
						System.out.println((i+1) + name + "재고없음");
					} else {
						System.out.println((i+1) + name + price);
					}
				}
			}
			
			System.out.println("\n >>>> 선택"); int ch = scanner.nextInt();
			
			if( ch == -1 ) {
				System.out.print("제품명 :"); String name = scanner.next();
				System.out.print("초기재고 :"); int stock = scanner.nextInt();
				System.out.print("가격 :"); int price = scanner.nextInt();
				
				int basket = 0;
				
				String outStr = name +"," + stock  +"," + price  +"," + basket  +"\n";
				
				fileOutputStream.write(outStr.getBytes());
				System.out.println("제품등록");
			}
			
			else if (ch>0 && ch <=재고관리.length) {
				String name = 재고관리[ch-1].split(",")[0];
				int stock = Integer.parseInt(재고관리[ch-1].split(",")[1]);
				int price = Integer.parseInt(재고관리[ch-1].split(",")[2]);
				int basket = Integer.parseInt(재고관리[ch-1].split(",")[3]);
				if( stock > 0) {stock--; basket++; System.out.println(name + "담았습니다.");}
				else {System.out.println("재고부족");}
				
				재고관리[ch-1] = name+","+stock+","+price+","+basket;
				
				String outStr = "";
				for(int i = 0; i<재고관리.length; i++) {
					outStr += 재고관리[i].split(",")[0] +","+재고관리[i].split(",")[1]
							+","+재고관리[i].split(",")[2] +","+재고관리[i].split(",")[3]+"\n";
				}
				
				FileOutputStream fileOutputStream2 = new FileOutputStream(filePath);
				fileOutputStream2.write(outStr.getBytes());
			}
			
			else if( ch == 0) {
				System.out.println("제품명\t수량\t가격");
				
				for(int i = 0; i<재고관리.length; i++) {
					String name = 재고관리[i].split(",")[0];
					int price = Integer.parseInt(재고관리[i].split(",")[2]);
					int basket = Integer.parseInt(재고관리[i].split(",")[3]);
					
					if( basket > 0) {
						System.out.println(name+"\t"+basket+"\t"+basket*price+"\n");
					}
				}
			}
		}
	}
}
