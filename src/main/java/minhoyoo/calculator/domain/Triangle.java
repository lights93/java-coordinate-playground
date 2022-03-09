package minhoyoo.calculator.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Triangle extends AbstractFigure {
	public static final int SIZE = 3;

	private final List<Double> lengths;

	public Triangle(List<Point> points) {
		super(points);

		checkValid(points);

		lengths = Arrays.asList(
			points.get(0).calculateDistance(points.get(1)),
			points.get(1).calculateDistance(points.get(2)),
			points.get(0).calculateDistance(points.get(2))
		);
	}

	private void checkValid(List<Point> points) {
		if (points.size() != SIZE) {
			throw new IllegalArgumentException(SIZE + "개의 좌표가 아닙니다.");
		}
	}

	@Override
	public double calculate() {
		double halfSum = lengths.stream().mapToDouble(i -> i / 2).sum();

		return Math.sqrt(
			halfSum * (halfSum - lengths.get(0)) * (halfSum - lengths.get(1)) * (halfSum - lengths.get(2)));
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		if (!super.equals(o))
			return false;
		Triangle triangle = (Triangle)o;
		return Objects.equals(lengths, triangle.lengths);
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), lengths);
	}
}
