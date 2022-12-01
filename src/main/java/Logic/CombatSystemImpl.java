package Logic;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.LinkedList;

import Domain.AlienRobot;
import Domain.Arms;
import Domain.Chest;
import Domain.Combat;
import Domain.Gun;
import Domain.Head;
import Domain.HumanRobot;
import Domain.Legs;
import Domain.Part;
import Domain.Robot;

public class CombatSystemImpl implements CombatSystem
{
	LinkedList<Part> parts;
	LinkedList<Gun> guns;
	LinkedList<HumanRobot> humanRobots;
	LinkedList<AlienRobot> alienRobots;
	LinkedList<Combat> combats;
    LinkedList<String> pilots;
    LinkedList<String> teams;
        
	
	public CombatSystemImpl()
	{
		this.parts = new LinkedList<>();
		this.guns = new LinkedList<>();
		this.humanRobots = new LinkedList<>();
		this.alienRobots = new LinkedList<>();
		this.combats = new LinkedList<>();
		this.teams = new LinkedList<>();
		this.pilots = new LinkedList<>();
	}
	
    public boolean addHumanRobot(String name, String gun, String legs, String arms, String chest, String head, String type, String pilotName, String team)
    {
        String pilot= null;
        String tim = null;
        if(team.toLowerCase().equals("null"))
        {
            team = tim;
        }else
        {
            if(!teams.contains(team))
            {
                teams.add(team);
            }
        }
        if(pilotName.toLowerCase().equals("null"))
        {
            pilotName = pilot;
        }else
        {
            if(!pilots.contains(pilotName))
            {
                pilots.add(pilotName);
            }
        }
        HumanRobot r = new HumanRobot(name, gun, legs, arms, chest, head, type, pilotName, team);
        humanRobots.add(r);
    	return true;
    }


    public boolean addAlienRobot(String name, String gun, String legs, String arms, String chest, String head, String type, int aVelocity, String calss)
    {
        int health = 0;
        int attack = 3500;
        int velocity = aVelocity;
    	AlienRobot r = new AlienRobot(name, gun, legs, arms, chest, head, type, velocity, calss);
        switch(calss)
        {
            case "SS+":
                health += 5000;
                attack += 500;
                break;
            case "S+":
                health += 3000;
                attack += 400;
                break;
            case "S":
                health += 2000;
                attack += 300;
                break;
            case "A":
                health += 1000;
                attack += 200;
                break;
            case "B":
                health += 500;
                attack += 100;
                break;
        }
        health += 2000*4;
        r.setAttack(attack);
        r.setVelocity(velocity);
        r.setHealth(health);
    	alienRobots.add(r);
    	return true;
    }

    public Robot searchRobot(String name)
    {
    	Iterator<HumanRobot> itRobot = humanRobots.iterator();
    	while(itRobot.hasNext())
    	{
    		HumanRobot hRobot = (HumanRobot) itRobot.next();
    		if(hRobot.getName().toLowerCase().equals(name.toLowerCase()))
    		{
    			return hRobot;
    		}
    	}
    	Iterator<AlienRobot> it = alienRobots.iterator();
    	while(it.hasNext())
    	{
    		AlienRobot aRobot = (AlienRobot) it.next();
    		if(aRobot.getName().toLowerCase().equals(name.toLowerCase()))
    		{
    			return aRobot;
    		}
    	}
    	return null;
    }
    
    public boolean addLegs(String type, String name, String rarity, int velocity)
    {
    	Legs p = new Legs(name, rarity, type, velocity);
    	parts.add(p);
    	return true;
    }


    public boolean addArms(String type, String name, String rarity, int attack)
    {
    	Arms p = new Arms(name, rarity, type, attack);
    	parts.add(p);
    	return true;
    }

    public boolean addChest(String type, String name, String rarity, int health)
    {
    	Chest p = new Chest(name, rarity, type, health);
    	parts.add(p);
    	return true;
    }

    public boolean addhead(String type, String name, String rarity, int velocity, int health) 
    {
    	Head p = new Head(name, rarity, type, velocity, health);
    	parts.add(p);
    	return true;
    }

    
    public boolean addGun(String name, int damage, int velocity)
    {
    	Gun g = new Gun(name, damage, velocity);
    	guns.add(g);
    	return true;
    }

