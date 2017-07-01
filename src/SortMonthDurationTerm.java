import java.util.Comparator;

public class SortMonthDurationTerm implements Comparator<RideTime> {

	@Override
	public int compare(RideTime v1, RideTime v2) {
		// Assume no nulls, and simple ordinal comparisons

		// First by month
		int monthResult = v1.getMonthWord().compareTo(v2.getMonthWord());
		if (monthResult != 0) {
			return monthResult;
		}

		// Next by minute duration
		int durationResult = v1.getDurationMin().compareTo(v2.getDurationMin());
		if (durationResult != 0) {
			return durationResult;
		}

		// Finally by terminal
		return v1.getStartTerminal().compareTo(v2.getStartTerminal());
	}

}