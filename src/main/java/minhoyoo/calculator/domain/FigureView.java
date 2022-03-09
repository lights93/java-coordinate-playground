package minhoyoo.calculator.domain;

public class FigureView {
	private static final int MAX_VALUE = 24;
	private static final int ONE_LINE_SIZE = 76;
	private static final String DEFAULT_VIEW = defaultView();
	public static final int BLOCK_SIZE = 3;
	public static final int LEFT_TOP = 80;
	public static final String DISPLAY_VALUE = "*";

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

	public static String create(Figure figure) {
		StringBuilder stringBuilder = new StringBuilder(DEFAULT_VIEW);

		for (Coordinate coordinate : figure.getElements()) {
			int start = LEFT_TOP
				+ ONE_LINE_SIZE * BLOCK_SIZE * (MAX_VALUE - coordinate.getY())
				+ BLOCK_SIZE * (coordinate.getX() - 1);
			stringBuilder.replace(start, start + 1, DISPLAY_VALUE);
		}

		return stringBuilder.toString();
	}

	public static String makeResultMessage(Figure figure) {
		if (figure instanceof Line) {
			return String.format("두 점 사이의 거리는 %.6f", figure.calculate());
		}

		if (figure instanceof Rectangle) {
			return String.format("사각형 넓이는 %.0f", figure.calculate());
		}

		if (figure instanceof Triangle) {
			return String.format("삼각형 넓이는 %.1f", figure.calculate());
		}

		throw new IllegalArgumentException();
	}
}
