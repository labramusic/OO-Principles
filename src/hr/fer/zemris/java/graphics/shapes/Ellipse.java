package hr.fer.zemris.java.graphics.shapes;

/**
 * Models an ellipse with modifiable horizontal and vertical radiuses.
 * @author labramusic
 *
 */
public class Ellipse extends Oval {

	/**
	 * Initializes a new ellipse with its center point, horizontal and vertical radius.
	 * Radiuses must be at least 1 pixel wide.
	 * @param x center x coordinate
	 * @param y center y coordinate
	 * @param horizRadius horizontal radius length
	 * @param vertRadius vertical radius length
	 */
	public Ellipse(int x, int y, int horizRadius, int vertRadius) {
		super(x, y, horizRadius, vertRadius);
	}

	/**
	 * Returns the horizontal radius.
	 * @return horizontal radius
	 */
	public int getHorizontalRadius() {
		return horizontalRadius;
	}

	/**
	 * Sets the horizontal radius
	 * @param horizontalRadius horizontal radius
	 */
	public void setHorizontalRadius(int horizontalRadius) {
		this.horizontalRadius = horizontalRadius;
	}

	/**
	 * Returns the vertical radius.
	 * @return vertical radius
	 */
	public int getVerticalRadius() {
		return verticalRadius;
	}

	/**
	 * Sets the vertical radius.
	 * @param verticalRadius vertical radius
	 */
	public void setVerticalRadius(int verticalRadius) {
		this.verticalRadius = verticalRadius;
	}

}
