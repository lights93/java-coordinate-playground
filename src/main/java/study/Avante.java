package study;

public class Avante extends Car{
	private static final double DISTANCE_PER_LITER = 15;
	private final double tripDistance;

	public Avante(int tripDistance) {
		this.tripDistance = tripDistance;
	}

	@Override
	double getDistancePerLiter() {
		return DISTANCE_PER_LITER;
	}

	@Override
	double getTripDistance() {
		return tripDistance;
	}

	@Override
	String getName() {
		return getClass().getSimpleName();
	}
}
