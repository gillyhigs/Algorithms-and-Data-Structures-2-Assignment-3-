import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShortestPath {

	public static ArrayList<Stops> theStops = new ArrayList<Stops>();
	int stopId;
	int stopCode;
	String stopName;
	String stopDesc;
	double stopLat;
	double stopLon;
	String zoneID;
	String stopURL;
	int location_type;
	String parent_station;
	
	ShortestPath(){
		
	}
	
	static void readingInTheData(){
		File stops = new File("C:\\Users\\shane\\OneDrive\\Documents\\Algorithms and Data Structures 2\\Assignment 3\\stops.txt");
		File transfers = new File("C:\\Users\\shane\\OneDrive\\Documents\\Algorithms and Data Structures 2\\Assignment 3\\transfers.txt");
		File stopTimes = new File("C:\\Users\\shane\\OneDrive\\Documents\\Algorithms and Data Structures 2\\Assignment 3\\stop_times.txt");
		int regularCount = 0;
		int stopCheckerOne = 0;
		int stopCheckerTwo = 0;
		int i = 0;
		int j = 0;
		try {
			Scanner myStops = new Scanner(stops);
			myStops.nextLine();
			while(myStops.hasNextLine())
			{
			     String[] information = myStops.nextLine().split(",");
			     Stops newStop = new Stops();
			     newStop.setStopId(Integer.parseInt(information[0]));
			     newStop.setStopCode(information[1]);
			     newStop.setStopName(information[2]);
			     newStop.setStopDesc(information[3]);
			     newStop.setStopLat(Double.parseDouble(information[4]));
			     newStop.setStopLon(Double.parseDouble(information[5]));
			     newStop.setZoneId(information[6]);
			     newStop.setStopURL(information[7]);
			     newStop.setLocationType(Integer.parseInt(information[8]));
			     newStop.setParentStation(information[8]);
			     theStops.add(newStop);
			 }
			Scanner myTransfers = new Scanner(transfers);
			myTransfers.nextLine();
			while(myTransfers.hasNextLine())
			{
				String[] information = myStops.nextLine().split(",");
				while(i < theStops.size() && Integer.parseInt(information[0]) != theStops.get(i).getStopId())
				{
					i++;
				}
				if(Integer.parseInt(information[0]) == theStops.get(i).getStopId())
				{
					stopCheckerOne = 1;
				}
				while(j < theStops.size() && Integer.parseInt(information[1]) != theStops.get(j).getStopId())
				{
					j++;
				}
				if(Integer.parseInt(information[1]) == theStops.get(j).getStopId())
				{
					stopCheckerTwo = 1;
				}
				if(stopCheckerOne == 1 && stopCheckerTwo == 1)
				{
					
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
