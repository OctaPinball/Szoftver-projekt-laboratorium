package field;

import miscellaneous.*;

import java.util.ArrayList;

import agents.*;

/**
 * A Field osztály leszármazottja, az ilyen típusú mezõkre lépve tudnak a virológusok új ágenseket megismerni.
 * Minden laboratóriumban található egy ágens, amit a mezõre lépõ virológus egybõl megtanul.
 */
public class Laboratory extends Field{
	
	private Agent agentOnField;
	
	/**
	 * A Field osztály stepOn függvényét kiegészíti, azzal hogy megismerteti a virológussal a laboratóriumban található ágens kódját
	 * @param virologist		a mezõre lépõ virológus
	 */
	@Override
	public void stepOn(Virologist virologist) {
		ArrayList<Object> par = new ArrayList<Object>();
		par.add(virologist);
		Logger.enter(this, "stepOn", par);
		
		
		super.stepOn(virologist);
		virologist.learnAgent(agentOnField);
		
		
		Logger.exit(this, "stepOn", null);
	}

	/**
	 * Hozzáadja a paraméterben kapott ágenst a laboratóriumhoz.
	 * @param newAgent		a laboratóriumban megtanulható ágens
	 */
	public void addAgent(Agent newAgent) {
		ArrayList<Object> par = new ArrayList<Object>();
		par.add(newAgent);
		Logger.enter(this, "addAgent", par);


		agentOnField = newAgent;


		Logger.exit(this, "addAgent", null);
	}
}
