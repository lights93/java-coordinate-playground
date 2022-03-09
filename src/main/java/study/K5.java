package study;

public class K5 extends Car {
	private static final double DISTANCE_PER_LITER = 13;
	private final double tripDistance;

	public K5(int tripDistance) {
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