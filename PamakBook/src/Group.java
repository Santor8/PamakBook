import java.util.ArrayList;

public class Group {
	
	private String Name;
	private String Motto;
	protected ArrayList<User> GroupMembers;
	 
	public Group(String name, String motto)
	{
		Name = name;
		Motto = motto;
		GroupMembers = new ArrayList<User>();
		
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		if ( name.length() > 0)
			Name = name;
		else
			System.out.println("Not a valid name");
	}

	public String getMotto() {
		return Motto;
	}

	public void setMotto(String motto) {
		Motto = motto;
	}
	
	public ArrayList<User> getGroupMembers() {
		return GroupMembers;
	}
	
	public void setGroupMembers(ArrayList<User> groupMembers) {
		GroupMembers = groupMembers;
	}
	
	//‘”≈ ¡—≈… ¡Õ œ ◊—«”‘«” ¡Õ« ≈… ”‘œ √ —œ’–
	public boolean is_in_Group(User person)
	{
		for(int i = 0; i < GroupMembers.size(); i++)
		{
			  if(person.equals(GroupMembers.get(i))) 
			     return true;	
		}	
		return false;
	}

	//–—œ”»≈‘≈… ≈Õ¡ ◊—«”‘« ”‘œ √ —œ’–
	public void add_in_Group(User person)
	{
		if(!(GroupMembers.contains(person))) 
		{
			GroupMembers.add(person);
			person.getMembers().add(this);
			System.out.println(person.getName() + " has been successfully enrolled in group " + Name);
		}
		
	}
	
	//≈ ‘’–ŸÕ≈… ‘¡ Ã≈À« ‘œ’ √ —œ’–
	public void printMembers()
	{
		System.out.println("************************");
	    System.out.println("Members of group " + Name);
		System.out.println("************************");
		for(int i = 0; i < GroupMembers.size(); i++)
	    {  	
		 System.out.println(i+1 + ": " + GroupMembers.get(i).getName());
		}
		System.out.println("------------------------");
		
	}


	
}
