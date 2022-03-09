package study;

public class Avante implements Car{
	private static final double DISTANCE_PER_LITER = 15;
	private final double tripDistance;

	public Avante(int tripDistance) {
		this.tripDistance = tripDistance;
	}

	public double getDistancePerLiter() {
		return DISTANCE_PER_LITER;
	}

	public double getTripDistance() {
		return tripDistance;
	}

	@Override
	public String getName() {
		return getClass().getSimpleName();
	}
}
