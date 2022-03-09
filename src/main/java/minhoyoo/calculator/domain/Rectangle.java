package minhoyoo.calculator.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Rectangle implements Figure {
	public static final int SIZE = 4;

	private final List<Coordinate> coordinates;
	private final double width;
	private final double height;

	protected Rectangle(List<Coordinate> coordinates) {
		Collections.sort(coordinates);

		if (isNotValidRectangle(coordinates)) {
			throw new IllegalArgumentException("직사각형의 좌표가 아닙니다.");
		}

		this.coordinates = coordinates;
		width = new Line(Arrays.asList(coordinates.get(0), coordinates.get(1))).calculate();
		height = new Line(Arrays.asList(coordinates.get(0), coordinates.get(2))).calculate();
	}

	@Override
	public List<Coordinate> getCoordinates() {
		return coordinates;
	}

	private boolean isNotValidRectangle(List<Coordinate> coordinates) {
		if (coordinates.size() != SIZE) {
			return true;
		}

		return !(coordinates.get(0).getX() == coordinates.get(1).getX()
			&& coordinates.get(2).getX() == coordinates.get(3).getX()
			&& coordinates.get(0).getY() == coordinates.get(2).getY()
			&& coordinates.get(1).getY() == coordinates.get(3).getY());
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
			&& Double.compare(rectangle.height, height) == 0 && Objects.equals(coordinates,
			rectangle.coordinates);
	}

	@Override
	public int hashCode() {
		return Objects.hash(coordinates, width, height);
	}
}
