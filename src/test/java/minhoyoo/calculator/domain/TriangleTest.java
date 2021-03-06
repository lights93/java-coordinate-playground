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
		List<Point> points = Arrays.asList(
			Point.create(10, 11),
			Point.create(10, 18));

		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> new Triangle(points))
			.withMessage("3개의 좌표가 아닙니다.");
	}

	@DisplayName("삼각형 넓이 계산")
	@Test
	void calculate() {
		Triangle triangle = (Triangle)FigureFactory.from("(10,10)-(14,15)-(20,8)");

		assertThat(triangle.calculate()).isEqualTo(29.0, offset(0.00099));
	}
}
