import java.util.Scanner;
//hello
public class tester{

	private int pos;
	private Monkey[] monkies;
	private boolean finished;
	
	private String target;
	private int numMonkeys;
	private static GUI gui;

	

	
	public tester(String t , int n)
	{
		target = t;
		numMonkeys = n;
		
	}

	public static void main(String[] args)
	{
		gui = new GUI();
		gui.startGUI();
		
		
	}
	
	public void run()
	{
		

		
		String word = target;
		
		int m = numMonkeys;
		
		monkies = new Monkey[m];
		
		for(int i = 0; i < m ; i++ )
		{
			monkies[i]= new Monkey(word);
		}
		
		
		finished = false;
		
		for(int i = 0; i < m ; i++ )
		{
			monkies[i].start();
		}
	
		while(!finished)
		{
			
			for(int i = 0; i < m ; i++ )
			{
				if(!finished)
				{
					monkies[i].typeLetters();
					if(monkies[i].isFinished())
					{
						finished = true;
						pos = i;
						
						
					}
						
				}
				
			}
			
		}
	}
	
	
	
	public double TgetTime()
	{
		return monkies[pos].getTime();
	}
	
	public String TgetName()
	{
		return monkies[pos].monkeyName();
	}
	
	public int TgetStrokes()
	{
		return monkies[pos].getStrokes();
	}
	

	
	public boolean TisFinished()
	{
		return finished;
	}
	

	


}
