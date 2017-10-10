package simple.extension;

public class Student extends Person {

	private String sId;

	public Student(String name, String id) {
		super(name);
		setsId(id);
	}

	public String getsId() {
		return sId;
	}

	public void setsId(String sId) {
		this.sId = sId;
	}

}
