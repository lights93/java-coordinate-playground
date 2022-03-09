package minhoyoo.calculator.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LineTest {
	@DisplayName("직선 거리 계산")
	@Test
	void calculate() {
		Coordinates line = CoordinatesFactory.from("(10,10)-(11,11)");

		assertThat(line.calculate()).isEqualTo(1.414, offset(0.00099));
	}
}