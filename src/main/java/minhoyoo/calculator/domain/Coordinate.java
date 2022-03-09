package minhoyoo.calculator.domain;

public class Coordinate {
	private static final int MIN_VALUE = 1;
	private static final int MAX_VALUE = 24;
	private final int x;
	private final int y;

	private Coordinate(int x, int y) {
		checkValue(x);
		checkValue(y);
		this.x = x;
		this.y = y;
	}

	public static Coordinate create(int x, int y) {
		return new Coordinate(x, y);
	}

	private void checkValue(int val) {
		if (val < MIN_VALUE || val > MAX_VALUE) {
			throw new IllegalArgumentException("잘못된 좌표값입니다.");
		}
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}
