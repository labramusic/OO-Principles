package hr.fer.zemris.java.graphics.shapes;

import hr.fer.zemris.java.graphics.raster.BWRaster;

/**
 * Represents an abstract geometric shape which can be drawn on a raster.
 * @author labramusic
 *
 */
public abstract class GeometricShape {

	/**
	 * Starting x coordinate for drawing the specified shape.
	 */
	protected int x;

	/**
	 * Starting y coordinate for drawing the specified shape.
	 */
	protected int y;

	/**
	 * Constructor which initializes the starting x and y coordinates.
	 * @param x starting x coordinate 
	 * @param y starting y coordinate
	 */
	public GeometricShape(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Draws the shape on the given raster by turning on 
	 * each point contained in the geometric shape.
	 * @param r raster to draw the shape on
	 */
	public void draw(BWRaster r) {
		int width = r.getWidth();
		int height = r.getHeight();
		for (int x = 0; x < width; ++x) {
			for (int y = 0; y < height; ++y) {
				if(this.containsPoint(x, y)) {
					r.turnOn(x, y);
				}
			}
		}
	}

	/**
	 * Checks if given point belongs to the specified geometric shape.
	 * Returns false only if the location is outside of the geometric shape,
	 * true otherwise.
	 * @param x x coordinate of the point
	 * @param y y coordinate of the point
	 * @return true if point is inside of the boundaries of the geometric shape
	 */
	public abstract boolean containsPoint(int x, int y);

	/**
	 * Returns the starting x coordinate of the shape.
	 * @return starting x coordinate
	 */
	public int getX() {
		return x;
	}

	/**
	 * Sets the starting x coordinate of the shape-
	 * @param x starting x coordinate
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Returns the starting y coordinate of the shape.
	 * @return starting y coordinate
	 */
	public int getY() {
		return y;
	}

	/**
	 * Sets the starting y coordinate of the shape.
	 * @param y starting y coordinate
	 */
	public void setY(int y) {
		this.y = y;
	}

}
