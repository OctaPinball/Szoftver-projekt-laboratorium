package agents;


import java.io.IOException;

import miscellaneous.Control;
import miscellaneous.Logger;
import movement.NormalMovement;
import movement.Stunned;
import movement.BearDance;
import movement.Movement;

/**
 * Az Agent osztály leszármazottja, egy olyan vírust, mely az elszenvedõjét medvévé változtatja.
 */
public class BearAgent extends Agent{
	
	public BearAgent() {
		effecttime = -1;
		acidcost = 0;
		nucleotidecost = 0;
	}
	
	/**
	 * Aktivï¿½lja az ï¿½gens hatï¿½sï¿½t a virolï¿½guson, ezzel megadva neki a BearDance tulajdonsï¿½got.
	 */
	public void activate() {
		Logger.enter(this, "activate", null);
		
		Movement movement = new BearDance();
		
		if(movement.getPriority() > owner.getMovement().getPriority())
			owner.setMovement(movement);
		
		Logger.exit(this, "activate", null);
	}
	
	/**
	 * Deaktivï¿½lja az ï¿½gens hatï¿½sï¿½t a virolï¿½guson, ezzel elvï¿½ve tï¿½le a BearDance tulajdonsï¿½got.
	 */
	public void deactivate() {
		Logger.enter(this, "deactivate", null);
		
		owner.setMovement(new NormalMovement());
		owner.getActiveAgents().remove(this);
		
		Logger.exit(this, "deactivate", null);
	}

	/**
	 * Mï¿½solatot kï¿½szï¿½t az ï¿½gensrï¿½l
	 * @return		az ï¿½gens mï¿½solata
	 */
	public Agent makeCopy() {
		return (Agent) new BearAgent();
	}
	
	/**
	 * Aktivï¿½lï¿½dik a BearAgent.
	 * @throws CloneNotSupportedException 
	 * @throws IOException 
	 */
	public void interact() throws CloneNotSupportedException, IOException {
		this.cast(owner);
	}
	
	/**
	 * @return Visszaadja a BearAgent egyedi nevét
	 */
	public String toString() {
		return "bear_agent:\t\t" + Control.getName(this);
	}
	
	/**
	 * @return Visszaadja a BearAgent egyedi nevét és hogy meddig aktív még az ágens
	 */
	public String toStringA() {
		return "bear_agent:\t" + Control.getName(this) + "\ttimetolive:\t" + this.effecttime + " round(s)";
	}
}
