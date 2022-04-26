package agents;

import java.io.IOException;
import java.util.ArrayList;

import miscellaneous.Control;
import miscellaneous.Logger;
import miscellaneous.Virologist;

/**
 * Egy ágenst reprezentál a játékban, absztrakt osztály, tehát ebbõl származnak le a különféle ágens típusok
 * minden ágens elkészítéséhez szükség van adott mennyiségû aminosavra/nukleotidra és csak egy bizonyos ideig hatásosak.
 * Típustól függõen alkalmazható önmagunkon vagy egy másik virológuson is.
 */
public abstract class Agent {
	private int acidcost;
	private int nucleotidecost;
	protected int effecttime;
	protected Virologist owner;
	

	Agent(){
		
	}
	
	/**
	 * Ez a metódus fogja végrehajtani az ágens kenéseket virológusokon, amelyek különbözõ tulajdonságokat fognak megváltoztatni a virológuson.
	 * Elkészítéséhez szükséges a megfelelõ ágens ismerete és a szükséges mennyiségû aminosav/nukleotid.
	 * @param target		a célpont virológus
	 * @param i				az ágens kenésének száma (a visszakenésnél van szerepe, mert csak egyszer lehet visszakenni a kesztyûvel)
	 * @throws IOException 
	 */
	public void cast(Virologist target) throws CloneNotSupportedException, IOException {
		ArrayList<Object> par = new ArrayList<>(); par.add(target);
		Logger.enter(this, "cast", par);
		if(owner != null)
		{
			
			if(owner.getAminoacid() - acidcost < 0 || owner.getNucleotide() - nucleotidecost < 0)
				return;
			owner.setAminoAcid(owner.getAminoacid() - acidcost);
			owner.setNucleotide(owner.getNucleotide() - nucleotidecost);
			
		}
		
		if(!target.getBlock().block(owner, target, this))
		{
			Agent copy = this.makeCopy();
			Control.getHashMap("a").put(Control.getKey(Control.getHashMap("a"), this) + "_active", copy);
			Logger.register(copy, "agent_copy");
			target.addActiveAgent(copy);
		}
		
		Logger.exit(this, "cast", null);
	}
	
	public int getEffectTime() {
		return effecttime;
	}
	
	/**
	 * Absztrakt metódus, mely aktiválja az ágens hatását a virológuson, ezzel megváltoztatva valamely tulajdonságát.
	 */
	public abstract void activate();
	
	/**
	 * Absztrakt metódus, mely deaktiválja az ágens hatását a virológuson, ezzel visszaváltoztatva valamely tulajdonságát.
	 */
	public abstract void deactivate();
	
	/**
	 * Absztrakt metódus, mely másolatot készít az ágensrõl.
	 */
	public abstract Agent makeCopy();
	
	/**
	 * Eggyel csökkenti az ágens effectTime értékét. Ha lejár a hatás ideje megszünteti a hatását.
	 */
	public void stepEffectTime() {
		Logger.enter(this, "stepEffectTime", null);
		
		effecttime = effecttime - 1;
		if (effecttime <= 0)
			this.deactivate();
		
		Logger.exit(this, "stepEffectTime", null);
	}

	/**
	 * Beállítja az ágens birtokosát.
	 */
	public void setOwner(Virologist owner) {
		this.owner = owner;
	}
	
	/**
	 * Absztrakt metódus, amely megvizsgálja, hogy medvetánc "megtanulásáról" van-e szó. Azaz a BearAgent egybõl aktiválódik.
	 * @throws CloneNotSupportedException 
	 * @throws IOException 
	 */
	public abstract void interact() throws CloneNotSupportedException, IOException;
	
	public String toString() {
		return "agent:\t\t" + Control.getName(this);
	}
	
	public String toStringA() {
		return "agent:\t" + Control.getName(this) + "\ttimetolive:\t" + this.effecttime + " round(s)";
	}

	
}