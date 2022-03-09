package minhoyoo.calculator;

import minhoyoo.calculator.common.Input;
import minhoyoo.calculator.common.Output;

public class Application {
	public static void main(String[] args) {
		String coordinates = getCoordinates();
	}

	private static String getCoordinates() {
		try {
			Output.askCoordinates();
			return Input.getCoordinates();
		} catch (IllegalArgumentException e) {
			Output.printErrorMessage(e.getMessage());
			return getCoordinates();
		}
	}
}
