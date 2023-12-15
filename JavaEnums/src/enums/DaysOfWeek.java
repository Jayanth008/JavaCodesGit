package enums;

public enum DaysOfWeek {
	MONDAY("Mon"), TUESDAY("Tues"), WEDNESDAY("Wed"), THURSDAY("Thur"), FRIDAY("Fri"), SATURDAY("Sat"), SUNDAY("Sun");

	private final String abrivation;

	private DaysOfWeek(String abrivation) {
		this.abrivation = abrivation;
	}

	public String getAbrivation() {
		return abrivation;
	}

}
