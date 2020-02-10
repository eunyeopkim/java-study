	package chapter03;

public class Goods2 {

	private String name; // 모든 접근제한 x
	private int price; // 같은 패키지 + 자식 접근 가능
	private int countStock; // 같은 패키지
	private int countSold; // 하나의 클래스에서만

	public Goods2() {

	}

	public Goods2(String name, int price, int countStock, int countSold) {
		this.name = name;
		this.price = price;
		this.countStock = countStock;
		this.countSold = countSold;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		if (price < 0) {
			price = 0;
		}
		this.price = price;
	}

	public int getCountStock() {
		return countStock;
	}

	public void setCountStock(int countStock) {
		this.countStock = countStock;
	}

	public int getCountSold() {
		return countSold;
	}

	public void setCountSold(int countSold) {
		this.countSold = countSold;
	}

	public void showInfo() {
		System.out.println(name + " : " + price + " : " + countStock + " : " + countSold);

	}

	public int calcDiscountPrice(double discountRate) {

		return (int) (price - price * discountRate);
	}

}
