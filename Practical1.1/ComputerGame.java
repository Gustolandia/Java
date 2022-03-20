public class ComputerGame
{
	private String title;
	private int year;
	private double price;
	
	public ComputerGame(String t, int y, double p)
	{
		title = t;
		year = y;
		price = p;
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public double getPrice()
	{
		return price;
	}
	
	public int getYear()
	{
		return year;
	}
	
	public String toString()
	{
		return title + " " + year + " " + price;
	}

}