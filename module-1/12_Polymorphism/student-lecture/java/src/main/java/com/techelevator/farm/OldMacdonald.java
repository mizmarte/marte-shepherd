package com.techelevator.farm;

import java.util.ArrayList;
import java.util.List;

public class OldMacdonald
{
	public static void main(String[] args)
	{
		List<Singable> animals = new ArrayList<Singable>();
		animals.add(new Chicken());
		animals.add(new Cow());
		animals.add(new Tractor());

		
		for (Singable thing: farmThings)
		{
			singVerse(thing);
		}

//		// add logic to sing about the farm
//		FarmAnimal pig = new FarmAnimal("Pig", "oink");
//		Chicken chicken = new Chicken();
//		
//		System.out.println(pig.getName() + " says " + pig.getSound());
//		System.out.println(chicken.getName() + " says " + chicken.getSound());
//		chicken.layEgg();
//		//implicit conversion
//		//because a chicken is a farm animal
//		FarmAnimal animal = chicken;
//		System.out.println(animal.getName());
//		//animal doesn't know that layEgg() is available
//		//explicit conversion we need to covert the animal to a chicken
//		//because not every animal IS a chicken
//		Chicken c2 = (chicken)animal;
//		c2.layEgg();
	}	
	public static void singVerse(Singable animal)
	{
		String name = animal.getName();
		String sound = animal.getSound();

		System.out.println("Old MacDonald had a farm, ee, ay, ee, ay, oh!");
		System.out.println("And on his farm he had a " + name + ", ee, ay, ee, ay, oh!");
		System.out.println("With a " + sound + " " + sound + " here");
		System.out.println("And a " + sound + " " + sound + " there");
		System.out.println("Here a " + sound + " there a " + sound + " everywhere a " + sound + " " + sound);
		System.out.println();

	}
	public static void cowDemo()
	{
		
	}
	public static void chickenDemo ()
	{
		
	}
	

}