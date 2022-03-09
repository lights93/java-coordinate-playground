package minhoyoo.calculator.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CoordinateTest {
	@DisplayName("좌표 제대로 생성되는지 확인")
	@Test
	void construct() {
		Coordinate coordinate = Coordinate.create(1,2);

		assertThat(coordinate.getX()).isEqualTo(1);
		assertThat(coordinate.getY()).isEqualTo(2);
	}

	@DisplayName("생성 시 에러")
	@ParameterizedTest
	@CsvSource(value = {"1,0", "0,1", "25,1", "1,25"})
	void contructError(int x, int y) {
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> Coordinate.create(x, y))
			.withMessage("잘못된 좌표값입니다.");
	}

	@DisplayName("비교 확인")
	@Test
	void compareTo() {
		List<Coordinate> coordinates = Arrays.asList(
			Coordinate.create(10, 10),
			Coordinate.create(22, 10),
			Coordinate.create(22, 18),
			Coordinate.create(10, 18));

		Collections.sort(coordinates);

		List<Coordinate> expected = Arrays.asList(
			Coordinate.create(10, 10),
			Coordinate.create(10, 18),
			Coordinate.create(22, 10),
			Coordinate.create(22, 18));

		assertThat(coordinates).isEqualTo(expected);
	}
}