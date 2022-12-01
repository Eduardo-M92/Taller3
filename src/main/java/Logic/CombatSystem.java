package Logic;

import java.io.IOException;
import java.util.LinkedList;

import Domain.AlienRobot;
import Domain.Combat;
import Domain.Gun;
import Domain.HumanRobot;
import Domain.Part;
import Domain.Robot;

public interface CombatSystem
{
    
    public boolean addHumanRobot(String name, String gun, String legs, String arms, String chest, String head, String type, String pilotName, String team);
    public boolean addAlienRobot(String name, String gun, String legs, String arms, String chest, String head, String type, int velocity, String calss);
    public boolean addCombat(String hRobotName1, String hRobotName2, String hRobotName3, String aRobotName1, String aRobotName2, String aRobotName3, String winningTeam);
    public boolean addLegs(String type, String name, String rarity, int velocity);
    public boolean addArms(String type, String name, String rarity, int attack);
    public boolean addChest(String type, String name, String rarity, int health);
    public boolean addhead(String type, String name, String rarity, int velocity,int health);
    public boolean addGun(String name, int damage, int velocity);
    public String startSimulation(String hRobot1, String hRobot2, String hRobot3, String aRobot1, String aRobot2, String aRobot3);
    public Robot searchRobot(String name);
    public String getRobotStatisctics();
    public String getAlienStatisctics();
    public String getVictoriesHumanity();
    public LinkedList<HumanRobot> getHumanRobotList();
    public LinkedList<AlienRobot> getAlienRobotList();
    public LinkedList<Part> getPartList();
    public LinkedList<Gun> getGunList();
    public LinkedList<Combat> getCombatList();
    public LinkedList<String> getTeamsList();
    public LinkedList<String> getPilotsList();
    public void exitSystem() throws IOException;
}
