package hr.fer.zemris.java.graphics.views;

import hr.fer.zemris.java.graphics.raster.BWRaster;

/**
 * Outputs the textual representation of the image to the standard output.
 * @author labramusic
 *
 */
public class SimpleRasterView implements RasterView {

	/**
	 * Character used for representing pixels that are turned on.
	 */
	private char onChar;

	/**
	 * Character used for representing pixels that are turned off.
	 */
	private char offChar;

	/**
	 * Constructor which sets the characters representing pixels that 
	 * are turned on and pixels that are turned off.
	 * @param onChar character representing pixels that are turned on
	 * @param offChar character representing pixels that are turned off
	 */
	public SimpleRasterView(char onChar, char offChar) {
		this.onChar = onChar;
		this.offChar = offChar;
	}

	/**
	 * Default constructor which sets '*' as the character for pixels 
	 * that are turned on and '.' for pixels that are turned on.
	 */
	public SimpleRasterView() {
		this('*', '.');
	}

	@Override
	public Object produce(BWRaster raster) {
		int width = raster.getWidth();
		int height = raster.getHeight();
		for (int y = 0; y < height; ++y) {
			for (int x = 0; x < width; ++x) {
				if (raster.isTurnedOn(x, y)) {
					System.out.print(onChar);
				} else {
					System.out.print(offChar);
				}
			}
			System.out.println();
		}
		return null;
	}

}
