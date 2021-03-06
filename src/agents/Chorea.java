package agents;

import miscellaneous.Control;
import miscellaneous.Logger;
import movement.Movement;
import movement.NormalMovement;
import movement.RandomMovement;

/**
 * Az Agent osztály leszármazottja, használata az eleszenvedőjén vitustáncot okoz, azaz kontrollálatlanul kezd el mozogni a mezők között.
 */
public class Chorea extends Agent{

	/**
	 * Aktiválja az ágens hatását a virológuson, ezzel megadva neki a RandomMovement tulajdonságot, amennyiben nagyobb a prioritása.
	 */
	public void activate() {
		Logger.enter(this, "activate", null);
		
		Movement movement = new RandomMovement();
		if(movement.getPriority() > owner.getMovement().getPriority())
			owner.setMovement(movement);
		
		Logger.exit(this, "activate", null);
	}
	
	/**
	 * Deaktiválja az ágens hatását a virológuson, ezzel elvéve tőle a RandomMovement tulajdonságot.
	 */
	public void deactivate() {
		Logger.enter(this, "deactivate", null);
		
		owner.setMovement(new NormalMovement());
		owner.getActiveAgents().remove(this);
		
		Logger.exit(this, "deactivate", null);
	}

	/**
	 * Másolatot készít az ágensről
	 * @return		az ágens másolata
	 */
	public Agent makeCopy() {
		Agent a = (Agent) new Chorea();				
		return a;
	}
	
	/**
	 * Megtanulja az ágenst.
	 */
	public void interact() {
		owner.learnAgent(this);
	}
	
	/**
	 * @return Visszaadja a Chorea egyed nevét
	 */
	public String toString() {
		return "chorea:\t\t" + Control.getName(this);
	}
	
	/**
	 * @return Visszaadja a Chorea egyed nevét és a hátralevő effekt időt
	 */
	public String toStringA() {
		return "chorea:\t\t" + Control.getName(this) + "\ttimetolive:\t" + this.effecttime + " round(s)";
	}
}
