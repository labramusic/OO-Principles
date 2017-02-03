package hr.fer.zemris.java.graphics.shapes;

/**
 * Models an oval shape defined by its horizontal and vertical radiuses.
 * @author labramusic
 *
 */
public abstract class Oval extends GeometricShape {

	/**
	 * Minimum horizontal radius length.
	 */
	private final static int MIN_HOR_RADIUS = 1;

	/**
	 * Minimum vertical radius length.
	 */
	private final static int MIN_VER_RADIUS = 1;

	/**
	 * Horizontal radius.
	 */
	protected int horizontalRadius;

	/**
	 * Vertical radius.
	 */
	protected int verticalRadius;

	/**
	 * Initializes a new oval with its center point, horizontal and vertical radius.
	 * Radiuses must be at least 1 pixel wide.
	 * @param x center x coordinate
	 * @param y center y coordinate
	 * @param horizRadius horizontal radius length
	 * @param vertRadius vertical radius length
	 */
	public Oval(int x, int y, int horizRadius, int vertRadius) {
		super(x, y);
		if (horizRadius < MIN_HOR_RADIUS || vertRadius < MIN_VER_RADIUS) {
			throw new IllegalArgumentException("Radius must be at least 1 pixel wide.");
		}
		this.horizontalRadius = horizRadius;
		this.verticalRadius = vertRadius;
	}

	@Override
	public boolean containsPoint(int x, int y) {
		// uses the elliptical formula, with modifications
		// in order to make a radius equal to 1 represent one pixel
		double result = 0;
		if (horizontalRadius == 1) {
			if (x != this.x) {
				return false;
			}
		} else {
			result += Math.pow((double)(x - this.x)/(horizontalRadius-1), 2);
		}
		if (verticalRadius == 1) {
			if (y != this.y) {
				return false;
			}
		} else {
			result += Math.pow((double)(y - this.y)/(verticalRadius-1), 2);
		}
		if (result > 1) {
			return false;
		}
		return true;
	}

}
