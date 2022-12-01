
package Domain;


public class Arms extends Part
{
    private int attack;

	public Arms(String name, String rarity, String type, int attack)
	{
		super(name, rarity, type);
		this.attack = attack;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}
    
    
    
}
