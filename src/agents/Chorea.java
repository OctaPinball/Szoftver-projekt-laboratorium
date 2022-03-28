package agents;

import miscellaneous.Logger;
import movement.NormalMovement;
import movement.RandomMovement;

/**
 * Az Agent oszt�ly lesz�rmazottja, haszn�lata az eleszenved�j�n vitust�ncot okoz, azaz kontroll�latlanul kezd el mozogni a mez�k k�z�tt.
 */
public class Chorea extends Agent{

	/**
	 * Aktiv�lja az �gens hat�s�t a virol�guson, ezzel megadva neki a RandomMovement tulajdons�got.
	 */
	public void activate() {
		Logger.enter(this, "activate", null);
		
		owner.setMovement(new RandomMovement());
		
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
		return (Agent) new Chorea();
	}
}
