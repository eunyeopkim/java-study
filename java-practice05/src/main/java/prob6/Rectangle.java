package prob6;

public class Rectangle extends Shape implements Resizable {
	
	public Rectangle(int i, int j) {
		setWidth(i);
		setHeight(j);
	}




	@Override
	public void resize(double s) {
		
		this.setWidth(getWidth()*s);
		this.setHeight(getHeight()*s);
		
	}
	public double getArea() {
		return getWidth()*getHeight();
	}
	
	public double getPerimeter() {
		return 2*(getWidth()+getHeight());
	}
	
}
