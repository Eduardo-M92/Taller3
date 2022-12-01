package Logic;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import Domain.MainMenu;
/*
 * @Eduardo Marchandon
 * 20.404.799-5
 */
public class App
{
	public static void main(String[] args) throws FileNotFoundException
    {
    	CombatSystem pSystem = new CombatSystemImpl();
    	MainMenu menu = new MainMenu(pSystem);
        readPiezas(pSystem);
        readArmas(pSystem);
    	readRobots(pSystem);
    	menu.setVisible(true);
    	
    	
    	
    }
    
    public static void readRobots(CombatSystem pSystem) throws FileNotFoundException
    {
    	Scanner arch = new Scanner(new File("Robots.txt"));
    	while(arch.hasNext())
    	{
    		String[] parts = arch.nextLine().split(",");
    		if(deleteSpace(parts[6]).toLowerCase().equals("h"))
    		{
    			String name = deleteSpace(parts[0]);
    			String legs = deleteSpace(parts[2]);
    			String arms = deleteSpace(parts[3]);
    			String chest = deleteSpace(parts[4]);
    			String head = deleteSpace(parts[5]);
    			String type = deleteSpace(parts[6]);
    			String pilotName = deleteSpace(parts[7]);
    			String team = deleteSpace(parts[8]);
    			String gun = deleteSpace(parts[1]);
    			pSystem.addHumanRobot(name, gun, legs, arms, chest, head, type, pilotName, team);
    		}
    		else
    		{
    			String name = deleteSpace(parts[0]);
    			String legs = deleteSpace(parts[2]);
    			String arms = deleteSpace(parts[3]);
    			String chest = deleteSpace(parts[4]);
    			String head = deleteSpace(parts[5]);
    			String type = deleteSpace(parts[6]);
    			int velocity = Integer.parseInt(deleteSpace(parts[7]));
    			String alienClass = deleteSpace(parts[8]);
    			String gun = deleteSpace(parts[1]);
    			pSystem.addAlienRobot(name, gun, legs, arms, chest, head, type, velocity, alienClass);
    		}
    		
    	}
    }
    
    public static void readArmas(CombatSystem pSystem) throws FileNotFoundException
    {
        Scanner arch = new Scanner(new File("Armas.txt"));
    	while(arch.hasNext())
    	{
            String[] parts = arch.nextLine().split(",");
            String name = deleteSpace(parts[0]);
            int damage = Integer.parseInt(deleteSpace(parts[1]));
            int velocity = Integer.parseInt(deleteSpace(parts[2]));
            pSystem.addGun(name, damage, velocity);
        }
    }
    
    public static void readPiezas(CombatSystem pSystem) throws FileNotFoundException
    {
    	Scanner arch = new Scanner(new File("Piezas.txt"));
    	while(arch.hasNext())
    	{
    		String name="";
    		String type="";
    		String rarity="";
    		int velocity;
    		int attack;
    		int health;
    		String[] parts = arch.nextLine().split(",");
    		switch(deleteSpace(parts[2]))
    		{
    		case "C":
    			name = deleteSpace(parts[0]);
    			rarity = deleteSpace(parts[1]);
    			type = deleteSpace(parts[2]);
    			velocity = Integer.parseInt(deleteSpace(parts[3]));
    			health = Integer.parseInt(deleteSpace(parts[4]));
    			pSystem.addhead(type, name, rarity, velocity, health);
    			break;
    		case "B":
    			name = deleteSpace(parts[0]);
    			rarity = deleteSpace(parts[1]);
    			type = deleteSpace(parts[2]);
    			attack = Integer.parseInt(deleteSpace(parts[3]));
    			pSystem.addArms(type, name, rarity, attack);
    			break;
    		case "P":
    			name = deleteSpace(parts[0]);
    			rarity = deleteSpace(parts[1]);
    			type = deleteSpace(parts[2]);
    			velocity = Integer.parseInt(deleteSpace(parts[3]));
    			pSystem.addLegs(type, name, rarity, velocity);
    			break;
    		case "T":
    			name = deleteSpace(parts[0]);
    			rarity = deleteSpace(parts[1]);
    			type = deleteSpace(parts[2]);
    			health = Integer.parseInt(deleteSpace(parts[3]));
    			pSystem.addChest(type, name, rarity, health);
    			break;
    		}
    	}
    }
    
    public static String deleteSpace(String word)
    {
    	String[] parts = word.split("");
    	String exit = "";
    	if(parts[0].equals(" "))
    	{
    		for(int a=1;a<parts.length;a++)
    		{
    			exit+=parts[a];
    		}
    		return exit;
    	}
    	else
    	{
    		return word;
    	}
    }
}
