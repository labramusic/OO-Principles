package hr.fer.zemris.java.graphics.views;

import hr.fer.zemris.java.graphics.raster.BWRaster;

/**
 * Returns a String containing textual representation of the image.
 * @author labramusic
 *
 */
public class StringRasterView implements RasterView {

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
	public StringRasterView(char onChar, char offChar) {
		this.onChar = onChar;
		this.offChar = offChar;
	}

	/**
	 * Default constructor which sets '*' as the character for pixels 
	 * that are turned on and '.' for pixels that are turned on.
	 */
	public StringRasterView() {
		this('*', '.');
	}

	@Override
	public Object produce(BWRaster raster) {
		StringBuilder sb = new StringBuilder();
		for (int y = 0; y < raster.getHeight(); ++y) {
			for (int x = 0; x < raster.getWidth(); ++x) {
				if (raster.isTurnedOn(x, y)) {
					sb.append(onChar);
				} else {
					sb.append(offChar);
				}
			}
			sb.append('\n');
		}
		return sb.toString();
	}

}
