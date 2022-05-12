package field;

import miscellaneous.*;

import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import agents.*;

/**
 * A Field osztály leszármazottja, az ilyen típusú mezõkre lépve tudnak a virológusok új ágenseket megismerni.
 * Minden laboratóriumban található egy ágens, amit a mezõre lépõ virológus egybõl megtanul.
 */
public class Laboratory extends Field{
	
	Image lab = new ImageIcon("res/Field_3.png").getImage();
	Image darkLab = new ImageIcon("res/Field_3_dark.png").getImage();
	
	public Laboratory(int id) {
		super(id);
	}

	private Agent agentOnField;
	
	/**
	 * A Field osztály stepOn függvényét kiegészíti, azzal hogy megismerteti a virológussal a laboratóriumban található ágens kódját
	 * @param virologist		a mezõre lépõ virológus
	 * @throws IOException 
	 * @throws CloneNotSupportedException 
	 */
	@Override
	public void stepOn(Virologist virologist) throws CloneNotSupportedException, IOException {
		ArrayList<Object> par = new ArrayList<Object>();
		par.add(virologist);
		Logger.enter(this, "stepOn", par);
		
		
		super.stepOn(virologist);
		agentOnField.setOwner(virologist);
		agentOnField.interact();
		//virologist.learnAgent(agentOnField);
		
		
		
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
	
	public String toString() {
		return "name:\t\t" + Control.getName(this)
		+ "\ntype:\t\tlaboratory"
		+ "\nvirologist:\t" + Control.getName(virologistOnField)
		+ "\nequipment:\t" + Control.getName(equipmentOnField);
	}
}
