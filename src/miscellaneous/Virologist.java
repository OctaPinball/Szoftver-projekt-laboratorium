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
 * Ezek a játékosok által irányított karakterek, ezeken keresztül tud a játékos a játékon belül cselekedni. 
 * Számontartja a virológus anyagkészletét, megtanult genetikai kódjait, a rajta lévõ aktív ágenseket és akciópontjait. 
 * A játékos a virológus osztály segítségével tud ágenst kenni más virológusra, és meg tud tanulni genetikai kódokat, 
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
	 * Inicializálja a virológust, azaz beállítja a mozgást, anyaggyûjtõképességet, védekezést, nyersanyagkészletet és az akciópontokat alapállapotokba
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
	 * A virológus megtanulja a paraméterként kapott ágenst, ezzel az bekerül a virológus által megtanult ágensek listájába. 
	 * Ha a lista teljes, vagyis az összes létezõ ágens genetikai kódját megtanulta, akkor meghívja az EndGame() függvényt és a játék véget ér.
	 * @param a		a megtanulandó ágens
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
		{
			agents.add(a);
			a.setOwner(this);
		}
			
		
		Logger.exit(this, "learnAgent", null);
	}
	
	/**
	 * A virológus elfelejti az összes eddig megtanult ágens genetikai kódját, ezzel kiürül az elkészíthetõ ágensek listája.
	 */
	public void forgetAllAgent() {
		Logger.enter(this, "forgetAllAgent", null);
		
		
		agents = new ArrayList<Agent>();
		
		
		Logger.exit(this, "forgetAllAgent", null);
	}
	
	/**
	 * Amennyiben egy virológusra ágenst kennek, és azt nem blokkolja semmi, akkor a paraméterként kapott ágens az “aktív tömbbe” 
	 * (azok az ágensek kerülnek ide, amikre utána meghívódik az activate() függvény) kerül.
	 * @param a		az elkészített ágens
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
	 * Ha a paraméterként kapott típusú tárggyal még nem rendelkezik a virológus felveszi a gyûjteményébe.
	 * @param e		a tárgy amit felvesz
	 * @return		a felvétel sikeressége
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
	 * A paraméterként átvett felszerelést eldobja a virológus, ezzel elveszítve hatását.
	 * @param e		az eldobott felszerelés
	 */
	public void loseEquipment(Equipment e) {
		ArrayList<Object> par = new ArrayList<>(); par.add(e);
		Logger.enter(this, "loseEquipment", par);
		
		
		if(equipments.remove(e))
			e.loseEffect();
			
		
		Logger.exit(this, "loseEquipment", null);
	}
	
	/**
	 * Amikor rálépünk egy új mezõre, akkor a virológus a helyzetét beállítja a paraméterként kapott mezõre.
	 * @param f		a mezõ, amire rálépett a virológus
	 */
	public void changeField(Field f) {
		ArrayList<Object> par = new ArrayList<>(); par.add(f);;
		Logger.enter(this, "changeField", par);
		
		this.field = f;
		
		Logger.exit(this, "changeField", null);
	}
	
	/**
	 * A paraméterként átvett virológustól a szintén paraméterként átvett tárgyat ellopjaa virológus.
	 * @param e		az ellopott felszerelés
	 * @param v		a kirabolt virológus
	 * @return		a lopás sikeressége
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

    /**
     * Getter a virolÃ³gus blokkolÃ¡sÃ¡nakk kiderÃ­tÃ©sÃ©re
     * @return block
     */
	public Block getBlock() {
		return block;
	}

    /**
     * Setter a virolÃ³gus blokkolÃ¡sÃ¡nak beÃ¡llÃ­tÃ¡sÃ¡ra
     * @param block
     */
	public void setBlock(Block block) {
		this.block = block;
	}

    /**
     * Getter a virolÃ³gus maximÃ¡lisan felvehetÅ‘ anyagmennyisÃ©nek kiderÃ­tÃ©sÃ©re
     * @return fillmaterial
     */
	public FillMaterial getFillMaterial() {
		return fillmaterial;
	}

    /**
     * Setter a virolÃ³gus maximÃ¡lisan felvehetÅ‘ anyagmennyisÃ©nek beÃ¡llÃ­tÃ¡sÃ¡ra
     * @param fillmaterial
     */
	public void setFillMaterial(FillMaterial fillMaterial) {
		this.fillmaterial = fillMaterial;
	}

    /**
     * Getter a virolÃ³gus mozgÃ¡sÃ¡nak kiderÃ­tÃ©sÃ©re
     * @return movement
     */
	public Movement getMovement() {
		return movement;
	}

    /**
     * Setter a virolÃ³gus mozgÃ¡sÃ¡nak beÃ¡llÃ­tÃ¡sÃ¡ra
     * @param movement
     */
	public void setMovement(Movement movement) {
		this.movement = movement;
	}
	
    /**
     * A steppable interfÃ©szt valÃ³sÃ­tja meg
     * MeghÃ­vÃ¡sonkÃ©nt adott mennyisÃ©ggel csÃ¶kkenti az aktÃ­v Ã¡gensek hatÃ¡sidejÃ©t
     */
	public void step() {
		Logger.enter(this, "step", null);
		for(Agent a : activeagents)
		{
			a.stepEffectTime();
		}
		Logger.exit(this, "step", null);
	}

    /**
     * Getter a virolÃ³gus aminosavÃ¡nak jelenlegi mennyisÃ©gÃ©nek kiderÃ­tÃ©sÃ©re
     * @return aminoacid
     */
	public int getAminoacid() {
		return aminoacid;
	}

    /**
     * Setter a virolÃ³gus aminosavÃ¡nak jelenlegi mennyisÃ©gÃ©nek beÃ¡llÃ­tÃ¡sÃ¡ra
     * @param aminoacid
     */
	public void setAminoAcid(int aminoacid) {
		this.aminoacid = aminoacid;
	}

    /**
     * Getter a virolÃ³gus nukleotidÃ¡nak jelenlegi mennyisÃ©gÃ©nek kiderÃ­tÃ©sÃ©re
     * @return nucleotide
     */
	public int getNucleotide() {
		return nucleotide;
	}

    /**
     * Setter a virolÃ³gus nukleotidÃ¡nak jelenlegi mennyisÃ©gÃ©nek beÃ¡llÃ­tÃ¡sÃ¡ra
     * @param nucleotide
     */
	public void setNucleotide(int nucleotide) {
		this.nucleotide = nucleotide;
	}

    /**
     * Getter a virolÃ³gus jelenlegi mezÅ‘jÃ©nek kiderÃ­tÃ©sÃ©re
     * @return field
     */
	public Field getField() {
		return field;
	}
	
    /**
     * Getter a virolÃ³guson jelenleg hatÃ¡st kifejtÅ‘ Ã¡gensek kiderÃ­tÃ©sÃ©re
     * @return activeagents
     */
	public ArrayList<Agent> getActiveAgents(){
		return activeagents;
	}
}
