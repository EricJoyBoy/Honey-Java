package controlFlowStatements;


class Test {
    enum Day {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }

    public String calculate(Day d) {
        return switch (d) {
            case SATURDAY, SUNDAY -> "week-end";
                default -> {
                    int remainingWorkDays = 5 - d.ordinal();
                    String remainingWork = Integer.toString(remainingWorkDays);
                    yield remainingWork;
                }
            };
    }
    public static void main(String[] args) {
        Test t = new Test();
        System.out.println(t.calculate(Day.MONDAY));
        System.out.println(t.calculate(Day.TUESDAY));
        System.out.println(t.calculate(Day.WEDNESDAY));
        System.out.println(t.calculate(Day.THURSDAY));
        System.out.println(t.calculate(Day.FRIDAY));
        System.out.println(t.calculate(Day.SATURDAY));
        System.out.println(t.calculate(Day.SUNDAY));
    }
}
