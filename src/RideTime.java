public class RideTime {
	private String duration = null;
	private String monthDate = null;
	private String startTerminal = null;
	private Float durationMin = null;
	private String monthWord = null;

	public RideTime(String duration, String monthDate, String startTerminal) {
		this.duration = duration;
		this.monthDate = monthDate;
		this.startTerminal = startTerminal;
		String[] split = monthDate.split("/");
		this.monthWord = split[0].trim();
	}

	public void initialize() {
		String[] durationHMS = null;
		String noLetters = getDuration().replaceAll("[hms-]+", "");
		durationHMS = noLetters.split(" ");
		String hour = durationHMS[0];
		String minute = durationHMS[1];
		if (durationHMS.length < 2) {
			System.out.println(noLetters);
		}
		String second = durationHMS[2];
		float h = Float.parseFloat(hour);
		float m = Float.parseFloat(minute);
		float s = Float.parseFloat(second);
		h = h * 60;
		s = s / 60;

		float totalMinuteRental = h + m + s;
		this.setDurationMin(totalMinuteRental);
	}

	public String getMonthWord() {
		return monthWord;
	}

	public void setMonthWord(String monthWord) {
		this.monthWord = monthWord;
	}

	public Float getDurationMin() {
		return durationMin;
	}

	public void setDurationMin(Float durationMin) {
		this.durationMin = durationMin;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getMonthDate() {
		return monthDate;
	}

	public void setMonthDate(String monthDate) {
		this.monthDate = monthDate;
	}

	public String getStartTerminal() {
		return startTerminal;
	}

	public void setStartTerminal(String startTerminal) {
		this.startTerminal = startTerminal;
	}

	@Override
	public String toString() {
		return monthWord + "\t" + durationMin + "\t" + startTerminal;
	}

}
