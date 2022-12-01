
package Domain;


public class Head extends Part
{
    private int velocity;
    private int health;
    
	public Head(String name, String rarity, String type, int velocity, int health)
	{
		super(name, rarity, type);
		this.velocity = velocity;
		this.health = health;
	}

	public int getVelocity() {
		return velocity;
	}

	public void setVelocity(int velocity) {
		this.velocity = velocity;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}
	
	
}
