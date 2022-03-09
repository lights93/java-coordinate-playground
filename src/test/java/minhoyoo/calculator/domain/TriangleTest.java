package minhoyoo.calculator.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TriangleTest {
	@DisplayName("삼각형 생성 에러")
	@Test
	void constructError() {
		List<Coordinate> coordinates = Arrays.asList(
			Coordinate.create(10, 11),
			Coordinate.create(10, 18));

		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> new Triangle(coordinates))
			.withMessage("삼각형의 좌표가 아닙니다.");
	}

	@DisplayName("삼각형 넓이 계산")
	@Test
	void calculate() {
		Triangle triangle = (Triangle)CoordinatesFactory.from("(10,10)-(14,15)-(20,8)");

		assertThat(triangle.calculate()).isEqualTo(29.0, offset(0.00099));
	}
}
