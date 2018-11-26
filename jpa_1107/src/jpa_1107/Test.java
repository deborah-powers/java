package jpa_1107;

import java.util.List;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DaoUser dao = new DaoUser();
		User u = dao.get(2);
		System.out.println("premier user: " + u);
		// dao.remove(3);
		List<User> userList = dao.findAll();
		for (User user : userList)
			System.out.println(user);
		Dao.close();
	}

}
