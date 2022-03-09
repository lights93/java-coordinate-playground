package minhoyoo.calculator.domain;

import java.util.List;
import java.util.Objects;

public class Line implements Figure {
	public static final int SIZE = 2;

	private final List<Coordinate> coordinates;

	protected Line(List<Coordinate> coordinates) {
		this.coordinates = coordinates;
		if (coordinates.size() != 2) {
			throw new IllegalArgumentException("직선의 좌표가 아닙니다.");
		}
	}

	@Override
	public List<Coordinate> getCoordinates() {
		return coordinates;
	}

	@Override
	public double calculate() {
		return Math.sqrt(Math.pow(Math.abs(coordinates.get(0).getX() - coordinates.get(1).getX()), 2) +
			Math.pow(Math.abs(coordinates.get(0).getY() - coordinates.get(1).getY()), 2));
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Line line = (Line)o;
		return Objects.equals(coordinates, line.coordinates);
	}

	@Override
	public int hashCode() {
		return Objects.hash(coordinates);
	}
}
