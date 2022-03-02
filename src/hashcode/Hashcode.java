package hashcode;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

public class Hashcode {
	
	static ArrayList<Contributer> availableContributers = new ArrayList();
	static ArrayList<Project> availableProjects= new ArrayList();
	
	public static void main(String[] args) throws IOException {
		
		try {
			readFromFile("src/a_an_example.in.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int i = 0; i < availableProjects.size(); i++) {
			setContributers();
		}
		
		result();
		
	}
	
	static void result() throws IOException {

		FileWriter myWriter = new FileWriter("src/output.txt");
		 myWriter.write(availableProjects.size());
		 for (int i =0; i < availableProjects.size(); i++) {
			 myWriter.write(availableProjects.get(i).name);
			 Set<Contributer> stringSet = availableProjects.get(i).rolesContributers.keySet();
			 Contributer[] cont = (Contributer[]) stringSet.toArray();
			 for (int y = 0; y < cont.length; y++) {
				 myWriter.write(cont[y].name);
			 }
		 }
	}
	
	
	static void setContributers() {
		Project currentProject = availableProjects.get(0);
		Set<String> stringSet = currentProject.roles.keySet();
		
		String[] Roles = (String[]) stringSet.toArray();
		String currentRole = Roles[0];
		
		int skillLevel = currentProject.roles.get(currentRole);
		
		for (int i = 0; i < availableContributers.size(); i++) {
			Contributer test = availableContributers.get(i);
			Contributer test1 = availableContributers.get(i);
			if(test.skills.containsKey(currentRole)){
				if(test.skills.get(currentRole) >= skillLevel) {
					currentProject.rolesContributers.put(test, currentRole);
				}
				else if(test1.skills.get(currentRole) == skillLevel - 1 || skillLevel == 1) {
					
					if(test.skills.get(currentRole) >= skillLevel) {
						currentProject.mentors.put(test, test1);
						currentProject.rolesContributers.put(test1, currentRole);
					}
					
				}
				
				
				
				
			}
		}
		
		
	
       }
		
		
	
	static void readFromFile(String filePath) throws FileNotFoundException {
		int no_of_contributers = 0;
		int no_of_projects= 0;
	    StringBuilder sb = new StringBuilder();

		BufferedReader br = new BufferedReader(new FileReader(filePath));
		try {
		    String line = null;
			try {
				line = br.readLine();
				String [] newArr = line.split(" ");
				no_of_contributers=Integer.parseInt(newArr[0]);
				
				no_of_projects=Integer.parseInt(newArr[1]);
			
				//System.out.println(no_of_contributers);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		    while (line != null) {
		        sb.append(line);
		        sb.append(System.lineSeparator());
		        
		        for( int j = 0; j < no_of_contributers; j++) {
		        
					try {
						line = br.readLine();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					String [] newArr = line.split(" ");
					Contributer temp = new Contributer(newArr[0]);
					for(int i = 0; i < Integer.parseInt(newArr[1]); i++) {
						try {
							line = br.readLine();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						 newArr = line.split(" ");
						
						 temp.skills.put(newArr[0], (int) Integer.parseInt(newArr[1]));
						 
							}
					availableContributers.add(temp);
		        }

		    
		        for( int y = 0; y < no_of_projects; y++) {
			        
			        try {
						line = br.readLine();
						String[] newArr = line.split(" ");
						if(newArr.length>2) {
						Project tempProject = new Project(newArr[0]);
						tempProject.duration = Integer.parseInt(newArr[1]);
				
						tempProject.score = Integer.parseInt(newArr[2]);
						tempProject.bestBefore = Integer.parseInt(newArr[3]);
						for(int i = 0; i < Integer.parseInt(newArr[4]); i++) {
							line = br.readLine();
							 newArr = line.split(" ");
							 tempProject.roles.put(newArr[0], Integer.parseInt(newArr[1]));
						}
						
						
						availableProjects.add(tempProject);
			        }
			        }
		        
		        	
		    catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			        
		    
		        finally {
		            // ... cleanup that will execute whether or not an error occurred ...
		        }
		        }
		    }}
		 
		   
		   
		finally {
		    String everything = sb.toString();
		}
		    try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
		    
		}
	}

