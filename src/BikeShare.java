import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BikeShare {
	List<RideTime> rideTimes = new ArrayList<RideTime>();
	float totalMinuteRental = 0;
	String monthnum = null;

	public static String readFile(String classlist) {
		StringBuffer sb = new StringBuffer();
		BufferedReader br = null;
		String line = null;
		try {
			br = new BufferedReader(new FileReader(new File(classlist)));
			while ((line = br.readLine()) != null) {
				sb.append(line);
				sb.append("\n");
			}
			return sb.toString();
		} catch (IOException io) {
			throw new RuntimeException(io);
		} finally {
			try {
				br.close();
			} catch (IOException io) {

			}
		}
	}

	public void convertToMinute(List<RideTime> rideTimes) {
		for (RideTime r : rideTimes) {
			String[] durationHMS = null;
			String noLetters = r.getDuration().replaceAll("[hms-]+", "");
			durationHMS = noLetters.split(" ");
			String hour = durationHMS[0];
			String minute = durationHMS[1];
			String second = durationHMS[2];
			float h = Float.parseFloat(hour);
			float m = Float.parseFloat(minute);
			float s = Float.parseFloat(second);
			h = h * 60;
			s = s / 60;
			DecimalFormat df = new DecimalFormat("#.00");
			totalMinuteRental = h + m + s;
			String x = null;
			x = Float.toString(totalMinuteRental);
			x = df.format(totalMinuteRental);
			Integer y = Integer.valueOf(x);
			// System.out.println(y);
			r.setDurationMin(y);
		}
	}

	public void findMonth(List<RideTime> rideTimes) {
		for (RideTime r : rideTimes) {
			String[] md = null;
			md = r.getMonthDate().split("/");
			monthnum = md[0].trim();
			// Month[] values = Month.values(); //FIX IT LATER
			// monthString = values[monthnum.ordinal() + 1];
			r.setMonthWord(monthnum);
		}
	}

	public void longestMonthDuration(List<RideTime> rideTimes) {
		// Collections.sort(rideTimes, new MinutesSorting());
		for (RideTime r : rideTimes) {
			if ("10".equals(r.getMonthWord())) {
				// try putting most finding sort here

			}
		}
	}

	public void run() {
		String bikeTimeFile = readFile("first-2100-rentals.csv");
		String eachline = null;
		String[] strArray = null;
		List<String> strList = null;
		Scanner inputScanner = new Scanner(bikeTimeFile);
		Scanner keyboard = new Scanner(System.in);
		while (inputScanner.hasNext()) {
			eachline = inputScanner.nextLine();
			strArray = eachline.split(",");
			strList = Arrays.asList(strArray);
			String duration = strList.get(0);
			String monthDate = strList.get(1);
			String startTerminal = strList.get(3);
			Integer durationMin = 0;
			String monthWord = null;
			RideTime rTime = new RideTime(duration, monthDate, startTerminal, durationMin, monthWord);
			rideTimes.add(rTime);
		}

		findMonth(rideTimes);
		Collections.sort(rideTimes, new SortMonthDurationTerm());
		for (RideTime r : rideTimes) {
			System.out.println(r.toString());
		}
		longestMonthDuration(rideTimes);
	}

	public static void main(String[] args) {
		BikeShare bs = new BikeShare();
		bs.run();
	}

}
