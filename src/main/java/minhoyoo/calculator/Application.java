package minhoyoo.calculator;

import minhoyoo.calculator.common.Input;
import minhoyoo.calculator.common.Output;

public class Application {
	public static void main(String[] args) {
		String coordinates = getCoordinates();
	}

	private static String getCoordinates() {
		Output.askCoordinates();
		return Input.getCoordinates();
	}
}
