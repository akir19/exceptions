package Lesson_2.enums;

public class DayOfWeekMain {
    public enum DayOfWeek {MONDAY, TUESDAY, WEDNESDAY,THURSDAY, FRIDAY, SATURDAY, SUNDAY}

    public static void main(String[] args) {
        System.out.println(getWorkingHours(DayOfWeek.MONDAY));
    }

    private static int getWorkingHours(DayOfWeek day) {
        int hours;
        if ((day == DayOfWeek.SATURDAY) || (day == DayOfWeek.SUNDAY)) return 0;
        return (DayOfWeek.values().length - day.ordinal()) * 8 - 16;
    }
}
