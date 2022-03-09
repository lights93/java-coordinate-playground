package minhoyoo.calculator.domain;

import java.util.HashMap;
import java.util.Map;

public class FigureView {
	private static final int MAX_VALUE = 24;
	private static final int ONE_LINE_SIZE = 76;
	private static final String DEFAULT_VIEW = defaultView();
	public static final int BLOCK_SIZE = 3;
	public static final int LEFT_TOP = 80;
	public static final String DISPLAY_VALUE = "*";
	private static final Map<Class<? extends Figure>, String> FIGURE_TO_FORMAT = figureToFormat();

	private FigureView() {
	}

	private static String defaultView() {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = MAX_VALUE; i > 0; i--) {
			stringBuilder.append("  |                                                                        \n");
			stringBuilder.append(
				String.format("%2d|                                                                        %n", i));
			stringBuilder.append("  |                                                                        \n");
		}

		stringBuilder.append("  +------------------------------------------------------------------------\n");
		stringBuilder.append(" 0 ");
		for (int i = 1; i <= MAX_VALUE; i++) {
			stringBuilder.append(String.format("%2d ", i));
		}

		return stringBuilder.toString();
	}

	private static Map<Class<? extends Figure>, String> figureToFormat() {
		Map<Class<? extends Figure>, String> figureToFormat = new HashMap<>();
		figureToFormat.put(Line.class, "두 점 사이의 거리는 %.6f");
		figureToFormat.put(Rectangle.class, "사각형 넓이는 %.0f");
		figureToFormat.put(Triangle.class, "삼각형 넓이는 %.1f");

		return figureToFormat;
	}

	public static String create(Figure figure) {
		StringBuilder stringBuilder = new StringBuilder(DEFAULT_VIEW);

		for (Coordinate coordinate : figure.getCoordinates()) {
			int start = LEFT_TOP
				+ ONE_LINE_SIZE * BLOCK_SIZE * (MAX_VALUE - coordinate.getY())
				+ BLOCK_SIZE * (coordinate.getX() - 1);
			stringBuilder.replace(start, start + 1, DISPLAY_VALUE);
		}

		return stringBuilder.toString();
	}

	public static String makeResultMessage(Figure figure) {
		if (!FIGURE_TO_FORMAT.containsKey(figure.getClass())) {
			throw new IllegalArgumentException("잘못된 타입입니다.");
		}

		return String.format(FIGURE_TO_FORMAT.get(figure.getClass()), figure.calculate());
	}
}
