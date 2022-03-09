package minhoyoo.calculator.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CoordinateTest {
	@DisplayName("좌표 제대로 생성되는지 확인")
	@Test
	void construct() {
		Coordinate coordinate = Coordinate.create(1,2);

		assertThat(coordinate.getX()).isEqualTo(1);
		assertThat(coordinate.getY()).isEqualTo(2);
	}
}