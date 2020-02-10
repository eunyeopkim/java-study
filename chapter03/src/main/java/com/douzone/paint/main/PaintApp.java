package com.douzone.paint.main;

import com.douzone.paint.i.Drawable;
import com.douzone.paint.point.ColorPoint;
import com.douzone.paint.point.Point;
import com.douzone.paint.shape.Circle;
import com.douzone.paint.shape.Rect;
import com.douzone.paint.shape.Shape;
import com.douzone.paint.shape.Triangle;
import com.douzone.paint.text.GraphicText;

public class PaintApp {
	public static void main(String[] args) {
		Point point = new Point(2, 5);

		point.show();
//		point2.setX(10);
//		point2.setY(23);
		draw(point);

		Point point2 = new Point(3, 4);
//		drawPoint(point2);
		draw(point2);
//		point2.show(false);

		ColorPoint point3 = new ColorPoint(5, 6, "red");
//		drawPoint(point3);
		draw(point3);
		point3.show(false);
		point3.show(true);

		Rect rect = new Rect();
		// drawRect(rect);
//		drawShape(rect);
		draw(rect);

		Triangle triangle = new Triangle();
		// drawTiangle(triangle);
//		drawShape(triangle);
		draw(triangle);

		Circle circle = new Circle();
//		drawShape(circle);
		// 상속받아 썼기때문에 drawPoint X
		draw(circle);

		draw(new GraphicText("hello"));

		// instanceof test
		System.out.println(circle instanceof Object);
		System.out.println(circle instanceof Shape);
		System.out.println(circle instanceof Circle);
		// 오류 : class는 hierachy 상위, 하위만 instance of 연산자를 사용 가능, 형제끼리 x
		// System.out.println(circle instanceof Rect);
		Shape s = new Circle();
		System.out.println(s instanceof Object);
		System.out.println(s instanceof Shape);
		System.out.println(s instanceof Circle);
		// Shape로 선언했기때문에 Rect 가능
		System.out.println(s instanceof Rect);

		// Interface는 hierachy 상관없이 instanceof 연산자를 사용 가능
		System.out.println(s instanceof Drawable);
		// Thread의 인터페이스
		System.out.println(s instanceof Runnable);

	}

	public static void draw(Drawable d) {
		d.draw();
	}

	public static void drawShape(Shape shape) {
		shape.draw();
	}

//	public static void drawTiangle(Triangle triangle) {
//		triangle.draw();
//		
//	}
//	public static void drawRect(Rect rect) {
//		rect.draw();
//		
//	}
	public static void drawPoint(Point p) {
		p.show();
	}
}
