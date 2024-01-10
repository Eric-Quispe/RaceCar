import java.util.*;
public class RaceCar extends Automobile
{
 private String upgrade;
 private String upgrade2;
 private ArrayList<String> upgradeList = new ArrayList<>(Arrays.asList("Carbon Fiber Hood", "Sport Tires", "Nitrous System", "Performance ChipSet"));

 
public RaceCar(String make, String model, int year, String color, int topSpeed, String upgrade, String upgrade2) 
{
	super(make, model, year, color, topSpeed);// super needs to be first 
	menu();
	System.out.println(toString());
    
	
}

public boolean equals(Object obj)// created a new equal method to compare objects
{
	RaceCar a = (RaceCar) obj;
	if (!a.getMake().equals(this.getMake())) return false; // compares  Make
	if (!a.getModel().equals(this.getModel()))return false;// compares model
	if (a.getYear()!=this.getYear())return false; // compares year
 
	return true;
}

public void menu() 
{
	//String [] upgradeList= {"Carbon Fiber Hood","Sport tires","Nitrous System","Performance ChipSet"}; 
	//ArrayList<String> upgradeList = new ArrayList<>(Arrays.asList("Carbon Fiber Hood", "Sport Tires", "Nitrous System", "Performance ChipSet"));

	String test;
	int number;
	boolean go=true;
    while(go==true)
    {
	System.out.println("\nHow many parts do you want to upgrade? ");
	System.out.println("Press 1 to upgrade one part");
	System.out.println("Press 2 to upgrade two parts");
	System.out.print("\nYour selection: ");
	Scanner userInput = new Scanner(System.in);
	test=userInput.next();
	go=numCheck(test);
	if (go==true) 
	{
		number=Integer.parseInt(test);
		if (number==1)
		{
			 setUpgrade(upgrade,upgradeList);
			 setTopSpeed(getTopSpeed());
			 go=false;
		}
		
		else if (number==2)
		{
			setUpgrade(upgrade,upgrade2,upgradeList);
		
			setTopSpeed(getTopSpeed());
			
			go=false;
		}
		
		
		else if (number<1 || number>2)
		{
			System.out.println("\nThe number you entered was not a valid opition.");
			go=true;
		}
	}// end of first IF statement
	
	else go=true;
	
	}// end of while loop
}// end of menu program


public static boolean letterCheck(String test) // this test is different used to check if letter are entered
{
	boolean letter= false;
	
	for (int i = 0; i < test.length(); i++) 
	{
		char ch1 = test.charAt(i);
		
		if (test.contains(" "))// new line
		{
			if (ch1 !=' '  && !Character.isAlphabetic(ch1))  // we are making sure the  character is not a space and its not a string to make it invalid here
			{
				letter = false;
				System.out.println("\nInvalid name entered");
				break;
			}
			
			else if (Character.isAlphabetic(ch1) )
			{
				letter=true;
			}
			
		}
		
		else if (!Character.isAlphabetic(ch1)) 
		{
			letter = false;
			System.out.println("\nInvalid name entered");
			break;
		}

		else if (Character.isAlphabetic(ch1)) {
			letter = true;
		}
	} // for loop end
	return letter;
}



public String getUpgrade() // rewrite this for any case of the setUpgrade methods
{
	if(this.upgrade!=null && this.upgrade2==null) 
	{
		return this.upgrade;
	}
	else
		return upgrade+", "+upgrade2;
}

//setUpgrade is my method overloading: same names but different parameters 
public void setUpgrade(String upgrade,ArrayList<String> upgradeList) // this works now 
{
	
	
	boolean go=false;
	
	System.out.println("\nNice you decided to pick one upgrade.");
	while( go==false) 
	{
	if( super.getYear()<2000) 
	{
		System.out.println("\nSince your car is before the year 2000 you can't upgrade the performance chip.");
		System.out.println("\nYou can still select upgrades from the following: ");
		System.out.println(" ");
		for (int i=0;i<upgradeList.size()-1;i++) // minus one since performance part is the last item and i dont want to include this
    	{
			System.out.println(upgradeList.get(i));
    	}
		System.out.print("\nYour selection: ");
	    Scanner userInput = new Scanner(System.in);
	    upgrade=userInput.nextLine();                              // CHANGED userinput.next() to .nextline()  
	    go = letterCheck(upgrade);//go?
	    
	    if(go==true) 
	    {
	    	for (int i=0;i<upgradeList.size()-1;i++) 
	    	{
	    		if (upgradeList.get(i).toLowerCase().contains(upgrade.toLowerCase()))
	    		{
	    		   
	    		    this.upgrade = upgradeList.get(i);
	    		    go = true;
	    		  
	    		}
	         }// end of for loop
	    	if(this.upgrade==null) 
    		{
    		System.out.println("You did not select an item from the inventory provided");	
    		go=false;
    		}// end of inner else
	    }
	}// end of first if statement (most outer)
	else 
	{
		System.out.println("\nSince your car is made after the year 1999 you can upgrade the performance chip.");
		System.out.println("\nSelect one of the following following: ");
		System.out.println(" ");
		for (int i=0;i<upgradeList.size();i++) // minus one since performance part is the last item and i don't want to include this
    	{
			System.out.println(upgradeList.get(i));
    	}
		System.out.print("\nYour selection: ");
	    Scanner userInput = new Scanner(System.in);
	    upgrade=userInput.nextLine();   //nextLine()
	    go = letterCheck(upgrade);
	    
	    if(go==true) 
	    {
	    	for (int i=0;i<upgradeList.size();i++) 
	    	{
	    		if (upgradeList.get(i).toLowerCase().contains(upgrade.toLowerCase()))
	    		{
	    			 
	    			this.upgrade = upgrade;
	    			go=true;
	    			
	    		}
	    		
	          }// end of for loop
	    	if(this.upgrade==null) 
    		{
    		System.out.println("You did not select an item from the inventory provided");	
    		go=false;
    		}// end of inner else
	    }
	}// end of outer else statement, this case if the car is over the year 1999
		
	}// end of while loops
}


//setUpgrade is my method overloading: same names but different parameters 
public void setUpgrade(String upgrade, String upgrade2,ArrayList<String> upgradeList) // FIX not actually getting into this.upgrade=upgrade
{
	
	
boolean go=false;
int remove=-1;
	
System.out.println("\nNice you decided to pick two upgrades.");

	while( go==false) 
	{
	
	if( super.getYear()<2000) 
	{
		System.out.println("\nSince your car is before the year 2000 you can't upgrade the performance chip.");
		System.out.println("\nYou can still select upgrades from the following: ");
		System.out.println(" ");
		for (int i=0;i<upgradeList.size()-1;i++) // minus one since performance part is the last item and i dont want to include this
    	{
			System.out.println(upgradeList.get(i));
    	}
		System.out.print("\nYour selection: ");
	    Scanner userInput = new Scanner(System.in);
	    upgrade=userInput.nextLine(); // change.next()
	    go = letterCheck(upgrade);
	    
	    if(go==true) 
	    {
	    	for (int i=0;i<upgradeList.size()-1;i++) 
	    	{
	    		if (upgradeList.get(i).toLowerCase().contains(upgrade.toLowerCase()))
	    	
	    		{
	    			remove=i; // this will "remove" the selected item from the list
	    			this.upgrade = upgrade;
	    			
	    			go=true;
	    		}//end of if 
	    	}// end of for loop
	    			if (this.upgrade!=null)
	    			{
	    				System.out.println("\nLet's pick another upgrade");
	    				System.out.println(" ");
	    				for (int j=0;j<upgradeList.size()-1;j++)
	    				{
	    					if (j!=remove)
	    					{
	    					System.out.println(upgradeList.get(j));
	    					}
	    				}// end of a for loop
	    				System.out.print("\nYour selection: ");
	    			    Scanner userInput2 = new Scanner(System.in);
	    			    upgrade2=userInput2.nextLine(); // changed .next to nextLine()
	    			    go = letterCheck(upgrade2);
	    			    for (int k=0;k<upgradeList.size()-1;k++)
	    			    {
	    			    	if (upgradeList.get(k).toLowerCase().contains(upgrade2.toLowerCase() )&& !upgradeList.get(remove).toLowerCase().contains(upgrade2.toLowerCase() ))
	    			    	
	    			    	{
	    			    		this.upgrade2 = upgrade2;
	    			    		go=true;                 
	    			    	}
	    			    } // end of a for loop 
	    			    if (this.upgrade2==null) 
	    		    	{
	    		    		System.out.println("\nYou did not select an item from the inventory provided or you selected the same upgrade twice.\nPlease pick your upgrades again without picking the same upgrades twice.");
	    		    		go=false;
	    		    	}
	    		    	
	    			}// of if statement for IF upgrade !null
	    			else {
	    				System.out.println("You did not select an item from the inventory provided");
	    				go=false;
	    			}
	     } // of an if statement
	    		
	}// end of IF statement (most outer) for the year  
	
	else 
	{
		System.out.println("\nSince your car is made after the year 1999 you can upgrade the performance chip.");
		System.out.println("\nSelect one of the following following: ");
		System.out.println(" ");
		for (int i=0;i<upgradeList.size();i++) // minus one since performance part is the last item and i dont want to include this
    	{
			System.out.println(upgradeList.get(i));
    	}
		System.out.print("\nYour selection: ");
	    Scanner userInput = new Scanner(System.in);
	    upgrade=userInput.nextLine();// change next to nextLine
	    go = letterCheck(upgrade);
	    
	    if(go==true) 
	    {
	    	for (int i=0;i<upgradeList.size();i++) 
	    	{
	    		if (upgradeList.get(i).toLowerCase().contains(upgrade.toLowerCase()))
	    	
	    		{
	    			remove=i; // this will "remove" the selected item from the list
	    			this.upgrade = upgrade;
	    			
	    			go=true;
	    		}//end of if 
	    	}// end of for loop
	    			if (this.upgrade!=null)
	    			{
	    				System.out.println("\nLet's pick another upgrade");
	    				for (int j=0;j<upgradeList.size();j++)
	    				{
	    					if (j!=remove)
	    					{
	    					System.out.println(upgradeList.get(j));
	    					}
	    				}// end of a for loop
	    				System.out.print("\nYour selection: ");
	    			    Scanner userInput2 = new Scanner(System.in);
	    			    upgrade2=userInput2.nextLine();
	    			    go = letterCheck(upgrade2);
	    			    for (int k=0;k<upgradeList.size();k++)
	    			    {
	    			    	if (upgradeList.get(k).toLowerCase().contains(upgrade2.toLowerCase() )&& !upgradeList.get(remove).toLowerCase().contains(upgrade2.toLowerCase() ))
	    			    	{
	    			    		
	    			    		this.upgrade2 = upgrade2;
	    			    		go=true;                 
	    			    	}
	    			    } // end of a for loop   
	    			    
	    			    if (this.upgrade2==null) 
	    		    	{
	    		    		System.out.println("\nYou did not select an item from the inventory provided or you selected the same upgrade twice.\nPlease pick your upgrades again without picking the same upgrades twice.");
	    		    		go=false;
	    		    	}
	    			    
	    			}// of if statement for IF upgrade !null
	    			else {
	    				System.out.println("You did not select an item from the inventory provided");
	    				go=false;
	    			}
	     } // of an if statement
	    else {
			System.out.println("You did not select an item from the inventory provided");
			go=false;
		}
	}// end of outer else statement, this case if the car is over the year 1999
	}//end of while loop

}// end of program

/*
 *  This method will be over written to unlock the new top speed if the user selected the performance chip
 *  it works to see if the upgrades in the child class have been filled in with a part, otherwise it will run parent setTopSpeed, or run this method, in order to get a new max top speed if performance chipset was picked
 */
@Override
public int getTopSpeed() 
{
    if(this.upgrade!=null && upgrade2==null)
    {
        //if (upgrade.toLowerCase().equalsIgnoreCase("performance chipset"))
    	if ("performance chipset".equalsIgnoreCase(upgrade))
        {
            return super.getTopSpeed() + 30;
        }
        else 
        {
        	return super.getTopSpeed();
        }
    }
     if(this.upgrade2!=null)
    {
       // if (upgrade.toLowerCase().equalsIgnoreCase("performance")|| (upgrade2.toLowerCase().equalsIgnoreCase("performance chipset")))
    	if  ("performance chipset".equalsIgnoreCase(upgrade))
        {
            return super.getTopSpeed() + 30;
        }
    	else if ("performance chipset".equalsIgnoreCase(upgrade2))
    	{
    		 return super.getTopSpeed() + 30;
    	}
        else 
        {
        	return super.getTopSpeed();
        }
    }
    else return super.getTopSpeed();
}


	


@Override // will use the super to string or the super to string with upgrades
public String toString()
{
	String result="";
	if(this.upgrade!=null && upgrade2==null)
	{
		result= super.toString()+ "\nUpgrades: "+ getUpgrade();
		return result;
	}
	if(this.upgrade!=null && upgrade2!=null)
	{
		result= super.toString()+ "\nUpgrades: "+ getUpgrade();
		return result;
	}

	else return super.toString();
			
}
	

}//end of program
