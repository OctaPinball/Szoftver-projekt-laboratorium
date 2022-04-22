package miscellaneous;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

import agents.*;
import equipment.*;
import field.*;

public class Control {
	private Game game;
	private HashMap<String, Virologist> virologists;
	private HashMap<String, Field> fields;
	private HashMap<String, Equipment> equipments;
	private HashMap<String, Agent> agents;
	private HashMap<String, HashMap> hashmaps;
	private static HashMap<String, String> safety;
	
	static
	{
		safety.put("chorea", "a");
		safety.put("forgettingagent", "a");
		safety.put("stun", "a");
		safety.put("protection", "a");
		safety.put("bearagent", "a");
		safety.put("axe", "e");
		safety.put("cape", "e");
		safety.put("sack", "e");
		safety.put("glove", "e");
		safety.put("field", "f");
		safety.put("laboratory", "f");
		safety.put("storage", "f");
		safety.put("shelter", "f");
	}
	
	private static InputStreamReader isr =	new InputStreamReader(System.in);
	private static BufferedReader br = new BufferedReader(isr);

	
	public Control() {
		game = new Game();
		virologists = new HashMap<String, Virologist>();
		fields = new HashMap<String, Field>();
		equipments = new HashMap<String, Equipment>();
		agents = new HashMap<String, Agent>();
		hashmaps = new HashMap<String, HashMap>();
		hashmaps.put("v", virologists);
		hashmaps.put("a", agents);
		hashmaps.put("e", equipments);
		hashmaps.put("f", fields);
		
	}
	
	public void runControl() throws IOException {
		while (true) {
			String line;
			line = br.readLine();

			if (line == null) break;
			
			runCommand(line);			
		}

	}
	
	private void runCommand(String cmdline) {
		//Ha üres sort kaptunk, ignoráljuk
		//Emiatt áttekinthetõbb bemeneteket lehet csinálni
		if (cmdline.equals("")) return;
		
		
		//Parancs részekgre tördelése
		String cmd[];
		cmd = cmdline.split(" ");
		
		
		//Parancs értelmezés, és a szükséges függvény meghívása
		if (cmd[0].equals("operator")) {			
			runOperatorCommand(cmdline);
		}
		else if (cmd[0].equals("move")) {
			spawnWorker(cmd[1],Double.parseDouble(cmd[2]),cmd[3]);
		}
		else if (cmd[0].equals("dropequipment")) {
			spawnCrate(cmd[1],cmd[2]);
		}
		else if (cmd[0].equals("cast")) {
			setSwitch(cmd[1], cmd[2]);
		}
		else if (cmd[0].equals("pickupequipment")) {
			putFluid(cmd[1], cmd[2].charAt(0));
		}
		else if (cmd[0].equals("stealequipment")) {
			step(cmd[1],cmd[2]);
		}
		else if (cmd[0].equals("list")) {
			stat(cmd[1]);
		}
		else if (cmd[0].equals("listv")) {
			script(cmd[1]);
		}
		else if (cmd[0].equals("next") && cmd[1].equals("turn")) {
			script(cmd[1]);
		}
		else 
		{
			System.out.println("unrecognized command");
		}
		
	}
	
	private void runOperatorCommand(String cmdline) {
		
		String cmd[];
		cmd = cmdline.split(" ");
		
		if (cmd[1].equals("g") && cmd[2].equals("game")) {
			if(cmd[3].equals("random"))
			{
				if(cmd[4].equals("enable"))
				{
					game.setRandomEnabled(true);
				}
				else if(cmd[4].equals("disable"))
				{
					game.setRandomEnabled(false);
				}
			}
			else if(cmd[3].equals("generatemap"))
			{
				game.generateFieldMap();
			}
			else if(cmd[3].equals("generaterandommap"))
			{
				game.generateMap();
				game.scatterObjects();
			}
		}
		else if (cmd[3].equals("create")) {
			if(getHashMap(cmd[1]) != null)
			{
				if(checkSafeName(cmd[2]))
				{
					if(cmd[1].equals("v"))
					{
						Virologist v = new Virologist();
						virologists.put(cmd[2], v);
					}
					else
					{
						if(checkSafeInheritence(cmd[4], cmd[1]))
						{
							Object o = createObject(cmd[4]);
							getHashMap(cmd[1]).put(cmd[2], o);
						}
					}
				}
			}
		}
		else if (cmd[3].equals("move")) {
			if(checkExistingObject(cmd[2]))
			{
				move(cmd);
			}
		}
		else if (cmd[3].equals("list")) {

		}
	}
	

	public void move(String[] cmd) {
		if(cmd[1].equals("v"))
		{
			if(fields.containsKey(cmd[4]))
			{
				virologists.get(cmd[2]).changeField(fields.get(cmd[4]));
				fields.get(cmd[4]).addVirologist(virologists.get(cmd[2]));
				return;
			}
		}
		else if(cmd[1].equals("e"))
		{
			if(fields.containsKey(cmd[4]))
			{
				equipments.get(cmd[2]).setCurrentField(fields.get(cmd[4]));
				fields.get(cmd[4]).spawnEquipment(equipments.get(cmd[2]));
				return;
			}
			if(virologists.containsKey(cmd[4]))
			{
				equipments.get(cmd[2]).pickupEquipment(virologists.get(cmd[4]));
				return;
			}
		}
		else if(cmd[1].equals("a"))
		{
			if(fields.containsKey(cmd[4]) && (fields.get(cmd[4]).getClass().equals(Laboratory.class)))
			{
				((Laboratory) fields.get(cmd[4])).addAgent(agents.get(cmd[2]));
				return;
			}
			if(virologists.containsKey(cmd[4]) && cmd[5].equals("learn"))
			{
				virologists.get(cmd[4]).learnAgent(agents.get(cmd[2]));
				return;
			}
			if(virologists.containsKey(cmd[4]) && cmd[5].equals("active"))
			{
				virologists.get(cmd[4]).addActiveAgent(agents.get(cmd[2]));
				return;
			}
		}
		System.out.println("Invalid move command! Check the given type and names!");
	}
	
	public boolean checkExistingObject(String name) {
		if(getObject(name) == null)
		{
			System.out.println("Invalid name! The given name does not exist!");
			return false;
		}
		return true;
	}
	
	public Object getObject(String name) {
		for (HashMap hashmap : hashmaps.values())
		{
			if(hashmap.containsKey(name))
				return hashmap.get(name);
		}
		return null;
	}
	
	public boolean checkSafeName(String input) {
		if(getObject(input) == null)
		{
			System.out.println("Invalid name! The given name is already taken, choose another one!");
			return false;
		}
		return true;
	}
	
	public boolean checkSafeInheritence(String key, String value) {
		if(safety.get(key).equals(value))
			return true;
		System.out.println("Invalid command! The given subclass is not inherited from the given class!");
		return false;
	}

	public Object createObject(String s) {
		switch(s)
		{
		case "chorea":
			return new Chorea();
		case "forgettingagent":
			return new ForgettingAgent();
		case "stun":
			return new Stun();
		case "protection":
			return new Protection();
		case "bearagent":
			return new BearAgent();
		case "axe":
			return new Axe();
		case "cape":
			return new Cape();
		case "sack":
			return new Sack();
		case "glove":
			return new Glove();
		case "field":
			return new Field();
		case "laboratory":
			return new Laboratory();
		case "storage":
			return new Storage();
		case "shelter":
			return new Shelter();
			
		}
		return null;
	}
	
	public HashMap getHashMap(String s) {
		if(hashmaps.containsKey(s))
			return hashmaps.get(s);
		return null;
	}

	
	
}
