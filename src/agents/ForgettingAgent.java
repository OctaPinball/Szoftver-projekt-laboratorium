package agents;

import miscellaneous.Control;
import miscellaneous.Logger;

/**
 * Az Agent osztály leszármazottja, használata az eleszenvedõjén felejtést okoz, azaz elfelejti az összes eddig megtanult ágens genetikai kódját.
 */
public class ForgettingAgent extends Agent{

	/**
	 * Aktiválja az ágens hatását a virológuson, amely során a virológus elfelejti az összes addig megtanult ágenst.
	 */
	public void activate() {
		Logger.enter(this, "activate", null);
		
		owner.forgetAllAgent();
		this.deactivate();
		
		Logger.exit(this, "activate", null);
	}
	
	/**
	 * Deaktiválja az ágens hatását a virológuson.
	 */
	public void deactivate() {
		Logger.enter(this, "deactivate", null);
		
		owner.getActiveAgents().remove(this);
		
		Logger.exit(this, "deactivate", null);
	}
	
	/**
	 * Másolatot készít az ágensrõl
	 * @return		az ágens másolata
	 */
	public Agent makeCopy() {
		return (Agent) new ForgettingAgent();
	}
	
	/**
	 * Megtanulja az ágenst.
	 */
	public void interact() {
		owner.learnAgent(this);
	}
	
	public String toString() {
		return "forgetting_agent:\t " + Control.getName(this);
	}
}
