package minhoyoo.calculator.domain;

import java.util.List;

public class Triangle extends Coordinates {
	public static final int SIZE = 3;

	public Triangle(List<Coordinate> elements) {
		super(elements);

		if (elements.size() != SIZE) {
			throw new IllegalArgumentException("삼각형의 좌표가 아닙니다.");
		}
	}

	@Override
	public double calculate() {
		return 0;
	}
}
