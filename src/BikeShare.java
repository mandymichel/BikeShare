
/*I need something that will go through a list of objects sorted by month and duration
Find a duration where the next line's duration is different. Those are the largest value for the months.
First duration in the file and the duration that is preceded by a different duration are the smallest values for the months.
It works again. Wrestle with hashmaps tomorrow!
*/
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class BikeShare {
	private static final String SHORT_LIST = "first-2100-rentals.csv";
	private static final String FULL_LIST = "all-rentals-2013.csv";
	List<RideTime> rideTimes = new ArrayList<RideTime>();
	List<String> durationList = new ArrayList<String>();
	String eachline = null;
	String[] strArray = null;

	public static void writeToFile(String name, String classlist) {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new FileWriter(new File(classlist)));
			pw.println(name);
		} catch (IOException io) {
			throw new RuntimeException(io);
		} finally {
			pw.close();
		}
	}

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

	public void writeSortedListToFile(List<RideTime> rideTimes) {
		StringBuilder sb = new StringBuilder();
		for (RideTime r : rideTimes) {
			System.out.println(r);
			sb.append(r);
			sb.append("\n");
		}
		String sortedList = sb.toString();
		writeToFile(sortedList, "BikeShareData.txt");

	}

	public void run() {
		String bikeTimeFile = readFile(FULL_LIST);
		List<String> strList = null;

		Scanner inputScanner = new Scanner(bikeTimeFile);
		String monthDuration = null;
		while (inputScanner.hasNext()) {
			eachline = inputScanner.nextLine();
			strArray = eachline.split(",");
			strList = Arrays.asList(strArray);
			String duration = strList.get(0);
			String monthDate = strList.get(1);
			String startTerminal = strList.get(3);
			RideTime rTime = new RideTime(duration, monthDate, startTerminal);
			rTime.initialize();
			rideTimes.add(rTime);
		}

		Collections.sort(rideTimes, new SortMonthDurationTerm());
		writeSortedListToFile(rideTimes);
		// Trying to find greatest and least minutes for each month below

		String sortedBikeTimeFile = (readFile("BikeShareData.txt"));
		inputScanner = new Scanner(sortedBikeTimeFile);
		Map<String, List<String>> month = new HashMap<>();
		while (inputScanner.hasNext()) {
			eachline = inputScanner.nextLine();
			strArray = eachline.split("\t");
			List<String> list = month.get(strArray[0]);
			if (list == null) {
				month.put(strArray[0], list = new ArrayList<String>());
			}
			list.add(strArray[1]);
		}
		int i = 1;
		for (Map.Entry<String, List<String>> monthEntry : month.entrySet()) {
			List<String> value = monthEntry.getValue();
			int lastEntry = value.size() - 1;
			String monthFile = (monthEntry.getKey() + "\t" + value);
			System.out.println("Maximum minutes for month " + i + ": " + value.get(lastEntry));
			System.out.println("Minimum minutes for month " + i + ": " + value.get(0));
			writeToFile(monthFile, "monthFile" + i + ".txt");
			i++;
		}

		// longestMonthDuration(rideTimes);
	}

	public static void main(String[] args) {
		BikeShare bs = new BikeShare();
		bs.run();
	}

}
