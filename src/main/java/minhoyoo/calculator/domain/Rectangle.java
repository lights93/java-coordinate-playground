package minhoyoo.calculator.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Rectangle extends AbstractFigure {
	public static final int SIZE = 4;

	private final double width;
	private final double height;

	protected Rectangle(List<Point> points) {
		super(points);
		Collections.sort(points);

		checkValid(points);
		width = points.get(0).calculateDistance(points.get(1));
		height = points.get(0).calculateDistance(points.get(2));
	}

	private void checkValid(List<Point> points) {
		if (points.size() != SIZE) {
			throw new IllegalArgumentException(SIZE + "개의 좌표가 아닙니다.");
		}

		if (!(getPoints().get(0).isSameX(getPoints().get(1)) &&
			getPoints().get(2).isSameX(getPoints().get(3)) &&
			getPoints().get(0).isSameY(getPoints().get(2)) &&
			getPoints().get(1).isSameY(getPoints().get(3)))) {
			throw new IllegalArgumentException("직사각형의 좌표가 아닙니다.");
		}
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
