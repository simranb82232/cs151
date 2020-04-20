package hw2;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.*;

public class CompositeShape implements Shape {
	private ArrayList<Shape> shapes = new ArrayList<Shape>();
	public void add(Shape shape) {
		shapes.add(shape);
	}
	@Override
	public Rectangle getBounds() {
		Rectangle r = new Rectangle();
		for (Shape s : shapes) {
			r = r.union(s.getBounds());
		}
		return r;
	}
	@Override
	public Rectangle2D getBounds2D() {
		Rectangle2D r = shapes.get(0).getBounds2D();
		for (Shape s : shapes) {
			r = r.createUnion(s.getBounds2D());
		}
		return r;
	}
	@Override
	public boolean contains(double x, double y) {
		for (Shape s : shapes) {
			if (s.contains(x, y)) {
				return true;
			}
		}
		return false;
	}
	@Override
	public boolean contains(Point2D p) {
		for (Shape s : shapes) {
			if (s.contains(p)) {
				return true;
			}
		}
		return false;
	}
	@Override
	public boolean intersects(double x, double y, double w, double h) {
		for (Shape s : shapes) {
			if (s.intersects(x, y, w, h)) {
				return true;
			}
		}
		return false;
	}
	@Override
	public boolean intersects(Rectangle2D r) {
		for (Shape s : shapes) {
			if (s.intersects(r)) {
				return true;
			}
		}
		return false;
	}
	@Override
	public boolean contains(double x, double y, double w, double h) {
		for (Shape s : shapes) {
			if (s.contains(x, y, w, h)) {
				return true;
			}
		}
		return false;
	}
	@Override
	public boolean contains(Rectangle2D r) {
		for (Shape s : shapes) {
			if (s.contains(r)) {
				return true;
			}
		}
		return false;
	}
	@Override
	public PathIterator getPathIterator(AffineTransform at) {
		 return new PathIterator() {
	            private PathIterator currentPathIterator;
	            private Iterator<Shape> shapesIterator;

	            // Constructor for an anonymous class
	            {
	                shapesIterator = shapes.iterator();
	                nextShape();
	            }

	            private void nextShape() {
	                if (shapesIterator.hasNext()) {
	                    currentPathIterator = shapesIterator.next().getPathIterator(at);
	                } else {
	                    currentPathIterator = null;
	                }
	            }

	            @Override
	            public int getWindingRule() {
	                return WIND_NON_ZERO;
	            }

	            @Override
	            public boolean isDone() {
	                if (currentPathIterator == null)
	                    return true;
	                if (!currentPathIterator.isDone())
	                    return false;
	                nextShape();
	                return isDone(); // using recursion here but you can just loop through it too
	            }

	            @Override
	            public void next() {
	                currentPathIterator.next();
	            }

	            @Override
	            public int currentSegment(float[] coords) {
	                return currentPathIterator.currentSegment(coords);
	            }

	            @Override
	            public int currentSegment(double[] coords) {
	                return currentPathIterator.currentSegment(coords);
	            }
	        };
	}
	@Override
	public PathIterator getPathIterator(AffineTransform at, double flatness) {
		 return new PathIterator() {
	            private PathIterator currentPathIterator;
	            private Iterator<Shape> shapesIterator;

	            // Constructor for an anonymous class
	            {
	                shapesIterator = shapes.iterator();
	                nextShape();
	            }

	            private void nextShape() {
	                if (shapesIterator.hasNext()) {
	                    currentPathIterator = shapesIterator.next().getPathIterator(at, flatness);
	                } else {
	                    currentPathIterator = null;
	                }
	            }

	            @Override
	            public int getWindingRule() {
	                return WIND_NON_ZERO;
	            }

	            @Override
	            public boolean isDone() {
	                if (currentPathIterator == null)
	                    return true;
	                if (!currentPathIterator.isDone())
	                    return false;
	                nextShape();
	                return isDone(); // using recursion here but you can just loop through it too
	            }

	            @Override
	            public void next() {
	                currentPathIterator.next();
	            }

	            @Override
	            public int currentSegment(float[] coords) {
	                return currentPathIterator.currentSegment(coords);
	            }

	            @Override
	            public int currentSegment(double[] coords) {
	                return currentPathIterator.currentSegment(coords);
	            }
	        };
	}
	
}
