package minhoyoo.calculator.domain;

import java.util.Objects;

public class Point implements Comparable<Point> {
	private static final int MIN_VALUE = 1;
	private static final int MAX_VALUE = 24;
	private final int x;
	private final int y;

	private Point(int x, int y) {
		checkValue(x);
		checkValue(y);
		this.x = x;
		this.y = y;
	}

	public static Point create(int x, int y) {
		return new Point(x, y);
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

	public int getDiffBetweenX(Point that) {
		return Math.abs(this.x - that.x);
	}

	public boolean isSameX(Point that) {
		return this.x == that.x;
	}

	public int getDiffBetweenY(Point that) {
		return Math.abs(this.y - that.y);
	}

	public boolean isSameY(Point that) {
		return this.y == that.y;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Point that = (Point)o;
		return x == that.x && y == that.y;
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}

	@Override
	public int compareTo(Point that) {
		if (this.x != that.x) {
			return Integer.compare(this.x, that.x);
		}

		return Integer.compare(this.y, that.y);
	}

	public double calculateDistance(Point that) {
		return Math.sqrt(Math.pow(Math.abs(this.x - that.x), 2) +
			Math.pow(Math.abs(this.y - that.y), 2));
	}
}
