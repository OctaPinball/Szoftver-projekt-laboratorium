package field;

import miscellaneous.*;

import java.util.ArrayList;

import agents.*;

public class Laboratory extends Field{
	
	private Agent agentOnField;
	
	/**
	 * A Field oszt�ly stepOn f�ggv�ny�t kieg�sz�ti, azzal hogy megismerteti a virol�gussal a laborat�riumban tal�lhat� �gens k�dj�t
	 * @param virologist		a mez�re l�p� virol�gus
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
	 * Hozz�adja a param�terben kapott �genst a laborat�riumhoz.
	 * @param newAgent		a laborat�riumban megtanulhat� �gens
	 */
	public void addAgent(Agent newAgent) {
		ArrayList<Object> par = new ArrayList<Object>();
		par.add(newAgent);
		Logger.enter(this, "addAgent", par);


		agentOnField = newAgent;


		Logger.exit(this, "addAgent", null);
	}
}
