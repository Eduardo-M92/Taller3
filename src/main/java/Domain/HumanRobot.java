
package Domain;


public class HumanRobot extends Robot
{
    private String pilotName;
    private String team;
    
    
    public HumanRobot(String name, String gun, String legs, String arms, String chest, String head, String type, String pilotName, String team)
    {
		super(name, gun, legs, arms, chest, head, type, 0, 0, 0);
		this.pilotName = pilotName;
		this.team = team;
	}
    
    
	public String getPilotName() {
		return pilotName;
	}


	public void setPilotName(String pilotName) {
		this.pilotName = pilotName;
	}


	public String getTeam() {
		return team;
	}


	public void setTeam(String team) {
		this.team = team;
	}


	public String getInfo()
    {
        return ("Nombre: "+name+" .Velocidad: "+velocity+" .Vida: "+health+" .Daño: "+attack);
    }
}
