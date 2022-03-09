package minhoyoo.calculator.service;

import minhoyoo.calculator.domain.Figure;
import minhoyoo.calculator.domain.FigureFactory;
import minhoyoo.calculator.domain.FigureView;
import minhoyoo.calculator.view.Input;
import minhoyoo.calculator.view.Output;

public class CoordinateCalculator {
	private CoordinateCalculator() {
	}

	public static void calculate() {
		Figure figure = getFigure();
		Output.printFigurePlane(FigureView.makePlane(figure));
		Output.printResult(FigureView.makeResultMessage(figure));
	}

	private static Figure getFigure() {
		try {
			Output.askPoints();
			return FigureFactory.from(Input.getPoints());
		} catch (IllegalArgumentException e) {
			Output.printErrorMessage(e.getMessage());
			return getFigure();
		}
	}
}
