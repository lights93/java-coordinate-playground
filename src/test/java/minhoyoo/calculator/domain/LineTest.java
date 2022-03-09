package minhoyoo.calculator.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LineTest {
	@DisplayName("직선 거리 계산")
	@Test
	void calculate() {
		Line line = (Line)FigureFactory.from("(10,10)-(11,11)");

		assertThat(line.calculate()).isEqualTo(1.414, offset(0.00099));
	}

	@DisplayName("직선 생성 에러")
	@Test
	void constructError() {
		List<Coordinate> coordinates = Arrays.asList(
			Coordinate.create(10, 10),
			Coordinate.create(10, 11),
			Coordinate.create(10, 18));

		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> new Line(coordinates))
			.withMessage("직선의 좌표가 아닙니다.");
	}
}