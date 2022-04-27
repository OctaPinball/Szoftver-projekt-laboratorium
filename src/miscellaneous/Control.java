package miscellaneous;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import agents.*;
import equipment.*;
import field.*;

public class Control {
	private static HashMap<String, Virologist> virologists;
	private static HashMap<String, Field> fields;
	private static HashMap<String, Equipment> equipments;
	private static HashMap<String, Agent> agents;
	private static HashMap<String, HashMap> hashmaps;
	private static HashMap<String, String> safety = new HashMap<String, String>();
	
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
	
	static
	{
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
	
	private static InputStreamReader isr =	new InputStreamReader(System.in);
	private static BufferedReader br = new BufferedReader(isr);
	
	public static Equipment getEquipment(HashMap<String, Equipment> inhashmap) throws IOException {
		String line;
		line = br.readLine();
		if(inhashmap.containsKey(line))
		{
			return inhashmap.get(line);
		}
		return null;
	}

	public static boolean getBoolean() throws IOException {
		String line;
		line = br.readLine();
		if(line.equals("true"))
			return true;
		if(line.equals("false"))
			return false;
		return false;
	}
	
	public static Field getField(ArrayList<Field> cfields) throws IOException {
		String line;
		line = br.readLine();
		for(Field f : cfields)
		{
			if(getKey(fields, f).equals(line))
			{
				return f;
			}
		}
		return null;
	}
	
	public static void runControl() throws IOException, CloneNotSupportedException {
		while (true) {
			String line;
			line = br.readLine();

			if (line == null) break;
			
			runCommand(line);			
		}

	}
	
	private static void runCommand(String cmdline) throws CloneNotSupportedException, IOException {
		//Ha üres sort kaptunk, ignoráljuk
		//Emiatt áttekinthetõbb bemeneteket lehet csinálni
		if (cmdline.equals("")) return;
		
		
		//Parancs részekgre tördelése
		String cmd[];
		cmd = cmdline.split(" ");
		
		if(RoundManager.getEntity() == null)
		{
			RoundManager.nextRound();
		}
		
		//Parancs értelmezés, és a szükséges függvény meghívása
		if (cmd[0].equals("operator")) {			
			runOperatorCommand(cmdline);
		}
		else if (cmd[0].equals("move")) {
			if(fields.containsKey(cmd[1]))
			{
				if(!RoundManager.getEntity().getMovement().move(RoundManager.getEntity(), fields.get(cmd[1])))
				{
					System.out.println("Invalid target field name!\n");
				}
			}
			else
			{
				System.out.println("Invalid field name!\n");
			}
		}
		else if (cmd[0].equals("dropequipment")) {
			if(equipments.containsKey(cmd[1]))
			{
				if(RoundManager.getEntity().getEquipments().contains(equipments.get(cmd[1])))
				{
					equipments.get(cmd[1]).dropEquipment();
				}
				else
				{
					System.out.println("Equipment not found in the inventory of the virologist!\n");
				}
			}
			else
			{
				System.out.println("Invalid equipment name!\n");
			}
		}
		else if (cmd[0].equals("cast")) {
			if(RoundManager.getEntity() != null && RoundManager.getEntity().getField() != null)
			{
				ArrayList<Field> neighbors = RoundManager.getEntity().getField().getNeighbors();			
			if(virologists.get(cmd[1]) != null)
			{
				Virologist target = virologists.get(cmd[1]);
				if(neighbors.contains(target.getField()))
				{
					if(agents.containsKey(cmd[2]) && RoundManager.getEntity().getAgents().contains(agents.get(cmd[2])))
					{
						agents.get(cmd[2]).cast(target);
					}
					else
					{
						System.out.println("Invalid agent name!\n");
					}
				}
				else
				{
					System.out.println("Invalid target name!\n");
				}
			}
			else
			{
				System.out.println("Invalid target name!\n");
			}
		}
		}
		else if (cmd[0].equals("pickupequipment")) {
			if(equipments.containsKey(cmd[1]) && RoundManager.getEntity().getField().getEquipment().equals(equipments.get(cmd[1])))
			{
				equipments.get(cmd[1]).pickupEquipment(RoundManager.getEntity());
			}
			else
			{
				System.out.println("Invalid equipment name or the field doesn't possess the equipment!\n");
			}
		}
		else if (cmd[0].equals("stealequipment")) {
			if(virologists.containsKey(cmd[1]))
			{
				Virologist target = virologists.get(cmd[1]);
				if(equipments.containsKey(cmd[2]) && target.getEquipments().contains(equipments.get(cmd[2])))
				{
					if(!RoundManager.getEntity().stealEquipment(equipments.get(cmd[2]), target))
					{
						System.out.println("Equipment stealing failed!\n");
					}
				}
				else
				{
					System.out.println("Invalid equipment name or the target doesn't possess the equipment!\n");
				}
			}
			else
			{
				System.out.println("Invalid target name!\n");
			}
		}
		else if (cmd[0].equals("list")) {
			if(cmd[1] == null)
			{
				RoundManager.getEntity().list(null);
			}
			else
			{
				RoundManager.getEntity().list(cmd[1]);
			}
		}
		else if (cmd[0].equals("listv")) {
			if(virologists.containsKey(cmd[1]))
			{
				virologists.get(cmd[1]).listV();
			}
			else
			{
				System.out.println("Invalid virologist name!\n");
			}
		}
		else if (cmd[0].equals("next") && cmd[1].equals("turn"))
		{
			RoundManager.nextRound();
		}
		else 
		{
			System.out.println("Unrecognized command!\n");
		}
		
	}
	

	
	private static void runOperatorCommand(String cmdline) {
		
		String cmd[];
		cmd = cmdline.split(" ");
		
		if (cmd[1].equals("g") && cmd[2].equals("game"))
		{
			if(cmd[3].equals("random"))
			{
				if(cmd[4].equals("enable"))
				{
					Game.setRandomEnabled(true);
				}
				else if(cmd[4].equals("disable"))
				{
					Game.setRandomEnabled(false);
				}
			}
			else if(cmd[3].equals("generatemap"))
			{
				String[] xy;
				xy = cmd[4].split("x");
				int x = Integer.parseInt(xy[0]);
				int y = Integer.parseInt(xy[1]);
				Game.generateFieldMap(x,y);
			}
			else if(cmd[3].equals("generaterandommap"))
			{
				String[] xy;
				xy = cmd[4].split("x");
				int x = Integer.parseInt(xy[0]);
				int y = Integer.parseInt(xy[1]);
				Game.generateMap(x,y);
				Game.scatterObjects();
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
						RoundManager.addEntity(v);
					}
					else
					{
						if(cmd.length < 5)
						{
							Object o = createObject(cmd[1]);
							getHashMap(cmd[1]).put(cmd[2], o);
						}
						else if(cmd.length >= 5 && checkSafeInheritence(cmd[4], cmd[1]))
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
		else if (cmd[3].equals("list") || cmd[2].equals("list") )
		{
			if(checkExistingObject(cmd[2]))
			{
				if(cmd[2].equals("list"))
				{
					if(getHashMap(cmd[1]) == null && !cmd[1].equals("all"))
					{
						System.out.println("Invalid type name!\n");
						return;
					}
					else
					{
						if(cmd[3].equals("normal"))
						{
							if(cmd[1].equals("all"))
							{
								for(String s : (String[])virologists.keySet().toArray())
								{
									System.out.println(s + "\n");
								}
								for(String s : (String[])agents.keySet().toArray())
								{
									System.out.println(s + "\n");
								}
								for(String s : (String[])equipments.keySet().toArray())
								{
									System.out.println(s + "\n");
								}
								for(String s : (String[])fields.keySet().toArray())
								{
									System.out.println(s + "\n");
								}
							}
							
							else
							{
								for(String s : (String[])getHashMap(cmd[1]).keySet().toArray())
								{
									System.out.println(s + "\n");
								}
							}
						}
						else if(cmd[3].equals("detailed"))
						{
							System.out.println(cmd[2] + "\n");
							for(Object o : virologists.values().toArray())
							{
								System.out.println(o.toString() + "\n");
							}
							for(Object o : agents.values().toArray())
							{
								System.out.println(o.toString() + "\n");
							}
							for(Object o : equipments.values().toArray())
							{
								System.out.println(o.toString() + "\n");
							}
							for(Object o : fields.values().toArray())
							{
								System.out.println(o.toString() + "\n");
							}
						}
						
						else
						{
							System.out.println(cmd[2] + "\n");
							for(Object o : getHashMap(cmd[1]).values().toArray())
							{
								System.out.println(o.toString() + "\n");
							}
						}
					}
						
				}
			}
			else if(cmd[3].equals("list"))
			{
				if(getHashMap(cmd[1]) == null || getHashMap(cmd[1]).get(cmd[2]) == null)
				{
					System.out.println("Invalid type or name!\n");
				}
				else
				{
					System.out.println(getHashMap(cmd[1]).get(cmd[2]).toString() + "\n");
				}
			}
		}
		else if (cmd[3].equals("removeneighbor") && cmd[1].equals("f")) {
			if(fields.containsKey(cmd[2]))
			{
				Field f1 = fields.get(cmd[2]);
				Field f2 = fields.get(cmd[4]);
				if(!f1.removeNeighbor(f2) || !f2.removeNeighbor(f1))
				{
					System.out.println("Invalid field name! The given fields are not neighbours!\n");
				}
			}
		}
		else if (cmd[3].equals("fillmaterial") && cmd[1].equals("v")) {
			if(virologists.containsKey(cmd[2]))
			{
				Virologist v = virologists.get(cmd[2]);
				v.getFillMaterial().fillMaterial(v);
			}
		}
	}
	

	public static void move(String[] cmd) {
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
			if(cmd.length >= 6 && virologists.containsKey(cmd[4]) && cmd[5].equals("learn"))
			{
				virologists.get(cmd[4]).learnAgent(agents.get(cmd[2]));
				return;
			}
			if(cmd.length >= 6 && virologists.containsKey(cmd[4]) && cmd[5].equals("active"))
			{
				virologists.get(cmd[4]).addActiveAgent(agents.get(cmd[2]));
				return;
			}
		}
		else if(cmd[1].equals("f"))
		{
			if(fields.containsKey(cmd[2]) && fields.containsKey(cmd[2]))
			{
				fields.get(cmd[2]).addNeighbor(fields.get(cmd[4]));
				fields.get(cmd[4]).addNeighbor(fields.get(cmd[2]));
				return;
			}
		}
		System.out.println("Invalid move command! Check the given type and names!\n");
	}
	
	public static boolean checkExistingObject(String name) {
		if(getObject(name) == null)
		{
			System.out.println("Invalid name! The given name does not exist!\n");
			return false;
		}
		return true;
	}
	
	public static Object getObject(String name) {
		for (HashMap hashmap : hashmaps.values())
		{
			if(hashmap.containsKey(name))
				return hashmap.get(name);
		}
		return null;
	}
	
	public static boolean checkSafeName(String input) {
		if(getObject(input) != null)
		{
			System.out.println("Invalid name! The given name is already taken, choose another one!\n");
			return false;
		}
		return true;
	}
	
	public static boolean checkSafeInheritence(String key, String value) {
		if(safety.get(key).equals(value))
			return true;
		System.out.println("Invalid command! The given subclass is not inherited from the given class!\n");
		return false;
	}

	public static Object createObject(String s) {
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
			return new Field(0);
		case "laboratory":
			return new Laboratory(0);
		case "storage":
			return new Storage(0);
		case "shelter":
			return new Shelter(0);
		case "v":
			return new Virologist();
		case "f":
			return new Field(0);
		}
		return null;
	}
	
	public static HashMap getHashMap(String s) {
		if(hashmaps.containsKey(s))
			return hashmaps.get(s);
		return null;
	}
	
	public static String getName(Object o) {
		if(o == null)
			return "";
		for (HashMap hashmap : hashmaps.values())
		{
			if(hashmap.containsValue(o))
			{
				return (String)getKey(hashmap, o);
			}
		}
		return "";
	}
	
	//code copied from StackOverFlow
	public static <K, V> K getKey(Map<K, V> map, V value) {
	    for (Entry<K, V> entry : map.entrySet()) {
	        if (entry.getValue().equals(value)) {
	            return entry.getKey();
	        }
	    }
	    return null;
	}

	
	
}
