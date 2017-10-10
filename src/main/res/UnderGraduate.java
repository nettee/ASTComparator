package simple.extension;

public class UnderGraduate extends Student {
	private int grade;

	public UnderGraduate(String name, String id, int grade) {
		super(name, id);
		this.setGrade(grade);
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

}
