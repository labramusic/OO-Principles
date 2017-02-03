package hr.fer.zemris.java.graphics.views;

import hr.fer.zemris.java.graphics.raster.BWRaster;

/**
 * Classes which implement this interface will be responsible for visualization
 * of created images.
 * 
 * @author labramusic
 *
 */
public interface RasterView {

	/**
	 * Produces a visualization of the the image created by the raster.
	 * @param raster raster for drawing images
	 * @return produced image object
	 */
	Object produce(BWRaster raster);

}
