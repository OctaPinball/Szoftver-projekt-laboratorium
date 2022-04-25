package agents;

import miscellaneous.Control;
import miscellaneous.Logger;
import movement.Movement;
import movement.NormalMovement;
import movement.Stunned;

/**
 * Az Agent osztály leszármazottja, a használója kábult állapotba kerül, azaz cselekvésképtelenné válik.
 */
public class Stun extends Agent{

	/**
	 * Aktiválja az ágens hatását a virológuson, amely hatására a virológus a Stunned állapotba kerül, azaz cselekvésképtelenné válik.
	 */
	public void activate() {
		Logger.enter(this, "activate", null);
		
		Movement movement = new Stunned();
		
		if(movement.getPriority() > owner.getMovement().getPriority())
			owner.setMovement(movement);
		
		Logger.exit(this, "activate", null);
	}
	
	/**
	 * Aktiválja az ágens hatását a virológuson, azaz a virológus felébred a kábult állapotból és újra képes cselekedni.
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
		return (Agent) new Stun();
	}
	
	/**
	 * Megtanulja az ágenst.
	 */
	public void interact() {
		owner.learnAgent(this);
	}
	
	public String toString() {
		return "stun\t " + Control.getName(this);
	}
}
