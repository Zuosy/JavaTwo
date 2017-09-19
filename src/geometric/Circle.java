package geometric;

public class Circle extends GeometricObject{
	private double radius;
	
	public Circle() {
		this(1);
	}
	
	public Circle(double radius) {
		this.radius = radius;
	}
	
	public Circle(double radius, String color,
			boolean filled) {
		super(color, filled);
		this.radius = radius;
	}
	
	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	//ªÒµ√÷±æ∂
	public double getDiameter() {
		return 2 * radius;
	}
	
	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return Math.PI * radius * radius;
	}

	@Override
	public double getPerimeter() {
		// TODO Auto-generated method stub
		return 2 * Math.PI * radius;
	}

	@Override
	public String toString() {
		return "Circle [radius=" + radius + 
				", getArea()=" + getArea() + 
				", getPerimeter()=" + getPerimeter() + "]";
	}
	
	//java.util.Date date = null;
	
	public Object clone() {
		Circle c = null;
		try{
			c = (Circle)(super.clone());
		}catch(CloneNotSupportedException ex) {
			ex.printStackTrace();
		}
		return c;
	}
}
