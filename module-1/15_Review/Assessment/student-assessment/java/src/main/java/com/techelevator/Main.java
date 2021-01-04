package com.techelevator;



public class Main {

	public static void main(String[] args) 
	{
//		
//		MovieRental testM = new MovieRental("Godfather", "DVD",false);
//		System.out.println(testM.getTitle());
//		System.out.println(testM.getFormat());
//		System.out.println(testM.isPremium());
//		System.out.println(testM.rentalPrice(testM.getFormat(), testM.isPremium()));
//		System.out.println(testM.lateFee(0, 1.99));
//		System.out.println(testM.toString());
//		
//		MovieRental testM2 = new MovieRental("Fast and Furious", "Blu-Ray",true);
//		System.out.println(testM2.getTitle());
//		System.out.println(testM2.getFormat());
//		System.out.println(testM2.isPremium());
//		System.out.println(testM2.rentalPrice(testM2.getFormat(), testM2.isPremium()));
//		System.out.println(testM2.toString());
//		
//		MovieRental testM3 = new MovieRental("Fast and Furious", "DVD",true);
//		System.out.println(testM3.getTitle());
//		System.out.println(testM3.getFormat());
//		System.out.println(testM3.isPremium());
//		System.out.println(testM3.rentalPrice(testM3.getFormat(), testM3.isPremium()));
//		System.out.println(testM3.toString());
		
//		FlowerShopOrder test = new FlowerShopOrder("basic", 10);
//		System.out.println(test.getNumberOfRoses());
//		System.out.println(test.subtotal());
//		System.out.println(test.deliveryTotal(true, 30000));
//		System.out.println(test.grandTotal());
//		System.out.println(test.toString());
//		
//		Car test = new Car(1965, "Ford Mustang", true);
//		System.out.println(test.getYear());
//		System.out.println(test.getMake());
//		System.out.println(test.isClassicCar());
//		System.out.println(test.age() + " years");
//		System.out.println(test.isECheckRequired(2021));
		
//		Car test2 = new Car(2015, "Mazda CX9", false);
//		System.out.println(test2.getYear());
//		System.out.println(test2.getMake());
//		System.out.println(test2.isClassicCar());
//		System.out.println(test2.age() + " years");
//		System.out.println(test2.isECheckRequired(2021));
	
//		Car test3 = new Car(2015, "Audi A5", false);
//		System.out.println(test3.getYear());
//		System.out.println(test3.getMake());
//		System.out.println(test3.isClassicCar());
//		System.out.println(test3.age() + " years");
//		System.out.println(test3.isECheckRequired(2021));
//		System.out.println(test3.toString());
		
		TellerMachine cashMoney = new TellerMachine("Ray-Ray",1200.00,575.01);
		System.out.println(cashMoney.getManufacturer());
		System.out.println(cashMoney.getDeposits());
		System.out.println(cashMoney.getWithdrawals());
		System.out.println(cashMoney.balance());
		System.out.println(cashMoney.isThisCardValid("399999999876"));
		System.out.println(cashMoney.toString());
	
	}
			
		

	

	
}
