package hackerrank;

public class TimeConversion {

    public static void main(String[] args) {
        System.out.println("TEST: " + TimeConversion.timeConversion("07:05:45PM"));
        System.out.println("TEST: " + TimeConversion.timeConversion("12:01:00PM"));
        System.out.println("TEST: " + TimeConversion.timeConversion("12:01:00AM"));
    }

    public static String timeConversion(String s) {
        // Write your code here
        // how to add 12 to String type hour?
        String hour = s.substring(0, 2);
        String minute = s.substring(3, 5);
        String second = s.substring(6, 8);
        String incrementedHour = incrementString(hour.substring(0, 1), 1) +
                incrementString(hour.substring(1), 2);
        if (s.substring(8).equals("PM") && hour.equals("12")) {
            return hour + ":" + minute + ":" + second;
        }
        if (s.substring(8).equals("PM")) {
            return incrementedHour + ":" + minute + ":" + second;
        }
        if (s.substring(8).equals("AM") && hour.equals("12")) {
            return "00" + ":" + minute + ":" + second;
        }
        if (s.substring(8).equals("AM")) {
            return hour + ":" + minute + ":" + second;
        }
        return "false";
    }

    public static String incrementString(String s, int inc) {
        Integer sInInt = Integer.valueOf(s);
        sInInt = sInInt + inc;
        return sInInt.toString();
    }
}
