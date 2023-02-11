package to;

public class PersonTO {
	public int getCnic() {
		return cnic;
	}
	public void setCnic(int cnic) {
		this.cnic = cnic;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getFather() {
		return father;
	}
	public void setFather(int father) {
		this.father = father;
	}
	public int getMother() {
		return mother;
	}
	public void setMother(int mother) {
		this.mother = mother;
	}
	public PersonTO(int cnic, String name, int father, int mother) {
		this.cnic = cnic;
		this.name = name;
		this.father = father;
		this.mother = mother;
	}
	public PersonTO() {
	}
	private int cnic;
	private String name;
	private int father;
	private int mother;
}
