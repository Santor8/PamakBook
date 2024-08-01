
public class Main {

	public static void main(String[] args) {
		
		//�������� ���������
		User u1 = new User("Makis", "iis1998@uom.edu.gr");
		User u2 = new User("Petros", "ics1924@uom.edu.gr");
		User u3 = new User("Maria", "iis2012@uom.edu.gr");
		User u4 = new User("Gianna", "iis19133@uom.edu.gr");
		User u5 = new User("Nikos", "dai1758@uom.edu.gr");
		User u6 = new User("Babis", "ics19104@uom.edu.gr");
		User u7 = new User("Stella", "dai1827@uom.edu.gr");
		User u8 = new User("Eleni", "ics2086@gmail.com");
		 
		
		//�������� �����
		u1.addFriends(u2);			
		u1.addFriends(u5);			
	    u5.addFriends(u6);	
		u3.addFriends(u4);
		u3.addFriends(u2);
		u4.addFriends(u6);	
		u5.addFriends(u3);
		u1.addFriends(u6);
		u5.addFriends(u2);
		u7.addFriends(u1);
		
		//������ ��� �������� ������ �����
		u5.printcommon(u5.commonFriends(u4), u4);
		u1.printcommon(u1.commonFriends(u5), u5);
		
		//�������� ����� ������� �������
		u1.printFriends();
		u3.printFriends();
		
		Group g1 = new Group("WebGurus","A group for web passionates");
		ClosedGroup g2 = new ClosedGroup("ExamSolutions","Solutions to common exam questions");
		
		//�������� ������� �� �������
		g1.add_in_Group(u4);
		g1.add_in_Group(u3);
		g1.add_in_Group(u2);
		g2.add_in_Group(u4);
		g2.add_in_Group(u5);
		g2.add_in_Group(u6);
		g2.add_in_Group(u5);
		 
		//�������� ��� �������� ��� ������
		u4.printGroups();
		
		//�������� ����� ��� ������
	    g1.printMembers();
		g2.printMembers();
		
		//����� ������� ��� ��
		u4.Virus();
		
		//�������� ��� ������� ��� ������� � INFECTED
		u4.printInfected();
		
		
	}
}
