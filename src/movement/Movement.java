package movement;

import field.Field;
import miscellaneous.Virologist;

public interface Movement {
	
	public abstract void Move(Virologist v, Field target);
	
}
