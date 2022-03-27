package field;

import miscellaneous.*;

import java.util.ArrayList;

import agents.*;

public class Laboratory extends Field{
	
	private Agent agentOnField;
	
	public void stepOn(Virologist virologist) {
		ArrayList<Object> par = new ArrayList<Object>();
		par.add(virologist);
		Logger.enter(this, "stepOn", par);
		
		
		super.stepOn(virologist);
		virologist.learnAgent(agentOnField);
		
		
		Logger.exit(this, "stepOn", null);
	}
}
