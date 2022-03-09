package minhoyoo.calculator.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Triangle extends Coordinates {
	public static final int SIZE = 3;

	private final List<Double> lengths;

	public Triangle(List<Coordinate> elements) {
		super(elements);

		if (elements.size() != SIZE) {
			throw new IllegalArgumentException("삼각형의 좌표가 아닙니다.");
		}

		lengths = Arrays.asList(
			new Line(Arrays.asList(elements.get(0), elements.get(1))).calculate(),
			new Line(Arrays.asList(elements.get(1), elements.get(2))).calculate(),
			new Line(Arrays.asList(elements.get(0), elements.get(2))).calculate()
		);
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
