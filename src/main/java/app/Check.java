package app;

import java.util.regex.Pattern;

public class Check {
    public static boolean checkPhone(String phone) {
        String regex = "^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(phone).matches();
    }

    public static boolean checkEmail(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(email).matches();
    }

    public static boolean checkPositiveInt(int number) {
        return number > 0;
    }
}
