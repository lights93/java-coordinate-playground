package minhoyoo.calculator.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Rectangle extends AbstractFigure {
	public static final int RECTANGLE_SIZE = 4;

	private final double width;
	private final double height;

	protected Rectangle(List<Coordinate> coordinates) {
		super(coordinates);
		Collections.sort(coordinates);

		checkValid(coordinates);
		width = new Line(Arrays.asList(coordinates.get(0), coordinates.get(1))).calculate();
		height = new Line(Arrays.asList(coordinates.get(0), coordinates.get(2))).calculate();
	}

	private void checkValid(List<Coordinate> coordinates) {
		if (!(coordinates.get(0).getX() == coordinates.get(1).getX()
			&& coordinates.get(2).getX() == coordinates.get(3).getX()
			&& coordinates.get(0).getY() == coordinates.get(2).getY()
			&& coordinates.get(1).getY() == coordinates.get(3).getY())) {
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
