package minhoyoo.calculator.domain;

import java.util.List;

public class Line extends AbstractFigure {
	public static final int LINE_SIZE = 2;

	public Line(List<Point> points) {
		super(points);
	}

	@Override
	public int size() {
		return LINE_SIZE;
	}

	@Override
	public double calculate() {
		return Math.sqrt(Math.pow(Math.abs(getPoints().get(0).getX() - getPoints().get(1).getX()), 2) +
			Math.pow(Math.abs(getPoints().get(0).getY() - getPoints().get(1).getY()), 2));
	}
}
