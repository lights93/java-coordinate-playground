package minhoyoo.calculator.domain;

import java.util.List;

public class Line extends AbstractFigure {
	public static final int LINE_SIZE = 2;

	public Line(List<Coordinate> coordinates) {
		super(coordinates);
	}

	@Override
	public int size() {
		return LINE_SIZE;
	}

	@Override
	public double calculate() {
		return Math.sqrt(Math.pow(Math.abs(getCoordinates().get(0).getX() - getCoordinates().get(1).getX()), 2) +
			Math.pow(Math.abs(getCoordinates().get(0).getY() - getCoordinates().get(1).getY()), 2));
	}
}
