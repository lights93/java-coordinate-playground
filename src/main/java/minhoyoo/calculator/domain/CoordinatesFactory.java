package minhoyoo.calculator.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CoordinatesFactory {
	private static final String COORDINATE_SEPARATOR = "-";
	private static final String POINT_SEPARATOR = ",";
	public static final int LINE_SIZE = 2;

	private CoordinatesFactory() {
	}

	public static Coordinates from(String input) {
		String[] split = input.split(COORDINATE_SEPARATOR);
		if(split.length == LINE_SIZE) {
			return Coordinates.from(parseCoordinates(split));
		}

		throw new IllegalArgumentException("잘못된 좌표 개수 입니다.");

	}

	private static List<Coordinate> parseCoordinates(String[] split) {
		return Arrays.stream(split)
			.map(CoordinatesFactory::parseCoordinate)
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
