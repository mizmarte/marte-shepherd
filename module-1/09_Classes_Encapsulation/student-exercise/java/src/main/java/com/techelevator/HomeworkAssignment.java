package com.techelevator;

public class HomeworkAssignment 
{
	private int earnedMarks;
	private int possibleMarks;
	private String submitterName;
	
	
		public int getEarnedMarks()
		{
			return earnedMarks;
		}
		public int getPossibleMarks()
		{	
			return possibleMarks;
		}
		public String getSubmitterName()
		{	
			return submitterName;
		}
		public void setEarnedMarks(int earnedMarks)
		{
			this.earnedMarks = earnedMarks;
		}
		public String getLetterGrade()
		{
			String letterGrade;
			
			double earnedMarksDouble = earnedMarks;
			double possibleMarksDouble = possibleMarks;
			double percentGrade = (earnedMarksDouble/possibleMarksDouble);
			int percentGrade2 = (int)(percentGrade *100);
			
			
			if (percentGrade2 >= 90)
			{
				letterGrade = "A";
			}
			else if (percentGrade2 >= 80)
			{
				letterGrade = "B";
			}
			else if (percentGrade2 >= 70)
			{
				letterGrade = "C";
			}
			else if (percentGrade2 >= 60)
			{
				letterGrade = "D";
			}
			
			else 
				{
				letterGrade = "F";	
				}
			
			return letterGrade;
		}

		public HomeworkAssignment(int finalPossibleMarks, String finalSubmitterName)
		{
			this.submitterName = finalSubmitterName;
			
			this.possibleMarks = finalPossibleMarks;
			
				
			
		}
}
