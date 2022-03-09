package minhoyoo.calculator.common;

import java.util.Scanner;

public class Input {
	private static final Scanner scanner = new Scanner(System.in);

	private Input() {
	}

	public static String getCoordinates() {
		return scanner.nextLine();
	}
}