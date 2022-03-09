package minhoyoo.calculator.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FigureFactory {
	private static final String POINT_SEPARATOR = "-";
	private static final String POINT_INTERNAL_SEPARATOR = ",";
	private static final Map<Integer, Function<List<Point>, Figure>> SIZE_TO_FIGURE = sizeToFigure();

	private FigureFactory() {
	}

	private static Map<Integer, Function<List<Point>, Figure>> sizeToFigure() {
		Map<Integer, Function<List<Point>, Figure>> sizeToFigure = new HashMap<>();

		sizeToFigure.put(Line.LINE_SIZE, Line::new);
		sizeToFigure.put(Rectangle.RECTANGLE_SIZE, Rectangle::new);
		sizeToFigure.put(Triangle.TRIANGLE_SIZE, Triangle::new);

		return sizeToFigure;
	}

	public static Figure from(String points) {
		String[] split = points.split(POINT_SEPARATOR);
		if (!SIZE_TO_FIGURE.containsKey(split.length)) {
			throw new IllegalArgumentException("잘못된 좌표 개수 입니다.");
		}

		return SIZE_TO_FIGURE.get(split.length).apply(parsePoints(split));
	}

	private static List<Point> parsePoints(String[] split) {
		return Arrays.stream(split)
			.map(FigureFactory::parsePoint)
			.collect(Collectors.toList());
	}

	private static Point parsePoint(String point) {
		try {
			String[] points = point.substring(1, point.length() - 1).split(POINT_INTERNAL_SEPARATOR);
			return Point.create(Integer.parseInt(points[0]), Integer.parseInt(points[1]));
		} catch (Exception e) {
			throw new IllegalArgumentException("잘못된 입력입니다.");
		}
	}
}
