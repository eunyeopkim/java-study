package prob6;

public class RectTriangle extends Shape {
	public RectTriangle(int i, int j) {
		setWidth(i);
		setHeight(j);
	}

	public double getArea() {
		return 0.5*getWidth()*getHeight();
	}
	
	public double getPerimeter() {
		return getWidth()+getHeight()+Math.sqrt((Math.pow(getHeight(),2)+(Math.pow(getWidth(),2))));
	}
}
