package minhoyoo.calculator;

import minhoyoo.calculator.common.Input;
import minhoyoo.calculator.common.Output;
import minhoyoo.calculator.domain.Coordinates;
import minhoyoo.calculator.domain.CoordinatesParser;
import minhoyoo.calculator.domain.CoordinatesView;

public class Application {
	public static void main(String[] args) {
		Coordinates coordinates = getCoordinates();
		Output.printCoordinates(CoordinatesView.create(coordinates));
	}

	private static Coordinates getCoordinates() {
		try {
			Output.askCoordinates();
			return CoordinatesParser.parse(Input.getCoordinates());
		} catch (IllegalArgumentException e) {
			Output.printErrorMessage(e.getMessage());
			return getCoordinates();
		}
	}
}