    public String startSimulation(String hRobot1, String hRobot2, String hRobot3, String aRobot1, String aRobot2, String aRobot3)
    {
    	HumanRobot h1=(HumanRobot) searchRobot(hRobot1);
    	HumanRobot h2=(HumanRobot) searchRobot(hRobot2);
    	HumanRobot h3=(HumanRobot) searchRobot(hRobot3);
    	AlienRobot a1=(AlienRobot) searchRobot(aRobot1);
    	AlienRobot a2=(AlienRobot) searchRobot(aRobot2);
    	AlienRobot a3=(AlienRobot) searchRobot(aRobot3);
    	
    	String exit ="";
    	
    	HumanRobot h11 = new HumanRobot(h1.getName(),h1.getGun(),h1.getLegs(),h1.getArms(),h1.getChest(),h1.getHead(),h1.getType(),h1.getPilotName(),h1.getTeam());
    	h11.setVelocity(h1.getVelocity()); h11.setAttack(h1.getAttack()); h11.setHealth(h1.getHealth());
    	HumanRobot h22 = new HumanRobot(h2.getName(),h2.getGun(),h2.getLegs(),h2.getArms(),h2.getChest(),h2.getHead(),h2.getType(),h2.getPilotName(),h2.getTeam());
    	h22.setVelocity(h2.getVelocity()); h22.setAttack(h2.getAttack()); h22.setHealth(h2.getHealth());
    	HumanRobot h33 = new HumanRobot(h3.getName(),h3.getGun(),h3.getLegs(),h3.getArms(),h3.getChest(),h3.getHead(),h3.getType(),h3.getPilotName(),h3.getTeam());
    	h33.setVelocity(h3.getVelocity()); h33.setAttack(h3.getAttack()); h33.setHealth(h3.getHealth());
    	AlienRobot a11 = new AlienRobot(a1.getName(),a1.getGun(),a1.getLegs(),a1.getArms(),a1.getChest(),a1.getHead(),a1.getType(),a1.getVelocity(),a1.getAlienClass());
    	a11.setVelocity(a1.getVelocity()); a11.setAttack(a1.getAttack()); a11.setHealth(a1.getHealth());
    	AlienRobot a22 = new AlienRobot(a2.getName(),a2.getGun(),a2.getLegs(),a2.getArms(),a2.getChest(),a2.getHead(),a2.getType(),a2.getVelocity(),a2.getAlienClass());
    	a22.setVelocity(a2.getVelocity()); a22.setAttack(a2.getAttack()); a22.setHealth(a2.getHealth());
    	AlienRobot a33= new AlienRobot(a3.getName(),a3.getGun(),a3.getLegs(),a3.getArms(),a3.getChest(),a3.getHead(),a3.getType(),a3.getVelocity(),a3.getAlienClass());
    	a33.setVelocity(h3.getVelocity()); a33.setAttack(a3.getAttack()); a33.setHealth(a3.getHealth());
    	
    	if(a11.getAttack()>h11.getAttack())
    	{
    		while(a11.getHealth()>0&&h11.getHealth()>0)
    		{
    			h11.setHealth(h11.getHealth()-a11.getAttack());
    			if(h11.getHealth()>0)
    			{
    				a11.setHealth(a11.getHealth()-h11.getAttack());
    			}
    		}
    	}else
    	{
    		while(a11.getHealth()>0&&h11.getHealth()>0)
    		{
    			a11.setHealth(a11.getHealth()-h11.getAttack());
    			if(h11.getHealth()>0)
    			{
    				h11.setHealth(h11.getHealth()-a11.getAttack());
    			}
    		}
    	}
    	if(a22.getAttack()>h22.getAttack())
    	{
    		while(a22.getHealth()>0&&h22.getHealth()>0)
    		{
    			h22.setHealth(h22.getHealth()-a22.getAttack());
    			if(h22.getHealth()>0)
    			{
    				a22.setHealth(a22.getHealth()-h22.getAttack());
    			}
    		}
    	}else
    	{
    		while(a22.getHealth()>0&&h22.getHealth()>0)
    		{
    			a22.setHealth(a22.getHealth()-h22.getAttack());
    			if(h22.getHealth()>0)
    			{
    				h22.setHealth(h22.getHealth()-a22.getAttack());
    			}
    		}
    	}
    	if(a33.getAttack()>h33.getAttack())
    	{
    		while(a33.getHealth()>0&&h33.getHealth()>0)
    		{
    			h33.setHealth(h33.getHealth()-a33.getAttack());
    			if(h33.getHealth()>0)
    			{
    				a33.setHealth(a33.getHealth()-h33.getAttack());
    			}
    		}
    	}else
    	{
    		while(a33.getHealth()>0&&h33.getHealth()>0)
    		{
    			a33.setHealth(a33.getHealth()-h33.getAttack());
    			if(h33.getHealth()>0)
    			{
    				h33.setHealth(h33.getHealth()-a33.getAttack());
    			}
    		}
    	}
    	int humanWin=0;
    	int alienWin=0;
    	Combat combat;
    	if(h11.getHealth()>0)
    	{
    		exit+= "W "+h11.getName()+"-L "+a11.getName();
    		humanWin++;
    	}
    	else
    	{
    		exit+= "L "+h11.getName()+"-W "+a11.getName();
    		alienWin++;
    	}
    	if(h22.getHealth()>0)
    	{
    		exit+= ";W "+h22.getName()+"-L "+a22.getName();
    		humanWin++;
    	}
    	else
    	{
    		exit+= ";L "+h22.getName()+"-W "+a22.getName();
    		alienWin++;
    	}
    	if(h33.getHealth()>0)
    	{
    		exit+= ";W "+h33.getName()+"-L "+a33.getName();
    		humanWin++;
    	}
    	else
    	{
    		exit+= ";L "+h33.getName()+"-W "+a33.getName();
    		alienWin++;
    	}
    	if(humanWin>alienWin)
    	{
    		combat = new Combat(h11.getName(), h22.getName(), h33.getName(), a11.getName(), a22.getName(), a33.getName(),"H");
    		exit+=";(Humanos Win)";
    	}
    	else
    	{
    		combat = new Combat(h11.getName(), h22.getName(), h33.getName(), a11.getName(), a22.getName(), a33.getName(),"A");
    		exit+=";(Aliens Win)";
    	}
		
		combats.add(combat);
    	return exit;
    }
    
