package hr.fer.zemris.java.graphics;

import java.util.Scanner;

import hr.fer.zemris.java.graphics.raster.BWRaster;
import hr.fer.zemris.java.graphics.raster.BWRasterMem;
import hr.fer.zemris.java.graphics.shapes.Circle;
import hr.fer.zemris.java.graphics.shapes.Ellipse;
import hr.fer.zemris.java.graphics.shapes.GeometricShape;
import hr.fer.zemris.java.graphics.shapes.Rectangle;
import hr.fer.zemris.java.graphics.shapes.Square;
import hr.fer.zemris.java.graphics.views.SimpleRasterView;

/**
 * Demonstration of classes implementing BWRaster and RasterView. The program
 * expects user to provide either a single argument or two arguments. In case
 * the user provides a single argument, its value is interpreted as width and
 * height of the raster. In case the user provides two arguments, first is
 * treated as width of the raster and second as height of the raster.
 * 
 * @author labramusic
 *
 */
public class Demo {

	/**
	 * The main method
	 * 
	 * @param args
	 *            command line arguments
	 */
	public static void main(String[] args) {
		if (args.length < 1 || args.length > 2) {
			System.err.println("Invalid number of arguments.");
			System.exit(1);
		}

		Scanner sc = new Scanner(System.in);
		BWRaster raster = null;
		GeometricShape[] shapes = null;
		try {
			int width = Integer.parseInt(args[0]);
			int height;
			if (args.length == 2) {
				height = Integer.parseInt(args[1]);
			} else {
				height = width;
			}
			raster = new BWRasterMem(width, height);

			int numOfLines = Integer.parseInt(sc.nextLine());
			shapes = new GeometricShape[numOfLines];
			int i = 0;

			while(i < numOfLines) {
				String line = sc.nextLine();
				String[] elems = line.split(" +");
				switch(elems[0].toUpperCase()) {
				case "RECTANGLE":
					int rx = Integer.parseInt(elems[1]);
					int ry = Integer.parseInt(elems[2]);
					int w = Integer.parseInt(elems[3]);
					int h = Integer.parseInt(elems[4]);
					shapes[i] = new Rectangle(rx, ry, w, h);
					break;

				case "SQUARE":
					int sx = Integer.parseInt(elems[1]);
					int sy = Integer.parseInt(elems[2]);
					int size = Integer.parseInt(elems[3]);
					shapes[i] = new Square(sx, sy, size);
					break;

				case "ELLIPSE":
					int ex = Integer.parseInt(elems[1]);
					int ey = Integer.parseInt(elems[2]);
					int radiusx = Integer.parseInt(elems[3]);
					int radiusy = Integer.parseInt(elems[4]);
					shapes[i] = new Ellipse(ex, ey, radiusx, radiusy);
					break;

				case "CIRCLE":
					int cx = Integer.parseInt(elems[1]);
					int cy = Integer.parseInt(elems[2]);
					int radius = Integer.parseInt(elems[3]);
					shapes[i] = new Circle(cx, cy, radius);
					break;

				case "FLIP":
					shapes[i] = null;
					break;

				default:
					throw new IllegalArgumentException();
				}
				++i;
			}

		} catch (IllegalArgumentException ex) {
			System.err.println("Invalid arguments.");
			System.exit(1);
		} finally {
			sc.close();
		}

		boolean flip = false;
		for (GeometricShape shape : shapes) {
			if (shape == null) {
				if (flip) {
					raster.disableFlipMode();
				} else {
					raster.enableFlipMode();
				}
			} else {
				shape.draw(raster);
			}
		}

		SimpleRasterView view = new SimpleRasterView();
		view.produce(raster);

	}

}
