package minhoyoo.calculator.domain;

import java.util.List;
import java.util.Objects;

public abstract class Coordinates {
	private final List<Coordinate> elements;

	protected Coordinates(List<Coordinate> elements) {
		this.elements = elements;
	}

	public abstract double calculate();

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Coordinates that = (Coordinates)o;
		return Objects.equals(elements, that.elements);
	}

	@Override
	public int hashCode() {
		return Objects.hash(elements);
	}

	public List<Coordinate> getElements() {
		return elements;
	}
}
