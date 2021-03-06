package minhoyoo.calculator.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;

class FigureFactoryTest {
	@DisplayName("문자열을 직선으로 변환")
	@Test
	void createLine() {
		Figure actual = FigureFactory.from("(10,10)-(14,15)");

		assertThat(actual)
			.isEqualTo(new Line(Arrays.asList(Point.create(10, 10), Point.create(14, 15))));
	}

	@DisplayName("문자열을 사각형으로 변환")
	@Test
	void createRectangle() {
		Figure actual = FigureFactory.from("(10,10)-(22,10)-(22,18)-(10,18)");

		assertThat(actual)
			.isEqualTo(new Rectangle(Arrays.asList(
				Point.create(10, 10),
				Point.create(22, 10),
				Point.create(22, 18),
				Point.create(10, 18))));
	}

	@DisplayName("문자열을 삼각형으로 변환")
	@Test
	void createTriangle() {
		Figure actual = FigureFactory.from("(10,10)-(22,18)-(10,18)");

		assertThat(actual)
			.isEqualTo(new Triangle(Arrays.asList(
				Point.create(10, 10),
				Point.create(22, 18),
				Point.create(10, 18))));
	}

	@DisplayName("문자열을 좌표로 변환시 에러 발생")
	@ParameterizedTest
	@EmptySource
	@CsvSource(value = {"(10,10)", "(10,10)-(14,15)-(14,16)", "(10,10)-(14,15)-(14,16)-(14,17)-(14,18)"})
	void fromError(String input) {

		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> FigureFactory.from(input))
			.withMessage("잘못된 좌표 개수 입니다.");
	}
}