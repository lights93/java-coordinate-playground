package minhoyoo.calculator;

import minhoyoo.calculator.common.Input;
import minhoyoo.calculator.common.Output;
import minhoyoo.calculator.domain.Coordinates;
import minhoyoo.calculator.domain.CoordinatesParser;

public class Application {
	public static void main(String[] args) {
		Coordinates coordinates = getCoordinates();
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
