package agents;


import miscellaneous.Control;
import miscellaneous.Logger;
import movement.NormalMovement;
import movement.Stunned;
import movement.BearDance;
import movement.Movement;

public class BearAgent extends Agent{
	/**
	 * Aktiválja az ágens hatását a virológuson, ezzel megadva neki a BearDance tulajdonságot.
	 */
	public void activate() {
		Logger.enter(this, "activate", null);
		
		Movement movement = new BearDance();
		
		if(movement.getPriority() > owner.getMovement().getPriority())
			owner.setMovement(movement);
		
		Logger.exit(this, "activate", null);
	}
	
	/**
	 * Deaktiválja az ágens hatását a virológuson, ezzel elvéve tõle a BearDance tulajdonságot.
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
		return (Agent) new BearAgent();
	}
	
	/**
	 * Aktiválódik a BearAgent.
	 * @throws CloneNotSupportedException 
	 */
	public void interact() throws CloneNotSupportedException {
		this.cast(owner);
	}
	
	public String toString() {
		return "bear_agent:\t " + Control.getName(this);
	}
	
	public String toStringA() {
		return "bear_agent:\t " + Control.getName(this) + "\ttimetolive: " + this.effecttime + " round(s)";
	}
}
