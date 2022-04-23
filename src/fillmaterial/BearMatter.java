package fillmaterial;

import miscellaneous.Virologist;

public class BearMatter implements FillMaterial{
	
	private final int priority = 2;

	public void fillMaterial(Virologist v) {
		
		v.getField().copyStorage();
		v.getField().destroy();
		
	}
	
	public int getPriority() {
		return priority;
	}
}
