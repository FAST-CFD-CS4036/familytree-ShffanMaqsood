package bll;

import to.PersonTO;

public interface IBO {
	public boolean isHalfSibling (int cnic1, int cnic2);
	public boolean isSibling (int cnic1, int cnic2);
	public PersonTO getPerson(String Name);
}
