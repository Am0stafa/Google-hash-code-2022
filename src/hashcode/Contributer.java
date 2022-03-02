package hashcode;

import java.util.HashMap;

public class Contributer {
	
	String name;
	HashMap<String, Integer> skills;
	
	public Contributer(String name) {
		this.name=name;
		skills = new HashMap<String, Integer>();
	}
	

}
