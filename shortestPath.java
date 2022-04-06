import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ShortestPath {

	public static ArrayList<Stops> theStops = new ArrayList<Stops>();
	static Stops newStop = new Stops();
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
		File tranfers = new File("C:\\Users\\shane\\OneDrive\\Documents\\Algorithms and Data Structures 2\\Assignment 3\\transfers.txt");
		File stopTimes = new File("C:\\Users\\shane\\OneDrive\\Documents\\Algorithms and Data Structures 2\\Assignment 3\\stop_times.txt");
		int stopCount = 0;
		int regularCount = 0;
		try {
			Scanner myReader = new Scanner(stops);
			while(myReader .hasNext())
			{
				switch(regularCount)
				{
				case 0:
					theStops.add(newStop);
					theStops.get(stopCount).setStopId(Integer.parseInt(myReader.next()));
					break;
					
				case 1:
					break;
					
				case 2:
					break;
					
				case 3:
					break;
					
				case 4:
					break;
					
				case 5:
					break;
					
				case 6:
					break;
					
				case 7:
					break;
					
				case 8:
					break;
					
				case 9:
					
					theStops.add();
					break;
				}
			 }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
