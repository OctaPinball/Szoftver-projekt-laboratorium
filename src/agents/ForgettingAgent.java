package agents;

import miscellaneous.Control;
import miscellaneous.Logger;

/**
 * Az Agent oszt�ly lesz�rmazottja, haszn�lata az eleszenved�j�n felejt�st okoz, azaz elfelejti az �sszes eddig megtanult �gens genetikai k�dj�t.
 */
public class ForgettingAgent extends Agent{

	/**
	 * Aktiv�lja az �gens hat�s�t a virol�guson, amely sor�n a virol�gus elfelejti az �sszes addig megtanult �genst.
	 */
	public void activate() {
		Logger.enter(this, "activate", null);
		
		owner.forgetAllAgent();
		this.deactivate();
		
		Logger.exit(this, "activate", null);
	}
	
	/**
	 * Deaktiv�lja az �gens hat�s�t a virol�guson.
	 */
	public void deactivate() {
		Logger.enter(this, "deactivate", null);
		
		owner.getActiveAgents().remove(this);
		
		Logger.exit(this, "deactivate", null);
	}
	
	/**
	 * M�solatot k�sz�t az �gensr�l
	 * @return		az �gens m�solata
	 */
	public Agent makeCopy() {
		return (Agent) new ForgettingAgent();
	}
	
	/**
	 * Megtanulja az �genst.
	 */
	public void interact() {
		owner.learnAgent(this);
	}
	
	public String toString() {
		return "forgetting_agent:\t " + Control.getName(this);
	}
}
