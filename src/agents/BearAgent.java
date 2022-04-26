package agents;


import miscellaneous.Control;
import miscellaneous.Logger;
import movement.NormalMovement;
import movement.Stunned;
import movement.BearDance;
import movement.Movement;

public class BearAgent extends Agent{
	/**
	 * Aktiv�lja az �gens hat�s�t a virol�guson, ezzel megadva neki a BearDance tulajdons�got.
	 */
	public void activate() {
		Logger.enter(this, "activate", null);
		
		Movement movement = new BearDance();
		
		if(movement.getPriority() > owner.getMovement().getPriority())
			owner.setMovement(movement);
		
		Logger.exit(this, "activate", null);
	}
	
	/**
	 * Deaktiv�lja az �gens hat�s�t a virol�guson, ezzel elv�ve t�le a BearDance tulajdons�got.
	 */
	public void deactivate() {
		Logger.enter(this, "deactivate", null);
		
		owner.setMovement(new NormalMovement());
		owner.getActiveAgents().remove(this);
		
		Logger.exit(this, "deactivate", null);
	}

	/**
	 * M�solatot k�sz�t az �gensr�l
	 * @return		az �gens m�solata
	 */
	public Agent makeCopy() {
		return (Agent) new BearAgent();
	}
	
	/**
	 * Aktiv�l�dik a BearAgent.
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
