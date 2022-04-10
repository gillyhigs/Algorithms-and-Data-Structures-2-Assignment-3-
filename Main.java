import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		ShortestPath shortPath = new ShortestPath();
		shortPath.readingInTheData();
		boolean quit = false;
		while(!quit)
		{
			System.out.printf("Hello, please input a number from 1-3 for the following services\n"
					+ "(1) Allows you to input two bus stops and find the shortest path between them and all passing stops\n"
					+ "(2) Allows you to search for a bus stop by full name or by the first few characters in the name\n"
					+ "(3) Allows you to search for all bus trips with a given arrival time in the format hh:mm:ss\n"
					+ "Or enter quit to exit the program ");
			if(input.hasNext("quit"))
			{
				quit = true;
			}
			else if(input.hasNext("1"))
			{
				input.next();
				System.out.println("Please enter your first stop number");
				int[] theStops = new int[2];
				theStops[0] = input.nextInt();
				System.out.println("Please enter your second stop number");
				theStops[1] = input.nextInt();
				int stopIdOne = shortPath.getStopId(theStops[0]);
				int stopIdTwo = shortPath.getStopId(theStops[1]);
				if( stopIdOne == -1 || stopIdTwo == -1)
				{
					System.out.println("Error - invalid stop input!");
				}
				else
				{
					shortPath.applyDijkstra(stopIdOne, stopIdTwo);
				}
			}
			else if(input.hasNext("2"))
			{
				
			}
			else if(input.hasNext("3"))
			{
				
			}
			else
			{
				System.out.println("ERROR - Invalid input");
			}
		}

	}

}
