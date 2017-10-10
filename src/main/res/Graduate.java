package simple.extension;

public class Graduate extends Student {
	private String tutor;

	public Graduate(String name, String id, String tutor) {
		super(name, id);
		this.setTutor(tutor);
	}

	public String getTutor() {
		return tutor;
	}

	public void setTutor(String tutor) {
		this.tutor = tutor;
	}

}
