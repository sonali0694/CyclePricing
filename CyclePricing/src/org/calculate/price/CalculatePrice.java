package org.calculate.price;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class CalculatePrice {

	public int calculate() throws IOException, ParseException, java.text.ParseException {
//	public static void main(String args[]) {

		JSONParser parser = new JSONParser();
		String line = null;
		JSONObject obj;
		ArrayList<JSONObject> json = new ArrayList<JSONObject>();

		FileReader fileReader = new FileReader("resource/course.json");
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		while ((line = bufferedReader.readLine()) != null) {
			int cyclePrice = 0;
			int wheelPrice = 0;
			int framePrice = 0;
			int barPrice = 0;
			int seatPrice = 0;
			int chainPrice = 0;
			obj = (JSONObject) new JSONParser().parse(line);

			String dateOfPricing = (String) obj.get("dateOfPricing");
			System.out.println("Date Of Pricing: " + dateOfPricing);
			Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(dateOfPricing);
			int year = date1.getYear() + 1900;
			if (year < 2016) {
				return 0;
			}
			int diffOfYear = Math.abs(year - 2016);
			Map<String, Integer> subParts = new HashMap<String, Integer>();
			subParts.put("spokes", 400);
			subParts.put("rim", 200);
			subParts.put("tube", 100);
			subParts.put("frameset", 500);
			subParts.put("headset", 500);
			subParts.put("FLATBARS", 500);
			subParts.put("BULLHORNS", 500);
			subParts.put("seat1", 1000);
			subParts.put("seat2", 1500);
			subParts.put("chain1", 500);
			subParts.put("chain2", 800);
			if (diffOfYear > 0) {
				for (Map.Entry<String, Integer> entry : subParts.entrySet()) {
					subParts.put(entry.getKey(), entry.getValue() + (30 * diffOfYear));
				}
			}
			JSONArray listOfWheels = (JSONArray) obj.get("wheels");
			String part = null;
			// Calculate Price of wheel Subparts
			if (listOfWheels != null) {
				Iterator<String> iteratorSubParts = listOfWheels.iterator();
				while (iteratorSubParts.hasNext()) {
					part = iteratorSubParts.next();
					if (subParts.containsKey(part)) {
						wheelPrice += subParts.get(part);

					}
				}
				System.out.println("Price of Wheel Component is: " + wheelPrice);
			}
			// Calculate Price of frame Subparts
			JSONArray listOfFrame = (JSONArray) obj.get("frame");
			if (listOfFrame != null) {
				Iterator<String> iterator2 = listOfFrame.iterator();
				while (iterator2.hasNext()) {
					part = iterator2.next();
					if (subParts.containsKey(part)) {
						framePrice += subParts.get(part);

					}
				}
				System.out.println("Price of Frame Component is: " + framePrice);
			}
			// Calculate Price of HandleBars Subparts
			JSONArray listOfHandleBars = (JSONArray) obj.get("handleBars");
			if (listOfHandleBars != null) {
				Iterator<String> iterator3 = listOfHandleBars.iterator();
				while (iterator3.hasNext()) {
					part = iterator3.next();
					if (subParts.containsKey(part)) {
						barPrice += subParts.get(part);

					}
				}
				System.out.println("Price of Bar Component is: " + barPrice);
			}

			// Calculate Price of seating Subparts

			JSONArray listOfSeating = (JSONArray) obj.get("seating");
			if (listOfSeating != null) {
				Iterator<String> iterator4 = listOfSeating.iterator();

				while (iterator4.hasNext()) {
					part = iterator4.next();
					if (subParts.containsKey(part)) {

						seatPrice += subParts.get(part);

					}
				}
				System.out.println("Price of Seat Component is: " + seatPrice);
			}
			// Calculate Price of chain Subparts
			JSONArray listOfChain = (JSONArray) obj.get("chain");
			if (listOfChain != null) {
				Iterator<String> iterator5 = listOfChain.iterator();

				while (iterator5.hasNext()) {
					part = iterator5.next();
					if (subParts.containsKey(part)) {

						chainPrice += subParts.get(part);

					}
				}
				System.out.println("Price of Chain Component is: " + chainPrice);
			}
			cyclePrice = wheelPrice + framePrice + barPrice + seatPrice + chainPrice;
			System.out.println("Price Of Cycle is: " + cyclePrice);
		}

		return 1;

	}

}
