
package Domain;


public class Gun
{
    private String name;
    private int damage;
    private int velocity;
    
    
    
	public Gun(String name, int damage, int velocity)
	{
		this.name = name;
		this.damage = damage;
		this.velocity = velocity;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDamage() {
		return damage;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}
	public int getVelocity() {
		return velocity;
	}
	public void setVelocity(int velocity) {
		this.velocity = velocity;
	}
    
    
}
