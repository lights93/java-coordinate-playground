package minhoyoo.calculator.domain;

import java.util.List;

public interface Figure {
	double calculate();

	List<Coordinate> getCoordinates();

	int size();
}
