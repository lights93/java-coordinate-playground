package minhoyoo.calculator.domain;

import java.util.List;

public interface Figure {
	double calculate();

	int size();

	List<Point> getPoints();
}
