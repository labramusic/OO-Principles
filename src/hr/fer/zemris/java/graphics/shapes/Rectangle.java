package hr.fer.zemris.java.graphics.shapes;

/**
 * Models a rectangle with modifiable width and height.
 * @author labramusic
 *
 */
public class Rectangle extends AbstractRectangle {

	/**
	 * Initializes a new rectangle with its starting point, width and height.
	 * Width and height must be at least 1 pixel wide.
	 * @param x starting x coordinate
	 * @param y starting y coordinate
	 * @param width rectangle width
	 * @param height rectangle height
	 */
	public Rectangle(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	/**
	 * Returns the width.
	 * @return rectangle width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Sets the width.
	 * @param width rectangle width
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * Returns the height.
	 * @return rectangle height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Sets the height
	 * @param height rectangle height
	 */
	public void setHeight(int height) {
		this.height = height;
	}

}
