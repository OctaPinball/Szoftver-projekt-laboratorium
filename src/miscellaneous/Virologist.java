package miscellaneous;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.ImageIcon;

import agents.*;
import beardefense.*;
import block.*;
import equipment.*;
import field.*;
import fillmaterial.*;
import graphic.Position;
import graphic.View;
import graphic.Viewable;
import movement.*;
import beardefense.*;

/**
 * Ezek a j�t�kosok �ltal ir�ny�tott karakterek, ezeken kereszt�l tud a j�t�kos a j�t�kon bel�l cselekedni. 
 * Sz�montartja a virol�gus anyagk�szlet�t, megtanult genetikai k�djait, a rajta l�v� akt�v �genseket �s akci�pontjait. 
 * A j�t�kos a virol�gus oszt�ly seg�ts�g�vel tud �genst kenni m�s virol�gusra, �s meg tud tanulni genetikai k�dokat, 
 * illetve el is tudja azokat felejteni.
 */
public class Virologist implements Viewable, Const{
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
	private BearDefense defense;
	//private ImageIcon virologist = new ImageIcon("res/Virologist.png");
	//private Position position;
	
	/**
	 * Inicializ�lja a virol�gust, azaz be�ll�tja a mozg�st, anyaggy�jt�k�pess�get, v�dekez�st, nyersanyagk�szletet �s az akci�pontokat alap�llapotokba
	 */
	Virologist(){
		setBlock(new NoBlock());
		setFillMaterial(new NormalMatter());
		setMovement(new NormalMovement());
		setDefense(new NoDefense());
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
		{
			Agent newAgent = a.makeCopy();
			agents.add(newAgent);
			Control.getHashMap("a").put(Control.getKey(Control.getHashMap("a"), a) + "_copy", newAgent);
			newAgent.setOwner(this);
		}
		Logger.exit(this, "learnAgent", null);
	}
	
	
	/**
	 * Megvizsgálja, hogy a virológus megtanult-e minden megtanulható ágenst
	 * @return	Igazat ad, ha megtanulta mindet
	 */
	public boolean learnallAgent() {
		boolean know[] = {false, false, false, false};
		
		ArrayList<Object> par = new ArrayList<>(); 
		
		for (Agent i : agents)
		{
			if (i.getClass() == Stun.class)
				know[0] = true;
			if (i.getClass() == Protection.class)
				know[1] = true;
			if (i.getClass() == Chorea.class)
				know[2] = true;
			if (i.getClass() == ForgettingAgent.class)
				know[3] = true;
		}
		
		if(know[0] == true && know[1] == true && know[2] == true && know[3] == true)
		{
			return true;
		}
		return false;
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
		for (int i = 0; i < activeagents.size(); i++)
		{
			if (activeagents.get(i).getClass() == a.getClass()) 
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
		if(equipments.size() < 3)
		{ 
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
		}
		else
			found = true;
		
			
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
		{
			e.loseEffect();
			//e.setWearer(null);
		}
			
		
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
	 * @param v		a rabló virol�gus
	 * @return		a lop�s sikeress�ge
	 * @throws IOException 
	 */
	public boolean stealEquipment(Equipment e, Virologist v) throws IOException {
		ArrayList<Object> par = new ArrayList<>(); par.add(e); par.add(v);
		Logger.enter(this, "stealEquipment", par);
		
		boolean success = true;
		e.dropEquipment();
		
		if (!addEquipment(e))
		{
			HashMap<String, Equipment> hash = new HashMap<String, Equipment>();
			for(Equipment eq : equipments)
			{
				if(eq.getClass().equals(Cape.class))
					hash.put("cape", eq);
				if(eq.getClass().equals(Axe.class))
					hash.put("axe", eq);
				if(eq.getClass().equals(Glove.class))
					hash.put("glove", eq);
				if(eq.getClass().equals(Sack.class))
					hash.put("sack", eq);
			}
			
			boolean first = true;
			String all = "";
			for(Equipment f : this.equipments)
			{
				String name = (String) Control.getKey(Control.getHashMap("e"), f);
				if(first)
				{
					first = false;
				}
				else
				{
					all += "/";
				}
				all += name;
			}
			System.out.println(all);
			Equipment drop = Control.getEquipment(hash);
			this.loseEquipment(drop);
			drop.pickupEquipment(v);
			e.pickupEquipment(this);
			if(this.equipments.contains(drop))
			{
				System.out.println("jej");
			}
		}
			
		
		Logger.exit(this, "stealEquipment", success);
		return success;
	}

    /**
     * Getter a virológus blokkolásánakk kiderítésére
     * @return		A blokkolás típus
     */
	public Block getBlock() {
		return block;
	}

    /**
     * Setter a virológus blokkolásának beállítására
     * @param block	Az új blokkolás típus
     */
	public void setBlock(Block block) {
		this.block = block;
	}

    /**
     * Getter a virológus maximálisan felvehető anyagmennyisének kiderítésére
     * @return		Az anyagtöltő képesség
     */
	public FillMaterial getFillMaterial() {
		return fillmaterial;
	}

    /**
     * Setter a virológus maximálisan felvehető anyagmennyisének beállítására
     * @param fillmaterial	Az új anyagtöltő képesség
     */
	public void setFillMaterial(FillMaterial fillMaterial) {
		this.fillmaterial = fillMaterial;
	}

    /**
     * Getter a virológus mozgásának kiderítésére
     * @return		A mozgás típusa
     */
	public Movement getMovement() {
		return movement;
	}

    /**
     * Setter a virológus mozgásának beállítására
     * @param movement	Az új mozgás típus
     */
	public void setMovement(Movement movement) {
		this.movement = movement;
	}
	
	
	/**
     * Setter a virológus medve támadás elleni védekezés beállítására
     * @param bd	Az új védekezés típusa
     */
	public void setBearDefense(BearDefense bd) {
		defense = bd;
	}
	
	/**
     * Getter a virológus medve támadás elleni védekezése kiderítéséhez
     * @return		A védekezés típusa
     */
	public BearDefense getDefense() {
		return defense;
	}
	
	/**
     * Setter a virológus ágensek elleni védekezésének beállítására
     * @param defense	Az új védekezés típus
     */
	public void setDefense(BearDefense defense) {
		this.defense = defense;
	}
	
    /**
     * A steppable interfészt valósítja meg
     * Meghívásonként adott mennyiséggel csökkenti az aktív ágensek hatásidejét
     */
	public void step() {
		Logger.enter(this, "step", null);
		for(int i = 0; i < activeagents.size(); i++)
		{
			activeagents.get(i).stepEffectTime();
		}
		Logger.exit(this, "step", null);
	}
	
	/**
	 * Aktiválja a virológuson az összes ágensből és felszerelésből származó effektust
	 */
	public void getAllEffect() {
		for(Agent a : activeagents) {
			a.activate();
		}
		
		for(Equipment e : equipments) {
			e.getEffect();
		}
	}
	
	/**
	 * A virológus meghal, ezért kiveszi a virológusok tömbjéből és elindítja a következő játékos körét
	 */
	public void Die() {
		field.removeVirologist();
		RoundManager.nextRound();
		RoundManager.getVriologists().remove(this);
	}

    /**
     * Getter a virológus aminosavának jelenlegi mennyiségének kiderítésére
     * @return		Az aminoacid értéke
     */
	public int getAminoacid() {
		return aminoacid;
	}

    /**
     * Setter a virológus aminosavának jelenlegi mennyiségének beállítására
     * @param aminoacid	Az aminoacid új értéke
     */
	public void setAminoAcid(int aminoacid) {
		this.aminoacid = aminoacid;
	}

    /**
     * Getter a virológus nukleotidának jelenlegi mennyiségének kiderítésére
     * @return		A nukleotid értéke
     */
	public int getNucleotide() {
		return nucleotide;
	}

    /**
     * Setter a virológus nukleotidának jelenlegi mennyiségének beállítására
     * @param nucleotide	A nukleotid új értéke
     */
	public void setNucleotide(int nucleotide) {
		this.nucleotide = nucleotide;
	}

    /**
     * Getter a virológus jelenlegi mezőjének kiderítésére
     * @return		A mező, amin a virológus áll
     */
	public Field getField() {
		return field;
	}
	
	/**
	 * Getter a virológusnál jelenleg lévő felszerelésekhez
	 * @return		A virológusnál lévő összes felszerelés
	 */
	public ArrayList<Equipment> getEquipments(){
		return equipments;
	}
	
	/**
	 * Getter a virológus megtanult ágenseihez
	 * @return		A virológusnál által megtanult összes ágens
	 */
	public ArrayList<Agent> getAgents(){
		return agents;
	}
	
    /**
     * Getter a virológuson jelenleg hatást kifejtő ágensek kiderítésére
     * @return		A virológuson aktív ágensek
     */
	public ArrayList<Agent> getActiveAgents(){
		return activeagents;
	}
	
	/**
	 * @return		Visszaad egy üres stringet
	 */
	public String listV() {
		return "";
	}
	
	/**
	 * Kilistázza a virológus adatait
	 * @param s		Meghatározza, hogy mit és mennyit listázzon ki a függvény
	 */
	public void list(String s) {
		if(s.equals("field"))
		{

			String out = RoundManager.getEntity().getField().toString();
			System.out.println("field");
			System.out.println(out);
			return;
		}
		if(s.equals("activeagent"))
		{
			String out = "activeagents";
			for(Agent a : RoundManager.getEntity().getActiveAgents())
			{
				out += "\n" + a.toStringA();
			}
			System.out.println(out);
			return;
		}
		if(s.equals("agent"))
		{
			String out = "agent";
			for(Agent a : RoundManager.getEntity().getAgents())
			{
				out += "\n" + a.toString();
			}
			System.out.println(out);
			return;
		}
		if(s.equals("equipment"))
		{
			String out = "equipment";
			int k = 0;
			for(Equipment e : RoundManager.getEntity().getEquipments())
			{
				k++;
				out += "\nslot_" + k + ":\t\t" + e.toString();
			}
			while(k < 3)
			{
				k++;
				out += "\nslot_" + k + ":";
			}
			//out += "\n";
			System.out.println(out);
			return;
		}
		if(s.equals("material"))
		{
			System.out.println("material\naminoacid:\t" + aminoacid + "\nnukleotid:\t" + nucleotide);
		}
		return;
	}
	
	/**
	 * A virológus által megtanult ágensekből stringet készít
	 * @return		A megtanult ágensek
	 */
	public String agentsToString() {
		String[] agent = null;
		for(int i = 0; i < agents.size(); i++) {
			agent[i] = agents.get(i).toString();
		}
		return agent.toString();
	}
	
	/**
	 * A virológuson aktív ágensekből stringet készít
	 * @return		Az aktív ágensek
	 */
	public String activeAgentsToString() {
		String[] activeAgent = null;
		for(int i = 0; i < activeagents.size(); i++) {
			activeAgent[i] = activeagents.get(i).toString() + "timetolive: " + activeagents.get(i).getEffectTime() + " round(s)";
		}
		return activeAgent.toString();
	}
	
	/**
	 * A virológusnál lévő felszerelésekből stringet készít
	 * @return		A birtokolt felszerelések
	 */
	public String equipmentsToString() {
		String[] equipment = null;
		for(int i = 0; i < equipments.size(); i++) {
			if(equipments.get(i) == null)
				equipment[i] = "slot_" + i + ":";
			else
				equipment[i] = "slot_" + i + ":" + equipments.get(i).toString();
		}
		return equipment.toString();
	}
	
	/**
	 * @return		A virológus pozíciója
	 */
	public Position calculateCoordinates() {
		return field.calculateCoordinates();
	}
	/*
	public ImageIcon getIMG() {
		return virologist;
	}*/

	/**
	 * Kiválasztja a virológushoz tartozó rajzoló függvényt
	 * @param	v
	 */
	@Override
	public void pickDraw(View v) {
		v.drawVirologist(this);
	}
	
	/**
	 * @return		A virológus akciópontjai
	 */
	public int getActionPoint(){
		return actionpoint;
	}
	
	/**
	 * Feltölti a virológus akciópontjait és lépteti az effektek aktív idejét
	 */
	public void newRound() {
		actionpoint = START_ACTION_POINTS;
		step();
	}
	
	/**
	 * @return		Megmondja, hogy a virológusnak maradtak-e még akciópontjai.
	 */
	public boolean hasActionPoint() {
		if(actionpoint > 0)
		{
			return true;
		}
		return false;
	}
	
	/**
	 * A virológus elhasznált egy akciópontot
	 */
	public void commitAction() {
		actionpoint--;
	}
	
	/**
	 * Megadja hogy a kijelölt ágens elkészíthető-e
	 * @param a		Az elkészítendő ágens
	 * @return		Elkészíthető-e az ágens
	 */
	public boolean canBeCasted(Agent a) {
		return a.getAcidcost() <= aminoacid && a.getNucleotidecost() <= nucleotide;
	}
}
