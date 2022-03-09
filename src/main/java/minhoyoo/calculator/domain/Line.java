package minhoyoo.calculator.domain;

import java.util.List;

public class Line extends Coordinates {
	public static final int SIZE = 2;

	protected Line(List<Coordinate> elements) {
		super(elements);

		if (elements.size() != 2) {
			throw new IllegalArgumentException("직선의 좌표가 아닙니다.");
		}
	}

	@Override
	public double calculate() {
		List<Coordinate> elements = getElements();

		return Math.sqrt(Math.pow(Math.abs(elements.get(0).getX() - elements.get(1).getX()), 2) +
			Math.pow(Math.abs(elements.get(0).getY() - elements.get(1).getY()), 2));
	}
}
