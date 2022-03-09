package minhoyoo.calculator.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RectangleTest {
	@DisplayName("사각형 생성 에러")
	@Test
	void constructError() {
		List<Point> points = Arrays.asList(
			Point.create(10, 10),
			Point.create(10, 11),
			Point.create(10, 18));

		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> new Rectangle(points))
			.withMessage("4개의 좌표가 아닙니다.");
	}

	@DisplayName("사각형 거리 계산")
	@Test
	void calculate() {
		Rectangle rectangle = (Rectangle)FigureFactory.from("(10,10)-(10,11)-(11,10)-(11,11)");

		assertThat(rectangle.calculate()).isEqualTo(1);
	}
}
