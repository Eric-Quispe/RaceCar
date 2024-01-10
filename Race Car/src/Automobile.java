import java.util.*;
public class Automobile 
{
	private String make;// brand of care
	private String model;// specific type
	private int year; 
	private String color;
	private int topSpeed;
	
	
	public Automobile(String make, String model, int year, String color, int topSpeed)
	{
		
		setMake(make);
		setModel(model);
		setYear(year);
		setColor(color);
		setTopSpeed(topSpeed);
		System.out.println(toString());
		
	}

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
	
	public static boolean letterCheck(String test) // this test is different used to check if letter are entered
	{
		boolean letter= false;
		
		for (int i = 0; i < test.length(); i++) {
			char ch1 = test.charAt(i);
			if (!Character.isAlphabetic(ch1)) {
				letter = false;
				System.out.println("\nPlease do not enter numbers");
				break;
			}

			else if (Character.isAlphabetic(ch1)) {
				letter = true;
			}
		} // for loop end
		return letter;
	}
	
	public String getMake() {
		return make;
	}

	public void setMake(String make)
	{
		
		boolean go=false;
		String[] carBrands = {"Toyota", "Dodge", "Porsche"}; // no array initializer syntax new String[3] needed if you place the string in yourself
	
		while(go==false) 
		{
			
		System.out.println("\nPlease enter the make of your car from the provided selection: \n");
		for (int i=0;i<carBrands.length;i++) 
		{
			System.out.println(carBrands[i]);
		}
		System.out.print("\nYour selection: ");
	    Scanner userInput = new Scanner(System.in);
	    make=userInput.next();
	    go = letterCheck(make);
	   
		
	    if (go==true) 
	    {
	    	for (int i=0;i<carBrands.length;i++) 
	    	{
	    		if(make.equalsIgnoreCase(carBrands[i]))
	    		{
	    			System.out.println("\nGood choice, lets pick the model based on the make you selected: \n");
	    			this.make = make;
	    			go=true;
	    			break;	
	    		}
	    		
	    		
	    	}// end of for loop
	    	 
	 		
	    	
	    }// end of starting IF statement
	  
	    if(this.make==null)
		   {System.out.println("\nYou did not pick from the selection provided, please try again.");
		  go=false;
		   }
	    
		}//end of while loop
		
		
		
		
		
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) 
	{
		
		boolean go=false;
		
	
		String [] toyotaModels= {"Supra","Camry","Corolla"};
		String [] dodgeModels= {"Challenger","HellCat","Viper"};
		String [] porscheModels= {"Speedster","Spyder","Carrera"};
		
		
		    switch (make.toLowerCase()) // if i write this make it would confuse it with this make which is null 
		    {
		    
		        case "toyota":
		        	while(go==false) 
		        	{
		            for (int i = 0; i < toyotaModels.length; i++) 
		            {
		                System.out.println(toyotaModels[i]);	            
		            }
		            System.out.print("\nYour selection: ");
		            Scanner userInput = new Scanner(System.in);
	                model=userInput.next();	
	                go=letterCheck(model);
	                if (go=true) 
	                {
	                	for (int i=0;i<toyotaModels.length;i++)
	                	{
	                		if(model.equalsIgnoreCase(toyotaModels[i])) 
	                		{
	                		System.out.println("\nGood choice.\n");
	    	    			this.model = model;
	                		}	
	                	}//end of for loop
	                	if(this.model==null) 
    	    			{
    	    			System.out.println("\nYou did not pick from the selection provided, please try again.");
    	    			System.out.println(" ");

    	    			go=false;
    	    			}
	                }// end of first IF statement after boolean was true.
		        	}//end of while loop
		            break;
		            
		        case "dodge":
		        	
		        	while(go==false) 
		        	{
		            for (int i = 0; i < dodgeModels.length; i++) 
		            {
		                System.out.println(dodgeModels[i]);	            
		            }
		            System.out.print("\nYour selection: ");

		            Scanner userInput = new Scanner(System.in);
	                model=userInput.next();	
	                go=letterCheck(model);
	                if (go=true) 
	                {
	                	for (int i=0;i<dodgeModels.length;i++)
	                	{
	                		if(model.equalsIgnoreCase(dodgeModels[i])) 
	                		{
	                		System.out.println("\nGood choice.\n");
	    	    			this.model = model;
	                		}
	    	    			
	                	}// end of for loop
	                	if(this.model==null) 
    	    			{
    	    			System.out.println("\nYou did not pick from the selection provided, please try again.");
    	    			System.out.println(" ");
    	    			go=false;
    	    			}
	                	
	                }// end of first IF statement after boolean was true.
		        	}//end of while loop
		            break;
		            
		        case "porsche":
		        	while(go==false) 
		        	{
		            for (int i = 0; i < porscheModels.length; i++) 
		            {
		                System.out.println(porscheModels[i]);	            
		            }
		            
		            System.out.print("\nYour selection: ");
		            Scanner userInput = new Scanner(System.in);
	                model=userInput.next();	
	                go=letterCheck(model);
	                if (go=true) 
	                {
	                	for (int i=0;i<porscheModels.length;i++)
	                	{
	                		if(model.equalsIgnoreCase(porscheModels[i])) 
	                		{
	                		System.out.println("\nGood choice.\n");
	    	    			this.model = model;
	                		}
	    	    			
	                	}// end of for loop
	                	if(this.model==null) 
    	    			{
    	    			System.out.println("\nYou did not pick from the selection provided, please try again.");
    	    			System.out.println(" ");
    	    			go=false;
    	    			}
	                }// end of first IF statement after boolean was true.
		        	}//end of while loop
		            break;
		            
		            default:
		            System.out.println("Invalid make entered.");
		            break;
		    }

	}

