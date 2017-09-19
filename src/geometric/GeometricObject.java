package geometric;

public abstract class GeometricObject implements Cloneable {
	private String color = "white";
	private boolean filled;
	
	protected GeometricObject() {
		
	}
	
	protected GeometricObject(String color, 
			boolean filled) {
		this.color = color;
		this.filled = filled;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public boolean isFilled() {
		return filled;
	}

	public void setFilled(boolean filled) {
		this.filled = filled;
	}

	//ÖØÐ´
	@Override
	public String toString() {
		return "GeometricObject [color=" + color + ", filled=" + filled + ", getColor()=" + getColor() + ", isFilled()="
				+ isFilled() + ", getArea()=" + getArea() + ", getPerimeter()=" + getPerimeter() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	public abstract double getArea();
	
	public abstract double getPerimeter();
	
}
