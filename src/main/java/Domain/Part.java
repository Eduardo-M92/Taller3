
package Domain;


public abstract class Part
{
    String name;
    String rarity;
    String type;
    int defaultHealth = 2000;
    
    public Part(String name, String rarity, String type)
    {
       this.name = name;
       this.rarity = rarity;
       this.type = type;
    }
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRarity() {
		return rarity;
	}

	public void setRarity(String rarity) {
		this.rarity = rarity;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getDefaultHealth() {
		return defaultHealth;
	}

	public void setDefaultHealth(int defaultHealth) {
		this.defaultHealth = defaultHealth;
	}
    
    
}
