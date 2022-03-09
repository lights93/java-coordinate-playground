package minhoyoo.calculator.domain;

import java.util.List;
import java.util.Objects;

public abstract class AbstractFigure implements Figure {
	private final List<Coordinate> coordinates;

	protected AbstractFigure(List<Coordinate> coordinates) {
		if (coordinates.size() != size()) {
			throw new IllegalArgumentException(size() + "개의 좌표가 아닙니다.");
		}

		this.coordinates = coordinates;

	}

	@Override
	public List<Coordinate> getCoordinates() {
		return coordinates;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		AbstractFigure that = (AbstractFigure)o;
		return Objects.equals(coordinates, that.coordinates);
	}

	@Override
	public int hashCode() {
		return Objects.hash(coordinates);
	}
}
