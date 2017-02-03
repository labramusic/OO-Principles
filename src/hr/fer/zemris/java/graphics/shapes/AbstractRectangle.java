package hr.fer.zemris.java.graphics.shapes;

import hr.fer.zemris.java.graphics.raster.BWRaster;

/**
 * Models an abstract rectangle defined by its width and height.
 * @author labramusic
 *
 */
public abstract class AbstractRectangle extends GeometricShape {

	/**
	 * Minimum rectangle width.
	 */
	private final static int MIN_WIDTH = 1;

	/**
	 * Minimum rectangle height.
	 */
	private final static int MIN_HEIGHT = 1;

	/**
	 * Rectangle width.
	 */
	protected int width;

	/**
	 * Rectangle height.
	 */
	protected int height;

	/**
	 * Initializes a new abstract rectangle with its starting point
	 * (top left corner), width and height.
	 * Width and height must be at least 1 pixel wide.
	 * @param x starting x coordinate
	 * @param y starting y coordinate
	 * @param width rectangle width
	 * @param height rectangle height
	 */
	public AbstractRectangle(int x, int y, int width, int height) {
		super(x, y);
		if (width < MIN_WIDTH || height < MIN_HEIGHT) {
			throw new IllegalArgumentException("Dimensions must be at least 1 pixel wide.");
		}
		this.width = width;
		this.height = height;
	}

	@Override
	public boolean containsPoint(int x, int y) {
		if (x < this.x || y < this.y || x >= this.x + width || y >= this.y + height) {
			return false;
		}
		return true;
	}

	@Override
	public void draw(BWRaster r) {
		for (int x = this.x, xMax = this.x + width; x < xMax; ++x) {
			if (x >= 0 && x < r.getWidth() - 1) {
				for (int y = this.y, yMax = this.y + height; y < yMax; ++y) {
					if (y >= 0 && y < r.getHeight() - 1 ) {
						r.turnOn(x, y);
					}
				}
			}
		}
	}

}
