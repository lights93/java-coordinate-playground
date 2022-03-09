package minhoyoo.calculator.domain;

import java.util.List;
import java.util.Objects;

public class Line implements Coordinates {
	public static final int SIZE = 2;

	private final List<Coordinate> elements;

	protected Line(List<Coordinate> elements) {
		this.elements = elements;
		if (elements.size() != 2) {
			throw new IllegalArgumentException("직선의 좌표가 아닙니다.");
		}
	}

	@Override
	public List<Coordinate> getElements() {
		return elements;
	}

	@Override
	public double calculate() {
		return Math.sqrt(Math.pow(Math.abs(elements.get(0).getX() - elements.get(1).getX()), 2) +
			Math.pow(Math.abs(elements.get(0).getY() - elements.get(1).getY()), 2));
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Line line = (Line)o;
		return Objects.equals(elements, line.elements);
	}

	@Override
	public int hashCode() {
		return Objects.hash(elements);
	}
}
