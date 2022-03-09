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
		return Math.sqrt(Math.pow(Math.abs(getPoints().get(0).getX() - getPoints().get(1).getX()), 2) +
			Math.pow(Math.abs(getPoints().get(0).getY() - getPoints().get(1).getY()), 2));
	}
}
