package minhoyoo.calculator.domain;

public class Coordinate {
	private final int x;
	private final int y;

	private Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public static Coordinate create(int x, int y) {
		return new Coordinate(x, y);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}
