/*
 * Name: Eric Huaman Quispe
 * Date: April 1, 2023
 * purpose: learning to method override and method stack
 */
import java.util.ArrayList;
import java.util.Scanner;

public class TestClass {

	public static void main(String[] args) 
	{
		menu();        
	}
   
	public static void menu()
	{
			String test;
			int number;
			boolean go=true;
			
			
			
			ArrayList <RaceCar> garage= new ArrayList<>();
	
			while(go==true)
			{
				System.out.println("\n\nPlease select one of the following choices below: ");
				System.out.println("\nPress 1 to create a Race car");
				System.out.println("\nPress 2 to see the garage ");
				System.out.println("\nPress 3 to compare cars");
				System.out.println("\nPress 4 to end the program");
				System.out.println("\nEnter your selection: ");
				Scanner userInput = new Scanner(System.in);
				test=userInput.next();
				go=numCheck(test);
				if (go==true)
				{
					number=Integer.parseInt(test);
					if (number==1)
					{
						raceCar(garage);
						go=true;
					}
					else if(number==2) 
				    {
						display(garage);
					}
					
					else if(number==3) 
					{
					   compare(garage);
					}
					else if(number==4) 
					{
						System.out.println("\n\nGoodbye");
						go=false;
					}
					
					else if (number<1 || number>4)
					{
						System.out.println("\nThe number you entered was not a valid opition.");
						go=true;
					}
					
				
			   }
				
				else
				{
					go=true;
				}		
		}// end of while loop
			  System.exit(0);
		}// end of menu method
	
	public static boolean numCheck(String test) // test  users input is a valid number

	{
	boolean num=false;

	try
	{
		int number=Integer.parseInt(test);
		num=true;
	}
	catch (NumberFormatException error) 
	{
		System.out.println("\nYou did not enter a valid number");
	}
	return num;
	}
	
	public static void raceCar(ArrayList <RaceCar> garage) 
	{
		String make=""; 
		String model="";
		int year=0;
		String color="";
		int topSpeed=0;
		String upgrade="";
		String upgrade2="";
		RaceCar car = new RaceCar(make,model,year,color,topSpeed,upgrade,upgrade2);
		garage.add(car);
	}
	
	public static void display(ArrayList <RaceCar> garage) 
	{
		if(garage.size()==0) 
		{
			System.out.println("\nNo current cars in the garage.");
		}
		else
        {
			System.out.println("\nCurrent cars in the garage so far: ");
			for(int i=0; i<garage.size();i++) 
			{
				System.out.println("\n"+garage.get(i).toString());
			}
		}
	}
	
	public static void compare(ArrayList <RaceCar> garage) 
	{
		String result="";
		if( garage.size()>1) 
		{
		System.out.println("\nLet compare cars:");
		for(int i=0; i<garage.size();i++) 
		{
			for(int k=i+1; k<garage.size();k++) 
			{
				result= garage.get(i).equals(garage.get(k))?garage.get(i)+ "\n\n"+ garage.get(k)+ "\n\nAre the same make/model/year":garage.get(i)+ "\n\n"+ garage.get(k)+ "\n\nAre not these are not the same make/model/year";
			}
		}//end of outer for loop
		System.out.println(result);
		}// end of if
		else System.out.println("\nNot enough cars to compare");
	}
	
	}// end program 

