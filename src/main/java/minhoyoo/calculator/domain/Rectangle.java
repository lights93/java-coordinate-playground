package minhoyoo.calculator.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Rectangle implements Figure {
	public static final int SIZE = 4;

	private final List<Coordinate> elements;
	private final double width;
	private final double height;

	protected Rectangle(List<Coordinate> elements) {
		Collections.sort(elements);

		if (isNotValidRectangle(elements)) {
			throw new IllegalArgumentException("직사각형의 좌표가 아닙니다.");
		}

		this.elements = elements;
		width = new Line(Arrays.asList(elements.get(0), elements.get(1))).calculate();
		height = new Line(Arrays.asList(elements.get(0), elements.get(2))).calculate();
	}

	@Override
	public List<Coordinate> getElements() {
		return elements;
	}

	private boolean isNotValidRectangle(List<Coordinate> elements) {
		if (elements.size() != SIZE) {
			return true;
		}

		return !(elements.get(0).getX() == elements.get(1).getX()
			&& elements.get(2).getX() == elements.get(3).getX()
			&& elements.get(0).getY() == elements.get(2).getY()
			&& elements.get(1).getY() == elements.get(3).getY());
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
			&& Double.compare(rectangle.height, height) == 0 && Objects.equals(elements,
			rectangle.elements);
	}

	@Override
	public int hashCode() {
		return Objects.hash(elements, width, height);
	}
}
