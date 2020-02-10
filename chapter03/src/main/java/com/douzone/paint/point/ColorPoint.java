	package com.douzone.paint.point;

public class ColorPoint extends Point {
	
	private String color;
	
	public ColorPoint(int x, int y, String color) {
		super(x,y);			// super()로 Point의 기본생성자 파라미터 x,y를 가져옴
		this.color = color;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public void show() {
		System.out.println("점[x=" + getX() + ",y=" + getY() + ",color="+getColor()+"]을 그렸습니다.");
	}
		
}
