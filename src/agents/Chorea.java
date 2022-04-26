package agents;

import miscellaneous.Control;
import miscellaneous.Logger;
import movement.Movement;
import movement.NormalMovement;
import movement.RandomMovement;

/**
 * Az Agent oszt�ly lesz�rmazottja, haszn�lata az eleszenved�j�n vitust�ncot okoz, azaz kontroll�latlanul kezd el mozogni a mez�k k�z�tt.
 */
public class Chorea extends Agent{

	/**
	 * Aktiv�lja az �gens hat�s�t a virol�guson, ezzel megadva neki a RandomMovement tulajdons�got, amennyiben nagyobb a priorit�sa.
	 */
	public void activate() {
		Logger.enter(this, "activate", null);
		
		Movement movement = new RandomMovement();
		if(movement.getPriority() > owner.getMovement().getPriority())
			owner.setMovement(movement);
		
		Logger.exit(this, "activate", null);
	}
	
	/**
	 * Deaktiv�lja az �gens hat�s�t a virol�guson, ezzel elv�ve t�le a RandomMovement tulajdons�got.
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
		Agent a = (Agent) new Chorea();				
		return a;
	}
	
	/**
	 * Megtanulja az �genst.
	 */
	public void interact() {
		owner.learnAgent(this);
	}
	
	public String toString() {
		return "chorea:\t " + Control.getName(this);
	}
	
	public String toStringA() {
		return "chorea:\t " + Control.getName(this) + "\ttimetolive: " + this.effecttime + " round(s)";
	}
}
