package minhoyoo.calculator.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Triangle extends AbstractFigure {
	public static final int TRIANGLE_SIZE = 3;

	private final List<Double> lengths;

	public Triangle(List<Coordinate> coordinates) {
		super(coordinates);

		lengths = Arrays.asList(
			new Line(Arrays.asList(coordinates.get(0), coordinates.get(1))).calculate(),
			new Line(Arrays.asList(coordinates.get(1), coordinates.get(2))).calculate(),
			new Line(Arrays.asList(coordinates.get(0), coordinates.get(2))).calculate()
		);
	}

	@Override
	public int size() {
		return TRIANGLE_SIZE;
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
