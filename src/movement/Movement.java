package movement;

import field.Field;
import miscellaneous.Virologist;

public interface Movement {
	
	public abstract void move(Virologist v, Field target);
	
	
}
