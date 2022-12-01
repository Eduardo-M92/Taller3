
package Domain;

public abstract class Robot
{
    String name;
    String gun;
    String legs;
    String arms;
    String chest;
    String head;
    String type;
    int health;
    int attack;
    int velocity;
    
    public Robot()
    {
    	
    }
	public Robot(String name, String gun, String legs, String arms, String chest, String head, String type, int health, int attack, int velocity)
    {
        this.arms = arms;
        this.chest = chest;
        this.gun = gun;
        this.head = head;
        this.legs = legs;
        this.name = name;
        this.type = type;
        this.health=health;
        this.attack=attack;
        this.velocity=velocity;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGun() {
		return gun;
	}

	public void setGun(String gun) {
		this.gun = gun;
	}

	public String getLegs() {
		return legs;
	}

	public void setLegs(String legs) {
		this.legs = legs;
	}

	public String getArms() {
		return arms;
	}

	public void setArms(String arms) {
		this.arms = arms;
	}

	public String getChest() {
		return chest;
	}

	public void setChest(String chest) {
		this.chest = chest;
	}

	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getVelocity() {
		return velocity;
	}

	public void setVelocity(int velocity) {
		this.velocity = velocity;
	}
    
    
}
