package minhoyoo.calculator.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Rectangle extends Coordinates {
	public static final int SIZE = 4;

	private final int width;
	private final int height;

	protected Rectangle(List<Coordinate> elements) {
		super(elements);

		Collections.sort(elements);

		if (isNotValidRectangle(elements)) {
			throw new IllegalArgumentException("직사각형의 좌표가 아닙니다.");
		}

		width = elements.get(3).getX() - elements.get(0).getX();
		height = elements.get(3).getY() - elements.get(0).getY();
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
		return 0;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		if (!super.equals(o))
			return false;
		Rectangle rectangle = (Rectangle)o;
		return width == rectangle.width && height == rectangle.height;
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), width, height);
	}
}
