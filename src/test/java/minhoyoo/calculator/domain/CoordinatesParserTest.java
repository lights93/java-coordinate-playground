package minhoyoo.calculator.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CoordinatesParserTest {
	@DisplayName("문자열을 좌표로 변환")
	@Test
	void parse() {
		Coordinates actual = CoordinatesParser.parse("(10,10)-(14,15)");

		assertThat(actual)
			.isEqualTo(Coordinates.from(Arrays.asList(Coordinate.create(10,10), Coordinate.create(14,15))));
	}
}