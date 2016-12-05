package pokemon.model;

public class Pokemon
{
	private int healthPoints;
	private int attackPoints;
	private double speed;
	private int number;
	private String name;
	
	public void setName(String name)
	{
		this.name = name;
	}

	public Pokemon(String name, int number)
	{
		this.name = name;
		this.number = number;
	}

	public int getHealthPoints()
	{
		return healthPoints;
	}

	public void setHealthPoints(int healthPoints)
	{
		this.healthPoints = healthPoints;
	}

	public int getAttackPoints()
	{
		return attackPoints;
	}

	public void setAttackPoints(int attackPoints)
	{
		this.attackPoints = attackPoints;
	}

	public double getSpeed()
	{
		return speed;
	}

	public void setSpeed(double speed)
	{
		this.speed = speed;
	}

	public int getNumber()
	{
		return number;
	}

	public String getName()
	{
		return name;
	}
	}
