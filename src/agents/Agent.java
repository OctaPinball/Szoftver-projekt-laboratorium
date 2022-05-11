package agents;

import java.io.IOException;
import java.util.ArrayList;

import miscellaneous.Control;
import miscellaneous.Logger;
import miscellaneous.Virologist;

/**
 * Egy �genst reprezent�l a j�t�kban, absztrakt oszt�ly, teh�t ebb�l sz�rmaznak le a k�l�nf�le �gens t�pusok
 * minden �gens elk�sz�t�s�hez sz�ks�g van adott mennyis�g� aminosavra/nukleotidra �s csak egy bizonyos ideig hat�sosak.
 * T�pust�l f�gg�en alkalmazhat� �nmagunkon vagy egy m�sik virol�guson is.
 */
public abstract class Agent {
	private int acidcost;
	private int nucleotidecost;
	protected int effecttime;
	protected Virologist owner;
	

	Agent(){
		
	}
	
	/**
	 * Ez a met�dus fogja v�grehajtani az �gens ken�seket virol�gusokon, amelyek k�l�nb�z� tulajdons�gokat fognak megv�ltoztatni a virol�guson.
	 * Elk�sz�t�s�hez sz�ks�ges a megfelel� �gens ismerete �s a sz�ks�ges mennyis�g� aminosav/nukleotid.
	 * @param target		a c�lpont virol�gus
	 * @param i				az �gens ken�s�nek sz�ma (a visszaken�sn�l van szerepe, mert csak egyszer lehet visszakenni a keszty�vel)
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
	 * Absztrakt met�dus, mely aktiv�lja az �gens hat�s�t a virol�guson, ezzel megv�ltoztatva valamely tulajdons�g�t.
	 */
	public abstract void activate();
	
	/**
	 * Absztrakt met�dus, mely deaktiv�lja az �gens hat�s�t a virol�guson, ezzel visszav�ltoztatva valamely tulajdons�g�t.
	 */
	public abstract void deactivate();
	
	/**
	 * Absztrakt met�dus, mely m�solatot k�sz�t az �gensr�l.
	 */
	public abstract Agent makeCopy();
	
	/**
	 * Eggyel cs�kkenti az �gens effectTime �rt�k�t. Ha lej�r a hat�s ideje megsz�nteti a hat�s�t.
	 */
	public void stepEffectTime() {
		Logger.enter(this, "stepEffectTime", null);
		
		effecttime = effecttime - 1;
		if (effecttime <= 0)
			this.deactivate();
		
		Logger.exit(this, "stepEffectTime", null);
	}

	/**
	 * Be�ll�tja az �gens birtokos�t.
	 */
	public void setOwner(Virologist owner) {
		this.owner = owner;
	}
	
	/**
	 * Absztrakt met�dus, amely megvizsg�lja, hogy medvet�nc "megtanul�s�r�l" van-e sz�. Azaz a BearAgent egyb�l aktiv�l�dik.
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