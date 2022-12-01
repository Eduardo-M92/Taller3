
package Domain;


public class AlienRobot extends Robot
{
    private String alienClass;
    private int velocity;
    
    
    
    public AlienRobot(String name, String gun, String legs, String arms, String chest, String head, String type, int velocity, String alienClass)
    {
		super(name, gun, legs, arms, chest, head, type, 0, 0, 0);
		this.alienClass = alienClass;
		this.velocity = velocity;
	}
    
    
	public String getAlienClass() {
		return alienClass;
	}


	public void setAlienClass(String alienClass) {
		this.alienClass = alienClass;
	}


	public String getInfo()
    {
        return ("Nombre: "+name+" .Velocidad: "+velocity+" .Vida: "+health+" .Daño: "+attack);
    }


	public int getVelocity() {
		return velocity;
	}


	public void setVelocity(int velocity) {
		this.velocity = velocity;
	}
	
}
