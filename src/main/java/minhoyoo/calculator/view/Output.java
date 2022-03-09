package minhoyoo.calculator.view;

public class Output {
	private Output() {
	}

	public static void askPoints() {
		System.out.println("좌표를 입력하세요");
	}

	public static void printErrorMessage(String message) {
		System.out.println(message);
	}

	public static void printFigurePlane(String plain) {
		System.out.println(plain);
	}

	public static void printResult(String result) {
		System.out.println();
		System.out.println(result);
	}
}
