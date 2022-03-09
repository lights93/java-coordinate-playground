package minhoyoo.calculator.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Rectangle extends AbstractFigure {
	public static final int RECTANGLE_SIZE = 4;

	private final double width;
	private final double height;

	protected Rectangle(List<Point> points) {
		super(points);
		Collections.sort(points);

		checkValid(points);
		width = new Line(Arrays.asList(points.get(0), points.get(1))).calculate();
		height = new Line(Arrays.asList(points.get(0), points.get(2))).calculate();
	}

	private void checkValid(List<Point> points) {
		if (!(points.get(0).getX() == points.get(1).getX()
			&& points.get(2).getX() == points.get(3).getX()
			&& points.get(0).getY() == points.get(2).getY()
			&& points.get(1).getY() == points.get(3).getY())) {
			throw new IllegalArgumentException("직사각형의 좌표가 아닙니다.");
		}
	}

	@Override
	public int size() {
		return RECTANGLE_SIZE;
	}

	@Override
	public double calculate() {
		return width * height;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Rectangle rectangle = (Rectangle)o;
		return Double.compare(rectangle.width, width) == 0
			&& Double.compare(rectangle.height, height) == 0;
	}

	@Override
	public int hashCode() {
		return Objects.hash(width, height);
	}
}
