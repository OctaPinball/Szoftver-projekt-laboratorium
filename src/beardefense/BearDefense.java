package beardefense;

import java.io.IOException;

import miscellaneous.Virologist;

public interface BearDefense {

	public abstract void bearAttack(Virologist bear, Virologist target) throws CloneNotSupportedException, IOException;

	public abstract int getPriority();
}
