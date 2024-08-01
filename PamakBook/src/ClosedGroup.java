import java.util.ArrayList;

public class ClosedGroup extends Group {

	public ClosedGroup(String name, String motto) 
	{
		super(name, motto);
	}
	
	//пяосхетеи ема атоло ломо ам еимаи жикос ле йапоиом апо та лекг тоу цйяоуп
	public void add_in_Group(User person)
	{
		if(GroupMembers.isEmpty())
			super.add_in_Group(person);
		else 
		{
		  for(int i = 0; i < person.getFriendsList().size(); i++)
		  {
			    if(GroupMembers.contains(person.getFriendsList().get(i)))
				  super.add_in_Group(person);   
	
			    if (!(GroupMembers.contains(person)) && i == person.getFriendsList().size()-1)
					  System.out.println("FAILED: " + person.getName() + " cannot be enrolled in group ExamSolutions");				  
		  }		 
		}
	}

	
	
}

	

