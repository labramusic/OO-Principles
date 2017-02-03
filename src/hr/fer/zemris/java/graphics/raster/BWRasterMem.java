package hr.fer.zemris.java.graphics.raster;

/**
 * Implementation of BWRaster which keeps all of its data in memory.
 * @author labramusic
 *
 */
public class BWRasterMem implements BWRaster {

	/**
	 * Minimum raster width.
	 */
	private final static int MIN_WIDTH = 1;

	/**
	 * Minimum raster height.
	 */
	private final static int MIN_HEIGHT = 1;

	/**
	 * Raster width.
	 */
	private int width;

	/**
	 * Raster height.
	 */
	private int height;

	/**
	 * Contains data whether a pixel is turned on or off 
	 * for each pixel in the raster.
	 */
	private boolean[][] raster;

	/**
	 * Flip mode.
	 */
	private boolean flipMode;

	/**
	 * Constructor which accepts raster width and height.
	 * Both must be at least 1.
	 * @param height raster height
	 * @param width raster width
	 */
	public BWRasterMem(int width, int height) {
		if (width < MIN_WIDTH || height < MIN_HEIGHT) {
			throw new IllegalArgumentException("Raster dimensions must be at least 1 pixel wide.");
		}
		this.width = width;
		this.height = height;
		raster = new boolean[height][width];
		flipMode = false;
	}

	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public int getHeight() {
		return height;
	}

	@Override
	public void clear() {
		for (int i = 0; i < height; ++i) {
			for (int j = 0; j < width; ++j) {
				raster[i][j] = false;
			}
		}

	}

	@Override
	public void turnOn(int x, int y) {
		if (x < 0 || x > width - 1 || y < 0 || y > height - 1) {
			throw new IllegalArgumentException("Given coordinates are out of bounds.");
		}

		if (flipMode) {
			if (isTurnedOn(x, y)) {
				raster[y][x] = false;
			} else {
				raster[y][x] = true;
			}

		} else {
			raster[y][x] = true;
		}
	}

	@Override
	public void turnOff(int x, int y) {
		if (x < 0 || x > width - 1 || y < 0 || y > height - 1) {
			throw new IllegalArgumentException("Given coordinates are out of bounds.");
		}
		raster[y][x] = false;
	}

	@Override
	public void enableFlipMode() {
		flipMode = true;

	}

	@Override
	public void disableFlipMode() {
		flipMode = false;

	}

	@Override
	public boolean isTurnedOn(int x, int y) {
		if (x < 0 || x > width - 1 || y < 0 || y > height - 1) {
			throw new IllegalArgumentException("Given coordinates are out of bounds.");
		}
		return raster[y][x];
	}

}
