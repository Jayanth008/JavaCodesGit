package enums;

public class MainMethos {

	public static void main(String[] args) {
		DaysOfWeek day = DaysOfWeek.MONDAY;
		switch (day) {
		case FRIDAY: System.out.println();
			break;
		case MONDAY:System.out.println();
			break;
		case SATURDAY:System.out.println();
			break;
		case SUNDAY:System.out.println();
			break;
		case THURSDAY:System.out.println();
			break;
		case TUESDAY:System.out.println();
			break;
		case WEDNESDAY:System.out.println();
			break;
		default:
			break;

		}

		for (DaysOfWeek myDay : DaysOfWeek.values()) {
			System.err.println(myDay);
		}
		DaysOfWeek valueOf = DaysOfWeek.valueOf("MONDAY");
		System.out.println(valueOf);
	}

}
