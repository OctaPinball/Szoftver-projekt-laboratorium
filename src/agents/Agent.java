package agents;

import java.util.ArrayList;

import miscellaneous.Logger;
import miscellaneous.Virologist;

public abstract class Agent {
	private int acidcost;
	private int nucleotidecost;
	private int effecttime;
	
	protected Virologist owner;
	
	Agent(){
		
	}
	
	public void cast(Virologist target, int i) throws CloneNotSupportedException {
		ArrayList<Object> par = new ArrayList<>(); par.add(target); par.add(i);
		Logger.enter(this, "cast", par);
		
		if(owner.getAminoacid() - acidcost < 0 || owner.getNucleotide() - nucleotidecost < 0)
			return;
		owner.setAminoAcid(owner.getAminoacid() - acidcost);
		owner.setNucleotide(owner.getNucleotide() - nucleotidecost);
		
		if(!target.getBlock().block(owner, target, this))
		{
			Agent copy = (Agent) this.clone();
			target.addActiveAgent(copy);
		}
		
		Logger.exit(this, "cast", null);
	}
	
	public abstract void activate();
	
	public abstract void deactivate();
	
	public void stepEffectTime() {
		Logger.enter(this, "stepEffectTime", null);
		
		effecttime = effecttime - 1;
		if (effecttime <= 0)
			this.deactivate();
		
		Logger.exit(this, "stepEffectTime", null);
	}
	
	
}
