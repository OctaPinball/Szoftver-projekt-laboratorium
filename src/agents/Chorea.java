package agents;

import miscellaneous.Logger;
import movement.NormalMovement;
import movement.RandomMovement;

/**
 * Az Agent osztály leszármazottja, használata az eleszenvedõjén vitustáncot okoz, azaz kontrollálatlanul kezd el mozogni a mezõk között.
 */
public class Chorea extends Agent{

	/**
	 * Aktiválja az ágens hatását a virológuson, ezzel megadva neki a RandomMovement tulajdonságot.
	 */
	public void activate() {
		Logger.enter(this, "activate", null);
		
		owner.setMovement(new RandomMovement());
		
		Logger.exit(this, "activate", null);
	}
	
	/**
	 * Deaktiválja az ágens hatását a virológuson, ezzel elvéve tõle a RandomMovement tulajdonságot.
	 */
	public void deactivate() {
		Logger.enter(this, "deactivate", null);
		
		owner.setMovement(new NormalMovement());
		owner.getActiveAgents().remove(this);
		
		Logger.exit(this, "deactivate", null);
	}

	/**
	 * Másolatot készít az ágensrõl
	 * @return		az ágens másolata
	 */
	public Agent makeCopy() {
		return (Agent) new Chorea();
	}
}
