
public class RideTime {
	private String duration = null;
	private String monthDate = null;
	private String startTerminal = null;
	private Integer durationMin = 0;
	private String monthWord = null;

	public RideTime(String duration, String monthDate, String startTerminal, Integer durationMin, String monthWord) {
		this.duration = duration;
		this.monthDate = monthDate;
		this.startTerminal = startTerminal;
		this.durationMin = durationMin;
		this.monthWord = monthWord;
	}

	public String getMonthWord() {
		return monthWord;
	}

	public void setMonthWord(String monthWord) {
		this.monthWord = monthWord;
	}

	public Integer getDurationMin() {
		return durationMin;
	}

	public void setDurationMin(Integer durationMin) {
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
		return this.monthWord + "\t" + this.durationMin + "\t" + this.startTerminal;
	}

}
