package minhoyoo.calculator.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CoordinatesViewTest {
	@DisplayName("좌표 찍기")
	@Test
	void create() {
		Coordinates coordinates = CoordinatesParser.parse("(2,23)-(3,22)");

		String actual = CoordinatesView.create(coordinates);

		String expected = "  |                                                                        \n"
			+ "24|                                                                        \n"
			+ "  |                                                                        \n"
			+ "  |                                                                        \n"
			+ "23|    *                                                                   \n"
			+ "  |                                                                        \n"
			+ "  |                                                                        \n"
			+ "22|       *                                                                \n"
			+ "  |                                                                        \n"
			+ "  |                                                                        \n"
			+ "21|                                                                        \n"
			+ "  |                                                                        \n"
			+ "  |                                                                        \n"
			+ "20|                                                                        \n"
			+ "  |                                                                        \n"
			+ "  |                                                                        \n"
			+ "19|                                                                        \n"
			+ "  |                                                                        \n"
			+ "  |                                                                        \n"
			+ "18|                                                                        \n"
			+ "  |                                                                        \n"
			+ "  |                                                                        \n"
			+ "17|                                                                        \n"
			+ "  |                                                                        \n"
			+ "  |                                                                        \n"
			+ "16|                                                                        \n"
			+ "  |                                                                        \n"
			+ "  |                                                                        \n"
			+ "15|                                                                        \n"
			+ "  |                                                                        \n"
			+ "  |                                                                        \n"
			+ "14|                                                                        \n"
			+ "  |                                                                        \n"
			+ "  |                                                                        \n"
			+ "13|                                                                        \n"
			+ "  |                                                                        \n"
			+ "  |                                                                        \n"
			+ "12|                                                                        \n"
			+ "  |                                                                        \n"
			+ "  |                                                                        \n"
			+ "11|                                                                        \n"
			+ "  |                                                                        \n"
			+ "  |                                                                        \n"
			+ "10|                                                                        \n"
			+ "  |                                                                        \n"
			+ "  |                                                                        \n"
			+ " 9|                                                                        \n"
			+ "  |                                                                        \n"
			+ "  |                                                                        \n"
			+ " 8|                                                                        \n"
			+ "  |                                                                        \n"
			+ "  |                                                                        \n"
			+ " 7|                                                                        \n"
			+ "  |                                                                        \n"
			+ "  |                                                                        \n"
			+ " 6|                                                                        \n"
			+ "  |                                                                        \n"
			+ "  |                                                                        \n"
			+ " 5|                                                                        \n"
			+ "  |                                                                        \n"
			+ "  |                                                                        \n"
			+ " 4|                                                                        \n"
			+ "  |                                                                        \n"
			+ "  |                                                                        \n"
			+ " 3|                                                                        \n"
			+ "  |                                                                        \n"
			+ "  |                                                                        \n"
			+ " 2|                                                                        \n"
			+ "  |                                                                        \n"
			+ "  |                                                                        \n"
			+ " 1|                                                                        \n"
			+ "  |                                                                        \n"
			+ "  +                                                \n"
			+ " 0  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 ";

		assertThat(actual).isEqualTo(expected);
	}
}