package hr.fer.zemris.java.graphics.shapes;

/**
 * Models a circle with modifiable radius.
 * @author labramusic
 *
 */
public class Circle extends Oval {

	/**
	 * Initializes a new circle with its center point and radius.
	 * Radius must be at least 1 pixel wide.
	 * @param x center x coordinate
	 * @param y center y coordinate
	 * @param radius radius length
	 */
	public Circle(int x, int y, int radius) {
		super(x, y, radius, radius);
	}

	/**
	 * Returns the circle radius.
	 * @return circle radius
	 */
	public int getRadius() {
		return horizontalRadius;
	}

	/**
	 * Sets the circle radius.
	 * @param radius circle radius
	 */
	public void setRadius(int radius) {
		this.horizontalRadius = radius;
		this.verticalRadius = radius;
	}

}
