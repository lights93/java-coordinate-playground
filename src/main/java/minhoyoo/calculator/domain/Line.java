package minhoyoo.calculator.domain;

import java.util.List;

public class Line extends AbstractFigure {
	public static final int SIZE = 2;

	public Line(List<Point> points) {
		super(points);
		checkValid(points);
	}

	private void checkValid(List<Point> points) {
		if (points.size() != SIZE) {
			throw new IllegalArgumentException(SIZE + "개의 좌표가 아닙니다.");
		}
	}

	@Override
	public double calculate() {
		return getPoints().get(0).calculateDistance(getPoints().get(1));
	}
}
