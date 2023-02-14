package bll;

import dal.IDAL;
import dal.PersonDAOStub;
import to.PersonTO;

public class PersonBO implements IBO {
	private IDAL dao;

	/*
	 * private PersonDAO dao; public PersonBO () throws SQLException { dao = new
	 * PersonDAO(); }
	 */
	public PersonBO(IDAL dao) {
		this.dao = dao;
	}
//	public PersonBO() {
//	}

	public boolean isSibling(int cnic1, int cnic2) {
		PersonTO p1 = dao.getPerson(cnic1);
		PersonTO p2 = dao.getPerson(cnic2);

		return isSameFather(p1, p2) && isSameMother(p1, p2);
	}

	public boolean isHalfSibling(int cnic1, int cnic2) {
		PersonTO p1 = dao.getPerson(cnic1);
		PersonTO p2 = dao.getPerson(cnic2);
		if((isSameFather(p1, p2) && isSameMother(p1, p2))  || (!isSameFather(p1, p2) && !isSameMother(p1, p2)))
		{
			return false;
		}
		else {
			return true;
		}
	}

	public PersonTO getPerson(String Name) {
		PersonTO obj = dao.getMatchingPerson(Name);
		return obj;
	}

	private boolean isSameMother(PersonTO p1, PersonTO p2) {
		return p1.getMother() == p2.getMother();
	}

	private boolean isSameFather(PersonTO p1, PersonTO p2) {
		return p1.getFather() == p2.getFather();
	}

}
