package framework.utils;

import java.util.regex.*;

public class RegExpFinder {

    public static String findByRegularExp(String string, String regExp){
        int groupNumber = 1;
        String result = "";
        Pattern pattern = Pattern.compile(regExp);
        Matcher matcher = pattern.matcher(string);
        Logger.log("Finding matches...");
        if(matcher.find()){
            result = matcher.group(groupNumber);
            Logger.log("Matches has found");
        }
        return result;
    }
}