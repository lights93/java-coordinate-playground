package minhoyoo.calculator.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RectangleTest {
	@DisplayName("사각형 거리 계산")
	@Test
	void calculate() {
		Rectangle rectangle = (Rectangle)CoordinatesFactory.from("(10,10)-(10,11)-(11,10)-(11,11)");

		assertThat(rectangle.calculate()).isEqualTo(1);
	}
}
