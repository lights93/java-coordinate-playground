package study;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RentCompany {
	private final List<Car> cars;

	public static RentCompany create() {
		return new RentCompany();
	}

	private RentCompany() {
		cars = new ArrayList<>();
	}

	public String generateReport() {
		return cars.stream()
			.map(car -> String.format("%s : %.0f리터%n", car.getName(), car.getChargeQuantity()))
			.collect(Collectors.joining());

	}

	public void addCar(Car car) {
		cars.add(car);
	}
}
