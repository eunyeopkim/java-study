	package chapter03;

import mypackage.Goods;

public class GoodsApp {

	public static void main(String[] args) {
		Goods goods = new Goods();

		// public은 접근제한 x
		goods.name = "nikon";

		// default는 같은 패키지에서만 접근 가능
		// goods.countStock = 50;

		// private는 하나의 클래스 내부에서만 접근가능하다.
		// goods.countSold = 100;

		// protected는 같은 패키지 또는 자식에서만 접근 가능.
		// goods.price = 100000;

		// System.out.println(goods.name + " : " + goods.price + " : " + goods.countSold
		// + " : " + goods.countStock);

		Goods goods2 = new Goods();
		Goods goods3 = new Goods();

		System.out.println(Goods.countOfGoods);

	}

}
