package minhoyoo.calculator.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;

class CoordinatesFactoryTest {
	@DisplayName("문자열을 직선으로 변환")
	@Test
	void from() {
		Coordinates actual = CoordinatesFactory.from("(10,10)-(14,15)");

		assertThat(actual)
			.isEqualTo(new Line(Arrays.asList(Coordinate.create(10, 10), Coordinate.create(14, 15))));
	}

	@DisplayName("문자열을 좌표로 변환시 에러 발생")
	@ParameterizedTest
	@EmptySource
	@CsvSource(value = {"(10,10)", "(10,10)-(14,15)-(14,16)"})
	void fromError(String input) {

		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> CoordinatesFactory.from(input))
			.withMessage("잘못된 좌표 개수 입니다.");
	}
}