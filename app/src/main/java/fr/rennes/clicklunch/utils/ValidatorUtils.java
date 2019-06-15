/*************************************
 * Author: Dereck Daniel <daniel.dereck@gmail.com>
 * Date: 10/06/2019
 *************************************/
package fr.rennes.clicklunch.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatorUtils {

    public static final String EMAIL_REGEX = "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
            + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
            + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
            + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
            + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
            + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$";

    public static final String  NAME_REGEX = "/^[a-zA-ZÀ-ÿ0-9@']+( [a-zA-ZÀ-ÿ0-9-:\\-'\",@()!?]+)*$/mg";

    public static final String  PHONE_REGEX = "/(0|\\+33|0033)[1-9][0-9]{8}/";

    public static boolean isEmailValid(String str) {
        return ValidatorUtils.isValid(str, EMAIL_REGEX);
    }

    public static boolean isNameValid(String str) {
        return ValidatorUtils.isValid(str, NAME_REGEX);
    }

    public static boolean isPhoneValid(String str) {
        return ValidatorUtils.isValid(str, PHONE_REGEX);
    }

    /**
     * Check string with regex
     * @param str to check
     * @param regex regex
     * @return true if match regex
     */
    public static boolean isValid(String str, String regex) {
        boolean result = false;

        CharSequence inputStr = str;
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);

        if (matcher.matches()) {
            result = true;
        }

        return result;
    }
}
