package field;

import miscellaneous.*;
import agents.*;

public class Laboratory extends Field{
	
	private Agent agentOnField;
	
	public void stepOn(Virologist virologist) {
		super.stepOn(virologist);
		virologist.learnAgent(agentOnField);
	}
}
