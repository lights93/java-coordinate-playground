package minhoyoo.calculator.common;

public class Output {
	private Output() {
	}

	public static void askCoordinates() {
		System.out.println("좌표를 입력하세요");
	}

	public static void printErrorMessage(String message) {
		System.out.println(message);
	}

	public static void printCoordinates(String coordinatesView) {
		System.out.println(coordinatesView);
	}
}
