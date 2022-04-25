package agents;

import miscellaneous.Control;
import miscellaneous.Logger;
import movement.Movement;
import movement.NormalMovement;
import movement.Stunned;

/**
 * Az Agent oszt�ly lesz�rmazottja, a haszn�l�ja k�bult �llapotba ker�l, azaz cselekv�sk�ptelenn� v�lik.
 */
public class Stun extends Agent{

	/**
	 * Aktiv�lja az �gens hat�s�t a virol�guson, amely hat�s�ra a virol�gus a Stunned �llapotba ker�l, azaz cselekv�sk�ptelenn� v�lik.
	 */
	public void activate() {
		Logger.enter(this, "activate", null);
		
		Movement movement = new Stunned();
		
		if(movement.getPriority() > owner.getMovement().getPriority())
			owner.setMovement(movement);
		
		Logger.exit(this, "activate", null);
	}
	
	/**
	 * Aktiv�lja az �gens hat�s�t a virol�guson, azaz a virol�gus fel�bred a k�bult �llapotb�l �s �jra k�pes cselekedni.
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
		return (Agent) new Stun();
	}
	
	/**
	 * Megtanulja az �genst.
	 */
	public void interact() {
		owner.learnAgent(this);
	}
	
	public String toString() {
		return "stun\t " + Control.getName(this);
	}
}
