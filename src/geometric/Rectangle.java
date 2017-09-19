package geometric;

public class Rectangle extends GeometricObject{
	private double width;
	private double height;
	
	public Rectangle() {
		this(1, 1);
	}
	
	public Rectangle(double width, double height) {
		this.width = width;
		this.height = height;
	}
	
	public Rectangle(double width, double height, String color, boolean filled) {
		super(color, filled);
		this.width = width;
		this.height = height;
	}
	
	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return width * height;
	}

	@Override
	public double getPerimeter() {
		// TODO Auto-generated method stub
		return 2 * (width + height);
	}

	@Override
	public String toString() {
		return "Rectangle [width=" + width + ", height=" + height + ", getArea()=" + getArea() + ", getPerimeter()="
				+ getPerimeter() + "]";
	}
	
	public Object clone() {
		Rectangle r = null;
		try{
			r = (Rectangle)(super.clone());
		}catch (CloneNotSupportedException ex) {
			ex.printStackTrace();
		}
		return r;
	}
}
