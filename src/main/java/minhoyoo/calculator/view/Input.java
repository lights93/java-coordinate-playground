package minhoyoo.calculator.view;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Input {
	private static final Scanner scanner = new Scanner(System.in);
	private static final Pattern REMOVE_ALL_SPACES_PATTERN = Pattern.compile("\\s+");
	private static final String EMPTY = "";

	private Input() {
	}

	public static String getPoints() {
		return REMOVE_ALL_SPACES_PATTERN.matcher(scanner.nextLine()).replaceAll(EMPTY);
	}
}
