package com.techelevator;

public class Television 
{

	private boolean isOn = false;
	private int currentChannel = 3;
	private int currentVolume =2;
	
	
	public boolean IsOn()
	{	
		return this.isOn;
		
	}
	public int getCurrentChannel()
	{
		currentChannel = 3;
		
		return currentChannel;
	}
	public int getCurrentVolume()
	{
		currentVolume = 2;
		
		return currentVolume;
	}
	public void turnOff()
    {
        this.isOn = false;
    }
	public void turnOn()
	   {
	    this.isOn = true;
	   }
	public void changeChannel(int newChannel)
    {
        if (isOn && newChannel >= 3 && newChannel <= 18)
        {
            this.currentChannel = newChannel;
        }	
    }
	 public void channelUp() 
	    {
	    	if(isOn)
	    	{
	    		if(currentChannel <18)
	    			
	    		{
	    			
	    		this.currentChannel = this.currentChannel + 1;
	    		
	    		}
	    	
	        	this.currentChannel = 3;
	    	}	

	    }
	 public void channelDown()
	 {
		 if(isOn && currentChannel > 3)
	 
		{
			 
			 this.currentChannel = this.currentChannel - 1;
	 		
	 	}
 	
     	this.currentChannel = 18;
	 }
	 public void raiseVolume()
	    {
	    	if(isOn && currentVolume <=10)
	    		
	    	{
	    		currentVolume++;
	    	}
	    	
	    }
	 public void lowerVolume()
	    {
	    	if (isOn && currentVolume > 0)
	    	{
	    		currentVolume--;
	    	}
	    		
	    }
} 
	 