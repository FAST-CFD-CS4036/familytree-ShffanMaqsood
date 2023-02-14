package dal;

import java.util.Hashtable;

import to.PersonTO;

public class PersonDAOStub implements IDAL {
	
	private Hashtable<Integer, PersonTO> db; 
	
			
	public PersonDAOStub() {
		super();
		db = new Hashtable<Integer, PersonTO>();
		db.put(1, new PersonTO(1, "Shah Jahan", 11, 12));
		db.put(2, new PersonTO(2, "Mumtaz Mahal", 13, 14));
		db.put(3, new PersonTO(3, "Aurangzeb", 1, 2));
		db.put(4, new PersonTO(4, "Dara Shikoh", 1, 2));
		db.put(5, new PersonTO(5, "Dara Umar", 1, 3));
		db.put(6, new PersonTO(6, "Lala Umar", 4, 2));
		db.put(7, new PersonTO(7, "Lamba Umar", 5, 6));
	}

	@Override
	public PersonTO getPerson(int cnic) {
		return db.get(cnic);
	}

	@Override
	public PersonTO getMatchingPerson(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
