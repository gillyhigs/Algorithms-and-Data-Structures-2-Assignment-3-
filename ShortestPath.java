import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShortestPath {

	public static List<List<Node>> myGraph = new ArrayList<List<Node> >(); //Use this Graph when implementing the shortest path algorithm
	public static Dijkstra dijkstra; //Will be using Dijkstra's
	public static ArrayList<Stops> theStops = new ArrayList<Stops>();
	public static ArrayList<StopTimes> theStopTimes = new ArrayList<StopTimes>();
	public static double cost;
	
	int stopId;
	int stopCode;// List of variables required
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
	
	static void readingInTheData(){ //Read in the files and assign them to objects
		File stops = new File("C:\\Users\\shane\\OneDrive\\Documents\\Algorithms and Data Structures 2\\Assignment 3\\stops.txt");
		File transfers = new File("C:\\Users\\shane\\OneDrive\\Documents\\Algorithms and Data Structures 2\\Assignment 3\\transfers.txt");
		File stopTimes = new File("C:\\Users\\shane\\OneDrive\\Documents\\Algorithms and Data Structures 2\\Assignment 3\\stop_times.txt");
		int fromStop = 0;
		int toStop = 0;
		double cost;
		int i = 0;
		int j = 0;
		try {
			Scanner myStops = new Scanner(stops);
			myStops.nextLine();
			while(myStops.hasNextLine())
			{
			     String[] information = myStops.nextLine().split(",");
			     Stops newStop = new Stops();
			     newStop.setStopId(Integer.parseInt(information[0])); // here we use our stop object class and set everything up
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
			
			for (i = 0; i < theStops.size(); i++) {
	            List<Node> item = new ArrayList<Node>();
	            myGraph.add(item);
	        }
			dijkstra = new Dijkstra(theStops.size()); // preparing our shortest path algorithm
			i = 0;
			
			Scanner myStopTimes = new Scanner(stopTimes);
			String stopTripIDOne;
			int stopIDOne;
			int stopIDTwo; 
			String stopTripIDTwo;
			myStopTimes.nextLine();
			String wholeLine = myStopTimes.nextLine();
			String[] informationOne = wholeLine.split(",");
			String arrivalTime = informationOne[1];
			//Reading in the stop times for later use
			theStopTimes.add(new StopTimes(arrivalTime, wholeLine));
			while(myStopTimes.hasNextLine())
			{
				if(myStopTimes.hasNextLine())
				{
					wholeLine = myStopTimes.nextLine();
					String[] informationTwo = wholeLine.split(",");
					arrivalTime = informationTwo[1];
					stopTripIDOne = informationOne[0];
					stopTripIDTwo = informationTwo[0];
					stopIDOne = Integer.parseInt(informationOne[3]);
					stopIDTwo = Integer.parseInt(informationTwo[3]);
					if(stopTripIDOne == stopTripIDTwo)
					{
						addToGraph(stopIDOne, stopIDTwo, 1);
					}
					theStopTimes.add(new StopTimes(arrivalTime, wholeLine));
				}
			}
			
			//reading in the transfers
			Scanner myTransfers = new Scanner(transfers);
			myTransfers.nextLine();
			while(myTransfers.hasNextLine())
			{
				String[] information = myTransfers.nextLine().split(",");
				fromStop = Integer.parseInt(information[0]);
				toStop = Integer.parseInt(information[1]);
				if(Integer.parseInt(information[2]) == 0)
				{
					cost = 2;
				}
				else
				{
					cost = Double.parseDouble(information[3])/100;
				}
				addToGraph(fromStop, toStop, cost);//adding the direct edges to our graph
			}
			myStops.close();
			myTransfers.close();
			myStopTimes.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void addToGraph(int fromStop, int toStop, double cost)
	{
		int i = 0;
		int j = 0;
		int firstStopChecker = 0;
		int secondStopChecker = 0;
		while(i < theStops.size() && theStops.get(i).getStopId() != fromStop)
		{
			i++;
		}
		if(theStops.get(i).getStopId() == fromStop)
		{
			firstStopChecker = 1;//making sure out point is in the graph
		}
		while(j < theStops.size() && theStops.get(j).getStopId() != toStop)
		{
			j++;
		}
		if(theStops.get(j).getStopId() == toStop)
		{
			secondStopChecker = 1;
		}
		if(firstStopChecker != 0 && secondStopChecker != 0)
		{
			myGraph.get(i).add(new Node(j, cost));// adding nodes to our graph
		}
	}
	
	public void printArrivalTimeInfo(String arrivalTime)
	{
		String[] splitUp = arrivalTime.split(":");// for validation of input time
		if(Integer.parseInt(splitUp[0]) <= 23 && Integer.parseInt(splitUp[1]) <= 59 && Integer.parseInt(splitUp[2]) <= 59
				&& Integer.parseInt(splitUp[0]) >= 0 && Integer.parseInt(splitUp[1]) >= 0 && Integer.parseInt(splitUp[2]) >= 0)
		{
			for(int i = 0; i < theStopTimes.size(); i ++)
			{
				if(theStopTimes.get(i).arrivalTime.contains(arrivalTime))
				{
					System.out.println(theStopTimes.get(i).wholeLine);
				}
			}
		}
		else
		{
			System.out.println("ERROR - invalid input time !");
		}
	}
	
	public void applyDijkstra(int source, int to)//applying dijkstra to two bus stops
	{
		dijkstra.dijkstra(myGraph, source);
		double dist = dijkstra.dist[to];
		if(dist < Integer.MAX_VALUE)
		{
			System.out.println(dist);
		}
		else
		{
			System.out.println("ERROR - No route exists");
		}
	}
	
	public static int getStopId(int stopID) {
		for(int i = 0; i < theStops.size(); i++)
		{
			if(theStops.get(i).getStopId() == stopID)
			{
				return i;
			}
		}
		return -1;
		
	}
}
