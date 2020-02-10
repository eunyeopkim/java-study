package prob2;

import java.util.Scanner;

public class GoodsApp {

	public static void main(String[] args) {
		Goods[] goods = new Goods[3];
		Scanner scanner = new Scanner(System.in);
		for(int i=0; i<3; i++) {
			goods[i]=new Goods();
			goods[i].name=scanner.next();
			goods[i].money=scanner.nextInt();
			goods[i].count=scanner.nextInt();
		}
		for(int i=0; i<3; i++) {
			System.out.println(goods[i].name+"(가격:"+goods[i].money+"원)이 "+goods[i].count+"개 입고 되었습니다.");
		}

	}

}
