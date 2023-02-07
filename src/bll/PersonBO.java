package bll;

import java.sql.SQLException;

import dal.PersonDAO;
import to.PersonTO;

public class PersonBO {
	private PersonDAO dao;
	
	public PersonBO () throws SQLException {
		dao = new PersonDAO();
	}
	public PersonBO(PersonDAO dao) {
		this.dao = dao;
	}

	public boolean isSibling (int cnic1, int cnic2) {
		PersonTO p1 = dao.getPerson(cnic1);
		PersonTO p2 = dao.getPerson(cnic2);
		
		return isSameFather(p1, p2) && isSameMother(p1, p2);
	}

	
	
	public boolean isHalfSibling (int cnic1, int cnic2) {
		PersonTO p1 = dao.getPerson(cnic1);
		PersonTO p2 = dao.getPerson(cnic2);
		
		return isSameFather(p1, p2) || isSameMother(p1, p2);
	}
	
	
	public PersonTO getPerson(String Name)
	{
		PersonTO obj = dao.getPersonDetails(Name);
		return obj;
	}
	
	private boolean isSameMother(PersonTO p1, PersonTO p2) {
		return p1.getMother() == p2.getMother();
	}
	private boolean isSameFather(PersonTO p1, PersonTO p2) {
		return p1.getFather() == p2.getFather();
	}

	
}
