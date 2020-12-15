package com.techelevator;

public class Airplane 
{
	private String planeNumber;
	private int totalFirstClassSeats;
	private int bookedFirstClassSeats;
	private int availableFirstClassSeats;
	private int	totalCoachSeats;
	private int bookedCoachSeats;
	private int availableCoachSeats;
	
		public String getPlaneNumber ()
		{
			return planeNumber;
		}
		public int getTotalFirstClassSeats ()
		{
			return totalFirstClassSeats;
		}
		public int getAvailableFirstClassSeats ()
		{
			return availableFirstClassSeats = totalFirstClassSeats - bookedFirstClassSeats;
		}
		public int getBookedFirstClassSeats ()
		{
			return bookedFirstClassSeats;
		}
		public int getTotalCoachSeats ()
		{
			return totalCoachSeats;
		}
		public int getBookedCoachSeats ()
		{
			return bookedCoachSeats;
		}
		public int getAvailableCoachSeats ()
		{
			return availableCoachSeats = totalCoachSeats - bookedCoachSeats;
		}
		public Airplane(String planeNumber, int totalFirstClassSeats, int totalCoachSeats)
		{
			this.planeNumber = planeNumber;
			this.totalFirstClassSeats = totalFirstClassSeats;
			this.totalCoachSeats = totalCoachSeats;
		}
		public boolean reserveSeats (boolean forFirstClass, int totalNumberOfSeats) 
		{
			if (forFirstClass)
				
			{
				if (getAvailableFirstClassSeats() >= totalNumberOfSeats)
				{
					this.bookedFirstClassSeats += totalNumberOfSeats;
					
					return true;
				}
				else 
				{
				return false;
				}
			}
			else if (getAvailableCoachSeats() >= totalNumberOfSeats)
			{
				this.bookedCoachSeats += totalNumberOfSeats;
				
				return true;
			}
			return false;
		
		}
		
		
		
}
