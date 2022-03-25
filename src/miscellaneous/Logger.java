package miscellaneous;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import agents.Agent;

public class Logger {
	static private Map<Object, String> map=new HashMap<Object, String>();
	private static int depth=0;
	private static boolean enabled = false;
	
	public static void register(Object o, String name)
	{
		map.put(o, name);
	}
	
	public static void enter(Object o, String funcName, List<Object> parameters)
	{
		//not doing anything if logger disabled
		if (!enabled) return;
		
		//Intendation
		String tab="";
		for (int i=0; i<depth; i++) tab+="  ";
		depth++;
		
		//Fetching parameter list
		String param = "";
		if (parameters != null) {
			for (Object i : parameters) {
				param += ", "; //separator
			
				if (i == null)
					param += "null";
				else if (map.containsKey(i))
					param += map.get(i);
				else
					param += i.toString();
			}
		}
		if(param.length()>2) param = param.substring(2); //we had a comma and a space in the front
		
		//Logging
		System.out.println(tab+"-> " + map.get(o) + "." + funcName +"(" + param +")");
		
	}
	
	public static void exit(Object o, String funcName, Object returnValue)
	{
		//not doing anything if logger disabled
		if (!enabled) return;
		
		//Intendation
		String tab="";
		depth--;
		for (int i=0; i<depth; i++) tab+="  ";
		
		//Converting return value into string
		String retVal = "";
		if (returnValue != null) {
			if (map.containsKey(returnValue)) retVal = map.get(returnValue);
			else retVal = returnValue.toString();
		}
		
		//Logging
		System.out.println(tab+"<- " + map.get(o)+ "." + funcName+ "(" + ")" + (retVal.equals("") ? "" : ("  [" + retVal + "]")));
		
	}
	
	public static void enable() {enabled=true;}
	public static void disable() {enabled=false;}
}

/*
		ArrayList<Object> par = new ArrayList<>();
		par.add({parameters});
		Logger.enter(this, "{function_name}", par);
		
		*** function here ***
		
		Object result = {return_value};
		Logger.exit(this, "{function_name}", result);
		return result;
 */

