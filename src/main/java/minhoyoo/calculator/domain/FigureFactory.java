package minhoyoo.calculator.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FigureFactory {
	private static final String COORDINATE_SEPARATOR = "-";
	private static final String POINT_SEPARATOR = ",";

	private FigureFactory() {
	}

	public static Figure from(String coordinates) {
		String[] split = coordinates.split(COORDINATE_SEPARATOR);
		if (split.length == Line.LINE_SIZE) {
			return new Line(parseCoordinates(split));
		}

		if (split.length == Rectangle.RECTANGLE_SIZE) {
			return new Rectangle(parseCoordinates(split));
		}

		if (split.length == Triangle.TRIANGLE_SIZE) {
			return new Triangle(parseCoordinates(split));
		}

		throw new IllegalArgumentException("잘못된 좌표 개수 입니다.");
	}

	private static List<Coordinate> parseCoordinates(String[] split) {
		return Arrays.stream(split)
			.map(FigureFactory::parseCoordinate)
			.collect(Collectors.toList());
	}

	private static Coordinate parseCoordinate(String coordinate) {
		try {
			String[] points = coordinate.substring(1, coordinate.length() - 1).split(POINT_SEPARATOR);
			return Coordinate.create(Integer.parseInt(points[0]), Integer.parseInt(points[1]));
		} catch (Exception e) {
			throw new IllegalArgumentException("잘못된 입력입니다.");
		}
	}
}