    public String getRobotStatisctics()
    {
        Iterator<HumanRobot> it1 = humanRobots.iterator();
        String exit = "";
        int a =0;
        
        while(it1.hasNext())
        {
            HumanRobot r = (HumanRobot) it1.next();
            Iterator<Part> it3 = parts.iterator();
            int health = 0;
            int attack = 0;
            int velocity = 0;
            Iterator<Gun> it2 = guns.iterator();
            while(it2.hasNext())
            {
                Gun hGun = (Gun) it2.next();
                if(hGun.getName().toLowerCase().equals(r.getGun().toLowerCase()))
                {
                    attack += hGun.getDamage();
                    velocity += hGun.getVelocity();
                }

            }
            while(it3.hasNext())
            {
                Part part = (Part) it3.next();
                if(part.getName().toLowerCase().equals(r.getArms().toLowerCase())||part.getName().toLowerCase().equals(r.getLegs().toLowerCase())||part.getName().toLowerCase().equals(r.getHead().toLowerCase())||part.getName().toLowerCase().equals(r.getChest().toLowerCase()))
                {
                    if(part.getRarity().toLowerCase().equals("pp"))
                    {
                        health += 3000;
                        attack += 200;
                    }else if(part.getRarity().toLowerCase().equals("pe"))
                    {
                        health += 2000;
                        attack += 100;
                    }else
                    {
                        health += 1000;
                    }
                    switch(part.getType())
                    {
                        case "C":
                            Head rHead = (Head) part;
                            health += (rHead.getDefaultHealth()+rHead.getHealth());
                            velocity += rHead.getVelocity();
                            break;
                        case "T":
                            health += part.getDefaultHealth();
                            Chest hChest = (Chest) part;
                            health += (hChest.getDefaultHealth()+hChest.getHealth());
                            break;
                        case "B":
                            health += part.getDefaultHealth();
                            Arms hArms = (Arms) part;
                            attack += hArms.getAttack();
                            break;
                        case "P":
                            health += part.getDefaultHealth();
                            Legs hLegs = (Legs) part;
                            velocity += hLegs.getVelocity();
                            break;
                    }
                }
            }
            r.setAttack(attack);
            r.setHealth(health);
            r.setVelocity(velocity);
            if(a>0)
            {
                exit +=",";
            }
            exit += r.getInfo();
            a++;
        }
        
        return exit;
    }
    public String getAlienStatisctics()
    {
        Iterator<AlienRobot> it1 = alienRobots.iterator();
        String exit = "";
        int a =0;
        while(it1.hasNext())
        {
            if(a>0)
            {
                exit +=",";
            }
            AlienRobot robot = (AlienRobot) it1.next();
            exit += "Nombre: "+robot.getName()+" .Velocidad: "+robot.getVelocity()+" .Vida: "+robot.getHealth()+" .Daño: "+robot.getAttack();
            a++;
        }
        
        return exit;
    }

