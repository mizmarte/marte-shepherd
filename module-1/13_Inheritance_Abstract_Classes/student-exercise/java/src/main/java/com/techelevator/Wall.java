package com.techelevator;

public abstract class Wall 
{
	private String name;
	private String color;

	
	protected String shapeChoice;
	protected String shapeSize;
	
	public Wall(String name, String color)
	{
		this.name = name;
		this.color = color;
	}
	public String getName()
	{
		return name;
	}
	public String getColor()
	{
		return color;
	}
	public abstract int getArea(); 
	
	@Override
	public String toString()
	{
		return name + " (" + shapeSize + ") " + shapeChoice;
	}
}
