package miscellaneous;

import java.util.ArrayList;
import java.util.Iterator;

import agents.*;
import block.*;
import equipment.*;
import field.*;
import fillmaterial.*;
import movement.*;

/**
 * Ezek a j�t�kosok �ltal ir�ny�tott karakterek, ezeken kereszt�l tud a j�t�kos a j�t�kon bel�l cselekedni. 
 * Sz�montartja a virol�gus anyagk�szlet�t, megtanult genetikai k�djait, a rajta l�v� akt�v �genseket �s akci�pontjait. 
 * A j�t�kos a virol�gus oszt�ly seg�ts�g�vel tud �genst kenni m�s virol�gusra, �s meg tud tanulni genetikai k�dokat, 
 * illetve el is tudja azokat felejteni.
 */
public class Virologist implements Steppable{
	private int aminoacid;
	private int nucleotide;
	private int actionpoint;
	
	private ArrayList<Agent> activeagents;
	private ArrayList<Agent> agents;
	
	private ArrayList<Equipment> equipments;
	
	private Field field;
	
	private Block block;
	private FillMaterial fillmaterial;
	private Movement movement;
	
	/**
	 * Inicializ�lja a virol�gust, azaz be�ll�tja a mozg�st, anyaggy�jt�k�pess�get, v�dekez�st, nyersanyagk�szletet �s az akci�pontokat alap�llapotokba
	 */
	Virologist(){
		setBlock(new NoBlock());
		setFillMaterial(new NormalMatter());
		setMovement(new NormalMovement());
		Logger.register(this.getBlock(), "nob");
		Logger.register(this.getFillMaterial(), "nma");
		Logger.register(this.getMovement(), "nmo");
		
		activeagents = new ArrayList<Agent>();
		agents = new ArrayList<Agent>();
		equipments = new ArrayList<Equipment>();
		
		setAminoAcid(0);
		setNucleotide(0);
		actionpoint = 0;
		
		field = null;
	}
	
	/**
	 * A virol�gus megtanulja a param�terk�nt kapott �genst, ezzel az beker�l a virol�gus �ltal megtanult �gensek list�j�ba. 
	 * Ha a lista teljes, vagyis az �sszes l�tez� �gens genetikai k�dj�t megtanulta, akkor megh�vja az EndGame() f�ggv�nyt �s a j�t�k v�get �r.
	 * @param a		a megtanuland� �gens
	 */
	public void learnAgent(Agent a) {
		ArrayList<Object> par = new ArrayList<>(); par.add(a);
		Logger.enter(this, "learnAgent", par);
		
		
		boolean found = false;
		for (Agent i : agents)
		{
			if (i.getClass() == a.getClass())
				found = true;
		}
		if(!found)
			agents.add(a);
			
		
		Logger.exit(this, "learnAgent", null);
	}
	
	/**
	 * A virol�gus elfelejti az �sszes eddig megtanult �gens genetikai k�dj�t, ezzel ki�r�l az elk�sz�thet� �gensek list�ja.
	 */
	public void forgetAllAgent() {
		Logger.enter(this, "forgetAllAgent", null);
		
		
		agents = new ArrayList<Agent>();
		
		
		Logger.exit(this, "forgetAllAgent", null);
	}
	
	/**
	 * Amennyiben egy virol�gusra �genst kennek, �s azt nem blokkolja semmi, akkor a param�terk�nt kapott �gens az �akt�v t�mbbe� 
	 * (azok az �gensek ker�lnek ide, amikre ut�na megh�v�dik az activate() f�ggv�ny) ker�l.
	 * @param a		az elk�sz�tett �gens
	 */
	public void addActiveAgent(Agent a) {
		ArrayList<Object> par = new ArrayList<>(); par.add(a);
		Logger.enter(this, "addActiveAgent", par);
		
		
		boolean found = false;
		for (Agent i : activeagents)
		{
			if (i.getClass() == a.getClass()) 
			{
				activeagents.remove(i);
				found = true;
			}
		}
		activeagents.add(a);
		a.setOwner(this);
		if(!found) 
		{
			a.activate();
		}
			
		
		Logger.exit(this, "addActiveAgent", null);
	}
	
	/**
	 * Ha a param�terk�nt kapott t�pus� t�rggyal m�g nem rendelkezik a virol�gus felveszi a gy�jtem�ny�be.
	 * @param e		a t�rgy amit felvesz
	 * @return		a felv�tel sikeress�ge
	 */
	public boolean addEquipment(Equipment e) {
		ArrayList<Object> par = new ArrayList<>(); par.add(e);
		Logger.enter(this, "addEquipment", par);
		
		
		boolean found = false;
		for (Equipment i : equipments)
		{
			if (i.getClass() == e.getClass()) 
				found = true;
		}
		if(!found)
		{
			equipments.add(e);
			
			e.getEffect();
		}
			
		Logger.exit(this, "addEquipment", !found);
		return !found;
	}
	
	/**
	 * A param�terk�nt �tvett felszerel�st eldobja a virol�gus, ezzel elvesz�tve hat�s�t.
	 * @param e		az eldobott felszerel�s
	 */
	public void loseEquipment(Equipment e) {
		ArrayList<Object> par = new ArrayList<>(); par.add(e);
		Logger.enter(this, "loseEquipment", par);
		
		
		if(equipments.remove(e))
			e.loseEffect();
			
		
		Logger.exit(this, "loseEquipment", null);
	}
	
	/**
	 * Amikor r�l�p�nk egy �j mez�re, akkor a virol�gus a helyzet�t be�ll�tja a param�terk�nt kapott mez�re.
	 * @param f		a mez�, amire r�l�pett a virol�gus
	 */
	public void changeField(Field f) {
		ArrayList<Object> par = new ArrayList<>(); par.add(f);;
		Logger.enter(this, "changeField", par);
		
		this.field = f;
		
		Logger.exit(this, "changeField", null);
	}
	
	/**
	 * A param�terk�nt �tvett virol�gust�l a szint�n param�terk�nt �tvett t�rgyat ellopjaa virol�gus.
	 * @param e		az ellopott felszerel�s
	 * @param v		a kirabolt virol�gus
	 * @return		a lop�s sikeress�ge
	 */
	public boolean stealEquipment(Equipment e, Virologist v) {
		ArrayList<Object> par = new ArrayList<>(); par.add(e); par.add(v);
		Logger.enter(this, "stealEquipment", par);
		
		boolean success = true;
		
		e.dropEquipment();
		
		if (!v.addEquipment(e))
			success = false;
			
		
		Logger.exit(this, "stealEquipment", success);
		return success;
	}

	public Block getBlock() {
		return block;
	}

	public void setBlock(Block block) {
		this.block = block;
	}

	public FillMaterial getFillMaterial() {
		return fillmaterial;
	}

	public void setFillMaterial(FillMaterial fillMaterial) {
		this.fillmaterial = fillMaterial;
	}

	public Movement getMovement() {
		return movement;
	}

	public void setMovement(Movement movement) {
		this.movement = movement;
	}
	
	public void step() {
		Logger.enter(this, "step", null);
		for(Agent a : activeagents)
		{
			a.stepEffectTime();
		}
		Logger.exit(this, "step", null);
	}

	public int getAminoacid() {
		return aminoacid;
	}

	public void setAminoAcid(int aminoacid) {
		this.aminoacid = aminoacid;
	}

	public int getNucleotide() {
		return nucleotide;
	}

	public void setNucleotide(int nucleotide) {
		this.nucleotide = nucleotide;
	}

	public Field getField() {
		return field;
	}
	
	public ArrayList<Agent> getActiveAgents(){
		return activeagents;
	}
}
