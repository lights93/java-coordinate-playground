package minhoyoo.calculator.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CoordinatesParser {
	private static final String COORDINATE_SEPARATOR = "-";
	private static final String POINT_SEPARATOR = ",";

	private CoordinatesParser() {
	}

	public static Coordinates parse(String input) {
		String[] split = input.split(COORDINATE_SEPARATOR);

		return Coordinates.from(parseCoordinates(split));
	}

	private static List<Coordinate> parseCoordinates(String[] split) {
		return Arrays.stream(split)
			.map(CoordinatesParser::parseCoordinate)
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
