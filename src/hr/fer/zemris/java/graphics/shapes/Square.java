package hr.fer.zemris.java.graphics.shapes;

/**
 * Models a square with modifiable size.
 * @author labramusic
 *
 */
public class Square extends AbstractRectangle {

	/**
	 * Initializes a new square with its starting point and length of its sides.
	 * Length of its sides must be at least 1 pixel.
	 * @param x starting x coordinate
	 * @param y starting y coordinate
	 * @param size square width and height
	 */
	public Square(int x, int y, int size) {
		super(x, y, size, size);
	}

	/**
	 * Returns the square size.
	 * @return square size
	 */
	public int getSize() {
		return width;
	}

	/**
	 * Sets the square size.
	 * @param size square size
	 */
	public void setSize(int size) {
		this.width = size;
		this.height = size;
	}

}
