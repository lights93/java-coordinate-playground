package minhoyoo.calculator;

import minhoyoo.calculator.common.Input;
import minhoyoo.calculator.common.Output;
import minhoyoo.calculator.domain.Figure;
import minhoyoo.calculator.domain.FigureFactory;
import minhoyoo.calculator.domain.FigureView;

public class Application {
	public static void main(String[] args) {
		Figure figure = getFigure();
		Output.printFigureView(FigureView.create(figure));
		Output.printResult(FigureView.makeResultMessage(figure));
	}

	private static Figure getFigure() {
		try {
			Output.askCoordinates();
			return FigureFactory.from(Input.getCoordinates());
		} catch (IllegalArgumentException e) {
			Output.printErrorMessage(e.getMessage());
			return getFigure();
		}
	}
}