    public String getVictoriesHumanity() {
    	String exit = "";
    	for(Combat combat : combats)
    	{
    		if(combat.getWinningTeam().equals("H"))
    		{
    			exit+="Robots Humanos: "+combat.gethRobotName1()+", "+combat.gethRobotName2()+", "+combat.gethRobotName3()+" -VS- ";
    			exit+="Robots Alienigenas: "+combat.getaRobotName1()+", "+combat.getaRobotName2()+", "+combat.getaRobotName3();
    			exit+=";";
    		}
    	}
       return exit;
    }

    
    public LinkedList<HumanRobot> getHumanRobotList() {
        return this.humanRobots;
    }

    
    public LinkedList<AlienRobot> getAlienRobotList() {
        return this.alienRobots;
    }

    
    public LinkedList<Part> getPartList() {
        return this.parts;
    }

    
    public LinkedList<Gun> getGunList() {
        return guns;
    }

    public LinkedList<Combat> getCombatList() {
        return combats;
    }

	
	public boolean addCombat(String hRobotName1, String hRobotName2, String hRobotName3, String aRobotName1, String aRobotName2, String aRobotName3, String winningTeam)
	{
		Combat combat = new Combat(hRobotName1, hRobotName2, hRobotName3, aRobotName1, aRobotName2, aRobotName3, winningTeam);
		combats.add(combat);
		return true;
	}

    
    public LinkedList<String> getTeamsList() {
        return teams;
    }

    public LinkedList<String> getPilotsList() {
        return pilots;
    }
    public void exitSystem() throws IOException
    {
        FileWriter robots = new FileWriter("Robots.txt");
        PrintWriter pw1 = new PrintWriter(robots);
        for(HumanRobot robot : humanRobots)
        {
        	pw1.println(robot.getName()+", "+robot.getGun()+", "+robot.getLegs()+", "+robot.getArms()+", "+robot.getChest()+", "+robot.getHead()+", H,"+robot.getPilotName()+", "+robot.getTeam());
        }
        for(AlienRobot robot : alienRobots)
        {
        	pw1.println(robot.getName()+", "+robot.getGun()+", "+robot.getLegs()+", "+robot.getArms()+", "+robot.getChest()+", "+robot.getHead()+", A,"+robot.getVelocity()+", "+robot.getAlienClass());
        }
        
        FileWriter piezas = new FileWriter("Piezas.txt");
        PrintWriter pw2 = new PrintWriter(piezas);
        for(Part part : parts)
        {
        	switch(part.getType())
        	{
        	case("C"):
        		Head head = (Head) part;
        		pw2.println(head.getName()+", "+head.getRarity()+", C, "+head.getVelocity()+", "+head.getHealth());
        		break;
        	case("B"):
        		Arms arms = (Arms) part;
    			pw2.println(arms.getName()+", "+arms.getRarity()+", B, "+arms.getAttack());
        		break;
        	case("T"):
        		Chest chest = (Chest) part;
    			pw2.println(chest.getName()+", "+chest.getRarity()+", T, "+chest.getHealth());
        		break;
        	case("P"):
        		Legs legs = (Legs) part;
    			pw2.println(legs.getName()+", "+legs.getRarity()+", P, "+legs.getVelocity());
        		break;
        	}
        }
        FileWriter guns = new FileWriter("Armas.txt");
        PrintWriter pw3 = new PrintWriter(guns);
        for(Gun gun : this.guns)
        {
        	pw3.println(gun.getName()+", "+gun.getDamage()+", "+gun.getVelocity());
        }
        String ruta = new File (".").getAbsolutePath() + "\\Combates.txt";
        File combates = new File(ruta);
        PrintWriter pw4 = new PrintWriter(combates);
        if (!combates.exists())
        {
        	combates.createNewFile();
        }
        for(Combat combate : this.combats)
        {
        	pw4.println(combate.gethRobotName1()+", "+combate.gethRobotName2()+", "+combate.gethRobotName3()+", "+combate.getaRobotName1()+", "+combate.getaRobotName2()+", "+combate.getaRobotName3()+", H");
        }
        pw1.close();
        pw2.close();
        pw3.close();
        pw4.close();
    }
}
