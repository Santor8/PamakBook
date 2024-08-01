import java.util.ArrayList;

public class User {
	
	private String Name;
	private String Email;
    private ArrayList<User> FriendsList; 
    private ArrayList<Group> Members;
    private ArrayList<User> comFriends;
    private ArrayList<User> vir;


	public User(String name, String email )
	{
		Name = name;
		Email = email;
		
		if((email.startsWith("ics") && email.endsWith("@uom.edu.gr" ) && LessThan5NumbersInString(email) && MoreThan2NumbersInString(email))|| 
		  ((email.startsWith("iis")) && email.endsWith("@uom.edu.gr") && LessThan5NumbersInString(email) && MoreThan2NumbersInString(email))||
		  ((email.startsWith("dai")) && email.endsWith("@uom.edu.gr") && LessThan5NumbersInString(email) && MoreThan2NumbersInString(email)))
			
			Email = email;
		else
			System.out.println("User " + Name + " has not been created.Email format is not accetable.");
		
		FriendsList = new ArrayList<User>();
		Members = new ArrayList<Group>();
		comFriends = new ArrayList<User>();
		vir = new ArrayList<User>();
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

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;	
	}
	
	public ArrayList<User> getFriendsList() {
		return FriendsList;
	}

	public void setFriendsList(ArrayList<User> friendsList) {
		FriendsList = friendsList;
	}
	
	public ArrayList<Group> getMembers() {
		return Members;
	}


	public void setMembers(ArrayList<Group> members) {
		Members = members;
	}
	
	public ArrayList<User> getComFriends() {
		return comFriends;
	}


	public void setComFriends(ArrayList<User> comFriends) {
		this.comFriends = comFriends;
	}

	public ArrayList<User> getVir() {
		return vir;
	}



	public void setVir(ArrayList<User> vir) {
		this.vir = vir;
	}


	//�������� �� 2 ������� ����� �����
	public boolean areFriends( User friend )
	{  
		for(int i = 0; i < FriendsList.size(); i++)
	    {
		  if(friend.equals(FriendsList.get(i))) 
			 return true;	
	    }
		return false;
	}
	
	//���������� ��� �����
	public void addFriends( User friend)
	{  
	   if ( !(FriendsList.contains(friend)) && (friend.getName() != Name ) )
	   {   
		 FriendsList.add(friend);
		 friend.getFriendsList().add(this);
		 System.out.println( Name + " and " + FriendsList.get(FriendsList.size() -1).getName() + " are now friends!");
	   }
	   else
		 System.out.println("This friend is already existing or it's the same person");
	}
    
	//���������� ��� ����� �� ���� ������� ������ 2 ������
	public ArrayList<User> commonFriends(User friend)
	{		
		
		
		for(int i = 0; i < friend.getFriendsList().size(); i++ )
		{
			if(FriendsList.contains(friend.getFriendsList().get(i)))
		       comFriends.add(friend.getFriendsList().get(i));
		}
		return comFriends;
	}
	
	//��������� ��� ������� ������ 2 ������
	public void printcommon(ArrayList<User>  com, User friend)
	{
		    System.out.println("************************");
		    System.out.println("Common friends of " + Name + " and " + friend.getName());
			System.out.println("************************");
			
			int count = 1;
			for(int i = 0; i < com.size(); i++)
			{
				System.out.println(count + ": " + com.get(i).getName());
			}
			 System.out.println("------------------------");
	}
	
	//��������� ���� ������ ���� ������
	public void printFriends()
	{ 
	   System.out.println("************************");
	   System.out.println("Friends of " + Name);
	   System.out.println("************************");
	   for(int i = 0; i < FriendsList.size(); i++)
	   {  	
		 System.out.println(i+1 + ": " + FriendsList.get(i).getName());
	   }
	   System.out.println("------------------------");

	}
	
	//��������� �� ������ ��� ����� ����� ������� ��� �����
	public void printGroups()
	{
		 System.out.println("************************");
		 System.out.println("Groups that " +Name + " has been enrolled in");
		 System.out.println("************************");
		  
		 for(int i = 0; i < FriendsList.size(); i++)
		   {  	
			 System.out.println(i+1 + ": " + Members.get(i).getName());
		   }
		 System.out.println("------------------------");
	 	 
	}
	
	//���������� ��� ����� �� �� ����� ��� ���� �� ����� � ����������
	public ArrayList<User> Virus()
	{		
		for(User u1 : FriendsList)
		{
			vir.add(u1);
			for(User u2 : u1.getFriendsList())
			{
				if((!vir.contains(u2)) && (u2 != this)) 
					vir.add(u2);
							
			}			
		}
		return vir ;
	}
	
	//��������� �� ����� ��� ���������� ��� ��� ��
	public void printInfected()
	{
		System.out.println("************************");
	    System.out.println( Name + " has been infected. The following users has to be tested");
	    System.out.println("************************");
		  
		 for(int i = 0; i < vir.size(); i++)
		 {
			 System.out.println(vir.get(i).getName());
		 }
	}
	
	
	//������� �� �������� �������� ��� 5 ������� �� ��� �������������
	public static boolean LessThan5NumbersInString(String string) {
	    int numberOfNumbers = 0;
	    for (int i = 0; i < string.length(); i++) {
	        if (Character.isDigit(string.charAt(i))) {
	            numberOfNumbers++;
	            if (numberOfNumbers > 5) {
	                return false;
	            }
	        }
	    }
	    return true;
	}
	
	//������� �� �������� �������� ��� 2 ������� �� ��� �������������
	public static boolean MoreThan2NumbersInString(String string) {
	    int numberOfNumbers = 0;
	    for (int i = 0; i < string.length(); i++) {
	        if (Character.isDigit(string.charAt(i))) {
	            numberOfNumbers++;
	            if (numberOfNumbers > 2) {
	                return true;
	            }
	        }
	    }
	    return false;
	}

			
}	

		
	

