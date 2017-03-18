import java.util.Comparator;

public class MinutesSorting implements Comparator<RideTime> {

	@Override
	public int compare(RideTime v1, RideTime v2) {
		// Assume no nulls, and simple ordinal comparisons

		// First by minute duration
		int durationResult = v1.getDurationMin().compareTo(v2.getDurationMin());
		if (durationResult != 0) {
			return durationResult;
		}

		// Next by month
		int monthResult = v1.getMonthDate().compareTo(v2.getMonthDate());
		if (monthResult != 0) {
			return monthResult;
		}
		// Finally by terminal
		return v1.getStartTerminal().compareTo(v2.getStartTerminal());
	}

}