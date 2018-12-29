package framework.utils;

public class StringExtension {

    public static String deleteAllSpaces(String string){
        String regEx = "\\s";
        String replacement = "";
        return string.replaceAll(regEx,replacement);
    }
}