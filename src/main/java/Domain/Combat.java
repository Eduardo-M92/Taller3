
package Domain;


public class Combat
{
    private String hRobotName1;
    private String hRobotName2;
    private String hRobotName3;
    private String aRobotName1;
    private String aRobotName2;
    private String aRobotName3;
    private String winningTeam;
    
    
    
	public Combat(String hRobotName1, String hRobotName2, String hRobotName3, String aRobotName1, String aRobotName2, String aRobotName3, String winningTeam)
	{
		this.hRobotName1 = hRobotName1;
		this.hRobotName2 = hRobotName2;
		this.hRobotName3 = hRobotName3;
		this.aRobotName1 = aRobotName1;
		this.aRobotName2 = aRobotName2;
		this.aRobotName3 = aRobotName3;
		this.winningTeam = winningTeam;
	}
	public String gethRobotName1() {
		return hRobotName1;
	}
	public void sethRobotName1(String hRobotName1) {
		this.hRobotName1 = hRobotName1;
	}
	public String gethRobotName2() {
		return hRobotName2;
	}
	public void sethRobotName2(String hRobotName2) {
		this.hRobotName2 = hRobotName2;
	}
	public String gethRobotName3() {
		return hRobotName3;
	}
	public void sethRobotName3(String hRobotName3) {
		this.hRobotName3 = hRobotName3;
	}
	public String getaRobotName1() {
		return aRobotName1;
	}
	public void setaRobotName1(String aRobotName1) {
		this.aRobotName1 = aRobotName1;
	}
	public String getaRobotName2() {
		return aRobotName2;
	}
	public void setaRobotName2(String aRobotName2) {
		this.aRobotName2 = aRobotName2;
	}
	public String getaRobotName3() {
		return aRobotName3;
	}
	public void setaRobotName3(String aRobotName3) {
		this.aRobotName3 = aRobotName3;
	}
	public String getWinningTeam() {
		return winningTeam;
	}
	public void setWinningTeam(String winningTeam) {
		this.winningTeam = winningTeam;
	}
    
    
}
