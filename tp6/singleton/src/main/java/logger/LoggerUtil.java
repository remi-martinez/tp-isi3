package main.java.logger;

public class LoggerUtil {

    public static String coloredString(CharSequence stringToColor, LoggerUtil.Color color) {
        return String.format("%s%s%s", color.getValue(), stringToColor, Color.ANSI_RESET.getValue());
    }

    public enum Color {
        ANSI_RED("\u001B[31m"),
        ANSI_BLUE("\u001B[34m"),
        ANSI_RESET("\u001B[0m");

        private String value;

        Color(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
}
