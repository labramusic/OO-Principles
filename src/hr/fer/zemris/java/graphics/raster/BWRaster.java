package hr.fer.zemris.java.graphics.raster;

/**
 * Interface which models a black and white raster device as an abstraction for
 * all raster devices of fixed width and height for which each pixel can be
 * painted with only two colors: black (when pixel is turned off) and white
 * (when pixel is turned on). The coordinate system for the raster has (0,0) at
 * the top-left corner of raster. Positive x-axis is to the right and positive
 * y-axis is toward the bottom.
 * 
 * @author labramusic
 *
 */
public interface BWRaster {

	/**
	 * Returns the raster width.
	 * 
	 * @return raster width
	 */
	int getWidth();

	/**
	 * Returns the raster height.
	 * 
	 * @return raster height
	 */
	int getHeight();

	/**
	 * Turns off all the pixels in the raster.
	 */
	void clear();

	/**
	 * Turns pixel on at the specified location.
	 * However, if flip mode is enabled, this method flips the pixel 
	 * at the specified location (if it was turned on, it is turned off, 
	 * and if it was turned off, it is turned on). Throws IllegalArgumentException
	 * if given point is outside of raster boundaries.
	 * 
	 * @param x
	 *            position of pixel at x axis
	 * @param y
	 *            position of pixel at y axis
	 */
	void turnOn(int x, int y);

	/**
	 * Turns pixel off at the specified location. Throws
	 * IllegalArgumentException if given point is outside of raster boundaries.
	 * 
	 * @param x
	 *            position of pixel at x axis
	 * @param y
	 *            position of pixel at y axis
	 */
	void turnOff(int x, int y);

	/**
	 * Enables the flip mode, which is initially disabled.
	 */
	void enableFlipMode();

	/**
	 * Disables the flip mode.
	 */
	void disableFlipMode();

	/**
	 * Checks if the pixel at the given location is turned on and if it is,
	 * returns true, otherwise returns false.
	 * @param x x position of pixel
	 * @param y y position of pixel
	 * @return true if pixel at given position is turned on
	 */
	boolean isTurnedOn(int x, int y);

}
