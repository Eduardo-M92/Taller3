
package Domain;


public class Legs extends Part
{
    private int velocity;

	public Legs(String name, String rarity, String type, int velocity)
	{
		super(name, rarity, type);
		this.velocity = velocity;
	}

	public int getVelocity() {
		return velocity;
	}

	public void setVelocity(int velocity) {
		this.velocity = velocity;
	}
	
	
}
