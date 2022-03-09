package minhoyoo.calculator.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FigureViewTest {
	@DisplayName("좌표 찍기")
	@Test
	void create() {
		Figure figure = FigureFactory.from("(2,23)-(3,22)");

		String actual = FigureView.makePlane(figure);

		String expected = "  |                                                                        \n"
			+ "24|                                                                        \n"
			+ "  |                                                                        \n"
			+ "  |                                                                        \n"
			+ "23|    *                                                                   \n"
			+ "  |                                                                        \n"
			+ "  |                                                                        \n"
			+ "22|       *                                                                \n"
			+ "  |                                                                        \n"
			+ "  |                                                                        \n"
			+ "21|                                                                        \n"
			+ "  |                                                                        \n"
			+ "  |                                                                        \n"
			+ "20|                                                                        \n"
			+ "  |                                                                        \n"
			+ "  |                                                                        \n"
			+ "19|                                                                        \n"
			+ "  |                                                                        \n"
			+ "  |                                                                        \n"
			+ "18|                                                                        \n"
			+ "  |                                                                        \n"
			+ "  |                                                                        \n"
			+ "17|                                                                        \n"
			+ "  |                                                                        \n"
			+ "  |                                                                        \n"
			+ "16|                                                                        \n"
			+ "  |                                                                        \n"
			+ "  |                                                                        \n"
			+ "15|                                                                        \n"
			+ "  |                                                                        \n"
			+ "  |                                                                        \n"
			+ "14|                                                                        \n"
			+ "  |                                                                        \n"
			+ "  |                                                                        \n"
			+ "13|                                                                        \n"
			+ "  |                                                                        \n"
			+ "  |                                                                        \n"
			+ "12|                                                                        \n"
			+ "  |                                                                        \n"
			+ "  |                                                                        \n"
			+ "11|                                                                        \n"
			+ "  |                                                                        \n"
			+ "  |                                                                        \n"
			+ "10|                                                                        \n"
			+ "  |                                                                        \n"
			+ "  |                                                                        \n"
			+ " 9|                                                                        \n"
			+ "  |                                                                        \n"
			+ "  |                                                                        \n"
			+ " 8|                                                                        \n"
			+ "  |                                                                        \n"
			+ "  |                                                                        \n"
			+ " 7|                                                                        \n"
			+ "  |                                                                        \n"
			+ "  |                                                                        \n"
			+ " 6|                                                                        \n"
			+ "  |                                                                        \n"
			+ "  |                                                                        \n"
			+ " 5|                                                                        \n"
			+ "  |                                                                        \n"
			+ "  |                                                                        \n"
			+ " 4|                                                                        \n"
			+ "  |                                                                        \n"
			+ "  |                                                                        \n"
			+ " 3|                                                                        \n"
			+ "  |                                                                        \n"
			+ "  |                                                                        \n"
			+ " 2|                                                                        \n"
			+ "  |                                                                        \n"
			+ "  |                                                                        \n"
			+ " 1|                                                                        \n"
			+ "  |                                                                        \n"
			+ "  +------------------------------------------------------------------------\n"
			+ " 0  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 ";

		assertThat(actual).isEqualTo(expected);
	}

	@DisplayName("직선 결과 메시지 생성")
	@Test
	void makeLineMessage() {
		Line line = (Line)FigureFactory.from("(10,10)-(14,15)");

		assertThat(FigureView.makeResultMessage(line))
			.isEqualTo("두 점 사이의 거리는 6.403124");
	}

	@DisplayName("사각형 결과 메시지 생성")
	@Test
	void makeRectangleMessage() {
		Rectangle rectangle = (Rectangle)FigureFactory.from("(10,10)-(22,10)-(22,18)-(10,18)");

		assertThat(FigureView.makeResultMessage(rectangle))
			.isEqualTo("사각형 넓이는 96");
	}

	@DisplayName("사각형 결과 메시지 생성")
	@Test
	void makeTriangleMessage() {
		Triangle triangle = (Triangle)FigureFactory.from("(10,10)-(14,15)-(20,8)");

		assertThat(FigureView.makeResultMessage(triangle))
			.isEqualTo("삼각형 넓이는 29.0");
	}
}
