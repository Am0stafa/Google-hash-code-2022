package hashcode;

import java.util.ArrayList;
import java.util.HashMap;

public class Project {
	String name;
	int duration;
	int score;
	int bestBefore;
	HashMap<String, Integer> roles;
	HashMap<Contributer,String> rolesContributers;
	HashMap<Contributer, Contributer> mentors;
	
	public Project(String name) {
		this.name = name;
		roles = new HashMap<String, Integer>();
		rolesContributers = new HashMap<Contributer,String>();
		mentors = new HashMap<Contributer, Contributer>();
		
	}
	
	

}
