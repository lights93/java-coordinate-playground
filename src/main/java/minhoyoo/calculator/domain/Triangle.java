package minhoyoo.calculator.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Triangle implements Figure {
	public static final int SIZE = 3;

	private final List<Double> lengths;
	private final List<Coordinate> elements;

	public Triangle(List<Coordinate> elements) {
		if (elements.size() != SIZE) {
			throw new IllegalArgumentException("삼각형의 좌표가 아닙니다.");
		}

		this.elements = elements;

		lengths = Arrays.asList(
			new Line(Arrays.asList(elements.get(0), elements.get(1))).calculate(),
			new Line(Arrays.asList(elements.get(1), elements.get(2))).calculate(),
			new Line(Arrays.asList(elements.get(0), elements.get(2))).calculate()
		);
	}

	@Override
	public List<Coordinate> getElements() {
		return elements;
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
		Triangle triangle = (Triangle)o;
		return Objects.equals(lengths, triangle.lengths) && Objects.equals(elements, triangle.elements);
	}

	@Override
	public int hashCode() {
		return Objects.hash(lengths, elements);
	}
}
