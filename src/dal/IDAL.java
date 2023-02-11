package dal;

import to.PersonTO;

public interface IDAL {
	public PersonTO getPerson(int cnic);
	public PersonTO getMatchingPerson(String name);
}