	public int getYear() {
		return year;
	}

	public void setYear(int year)  // this method seems to be full proof to work at the moment
	{
		String test;
		boolean go=false;
		
		
		while(go==false) 
		{
			
	    System.out.println("\nPlease enter a year for you car. The selection must be from 1990 till 2023");		
	    Scanner userInput = new Scanner(System.in);
	    test=userInput.next();
	    go = numCheck(test);
		
	    if (go==true) 
	    {
	    	year=Integer.parseInt(test);
	    	
	    		if(year>=1992 && year<=1999)
	    		{
	    			System.out.println("Since your car was made before 2000 this car will not be eligible for a performance chip upgrade. ");
	    			this.year=year;
	    		}
	    			
	    		
	    		else if (year>=2000 && year<=2023) 
	    		{
	    			System.out.println("The car is eligible for a performance chip upgrade. ");
	    			this.year=year;
	    		}
	    		
	    		else 
	    		{
	    		  System.out.println("\nYou did not select a year within range of cars we provide, please try again.");
	    		  go=false;
	    		}
	    	
	    }// end of starting IF statement
	    
		}//end of while loop
		
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color)
	{
		boolean go=false;
		String []  colors= {"red","orange","green","blue","black","silver","white","yellow"};
		
		while(go==false) 
		{
			
		System.out.println("\nPlease enter the color from the provided selection for your car: \n");
		for (int i=0;i<colors.length;i++) 
		{
			System.out.println(colors[i]);
			System.out.println(" ");
		}
		System.out.print("Your selection: ");
	    Scanner userInput = new Scanner(System.in);
	    color=userInput.next();
	    go = letterCheck(color);
		
	    if (go==true) 
	    {
	    	for (int i=0;i<colors.length;i++) 
	    	{
	    		if(color.equalsIgnoreCase(colors[i]))
	    		{
	    			System.out.println("\nGood color choice! \n");
	    			this.color = color;
	    		}
	    		
	    		
	    	}// end of for loop
	    	if(this.color==null) 
    		{
    		  System.out.println("\nYou did not pick from the selection provided, please try again.");
    		  go=false;
    		}
	    	
	    }// end of starting IF statement
	    
		}//end of while loop
		
		
	}

	public int getTopSpeed() {
		return topSpeed;
	}

	public void setTopSpeed(int topSpeed)
	{
		System.out.println("\nThe top speed of your car will be based on the make/model of your car. Depending on the year selected, you can upgrade the performance chip to unlock a new top speed");
		
		
		
		switch(this.make.toLowerCase())
		{
	    case "toyota":
	        switch (model.toLowerCase()) 
	        {
	            case "supra":
	            	topSpeed=155;
	                //System.out.println("\nThe top speed of this car is: "+topSpeed+" mph");
	                this.topSpeed = topSpeed;
	                break;
	            case "camry":
	            	topSpeed=135;
	               // System.out.println("\nThe top speed of this car is: "+topSpeed+" mph");
	                this.topSpeed = topSpeed;
	                break;
	            case "corolla":
	            	topSpeed=121;
	               // System.out.println("\nThe top speed of this car is: "+topSpeed+" mph");
	                this.topSpeed = topSpeed;
	                
	                break;
	            default:
	                System.out.println("I shouldn't see this at all");
	                break;
	        }// end of inner switch
	        break;
	    case "dodge":
	        switch (this.model.toLowerCase()) 
	        {
	            case "challenger":
	            	topSpeed=203;
	               // System.out.println("\nThe top speed of this car is: "+topSpeed+" mph");
	                this.topSpeed = topSpeed;
	                break;
	            case "hellcat":
	            	topSpeed=203;
	                //System.out.println("\nThe top speed of this car is: "+topSpeed+" mph");
	                this.topSpeed = topSpeed;
	                break;
	            case "viper":
	            	topSpeed=206;
	              //  System.out.println("\nThe top speed of this car is: "+topSpeed+" mph");
	                this.topSpeed = topSpeed;
	                break;
	            default:
	            	System.out.println("I shouldn't see this at all");
	                break;
	        }
	        break;
	    case "porsche":
	        switch (this.model.toLowerCase()) 
	        {
	            case "speedster":
	            	topSpeed=192;
	                //System.out.println("\nThe top speed of this car is: "+topSpeed+" mph");
	                this.topSpeed = topSpeed;
	                break;
	            case "spyder":
	            	topSpeed=214;
	                //System.out.println("\nThe top speed of this car is: "+topSpeed+" mph");
	                this.topSpeed = topSpeed;
	                break;
	            case "carrera":
	            	topSpeed=182;
	                //System.out.println("\nThe top speed of this car is: "+topSpeed+" mph");
	                this.topSpeed = topSpeed;
	                break;
	            default:
	            	System.out.println("I shouldn't see this at all");
	                break;
	        }
	        break;
	    default:
	        // code to handle invalid make
	        break;
		}
	

		
	}// end of program 
			
	
	
	public String toString() 
	{
		    System.out.println(" ");
		    String capMake = make.substring(0, 1).toUpperCase() + make.substring(1);
		    String capModel = model.substring(0, 1).toUpperCase() + model.substring(1);
		    String result = "The car you created: " + year + " " + capMake + " " + capModel
		            + "\nIn the color: " + color + "\nTop speed: " + getTopSpeed() + " mph"; // top speed was changed 
		    return result;
		
	}
    
	//String result="The car you created: "+year+" "+make+" "+model+ " \nIn the color: "+color+" \nTop speed: "+ topSpeed+ " mph";
	//return  result;
	;
	
}// end of program
