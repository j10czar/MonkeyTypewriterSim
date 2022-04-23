
public class Monkey extends Thread{
	
	private String myTarget;
	private String myName;
	private int Strokes;
	private boolean isFinished;
	private long startTime;
	private double secondsTime;
	

	Monkey(String target)
	{
		int rand = (int)(Math.random()*13);
		myTarget = target;
		myName = names[rand];
		startTime = System.nanoTime();
	}
	
	
	String[] letters = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
	String[] names = {"Harold","Jerry","Bart","Kyle","Oliver","Noah","James","Ben","Gary","Logan","C. George","Ivan","Chris"};

	public void run()
	{
		this.typeLetters();
	}
	

	public boolean typeLetters()
	{
		Boolean a = true;
		String[] wordCheck = new String[myTarget.length()];
		for(int i = 0; i<myTarget.length();i++)
		{
			int rand = (int)(Math.random()*26);
			wordCheck[i] = letters[rand];
			System.out.println(myName+": "+letters[rand]);
			Strokes++;
			
		}
		
		for(int i = 0; i<wordCheck.length; i++)
		{
			if(!(wordCheck[i].equals(myTarget.substring(i,i+1))))
			{
				a = false;
			
			}
		}
		
		if(a)
		{
			long endTime = System.nanoTime();
			long timeElapsed = endTime - startTime;
			int timeMS = (int) (timeElapsed / 1000000);
			secondsTime = (double)timeMS/1000;
			System.out.println(myName+"'s execution time in milliseconds: " + timeMS);
			System.out.println(myName+"'s execution time in seconds: " + (double)timeMS/1000);
			System.out.println(myName+" found "+myTarget+" in "+Strokes+" strokes!");
			isFinished = true;	
		}
		return a;	
	}
	
	
	public boolean isFinished()
	{
		return isFinished;
	}
	
	public double getTime()
	{
		return secondsTime;
	}
	
	public int getStrokes()
	{
		return Strokes;
	}
	
	public String monkeyName()
	{
		return myName;
	}

}
