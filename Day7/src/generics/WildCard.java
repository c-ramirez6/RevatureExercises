package generics;

import java.util.ArrayList;
import java.util.List;

abstract class Shape	{
	abstract void draw();
}

class Rectangle extends Shape	{

	@Override
	void draw() {
		System.out.println("Drawing Rectangle....");	
	}
}

class Circle extends Shape	{

	@Override
	void draw() {
		System.out.println("Drawing Circle....");
		
	}
	
}

class Test	{
	public static void drawList(List<? extends Shape> list)	{
		for(Shape shape : list) {
			shape.draw();
		}
	}
}

public class WildCard {

	public static void main(String[] args) {
	List<Rectangle> rects = new ArrayList<>();
	List<Circle> circles = new ArrayList<>();
	//This does compile, but does not seems to properly work.  You cant add and children of Shape
	//Nor any Shape objects, even if Shape is not abstract
	//List<? extends Shape> shapes = new ArrayList<>();
	
	
	rects.add(new Rectangle());
	rects.add(new Rectangle());
	rects.add(new Rectangle());
	
	circles.add(new Circle());
	circles.add(new Circle());
	circles.add(new Circle());
	
	Test.drawList(circles);
	Test.drawList(rects);
	}

}
