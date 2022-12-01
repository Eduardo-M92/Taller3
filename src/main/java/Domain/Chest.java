
package Domain;


public class Chest extends Part
{
    private int health;

	public Chest(String name, String rarity, String type, int health)
	{
		super(name, rarity, type);
		this.health = health;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}
    
    
}
