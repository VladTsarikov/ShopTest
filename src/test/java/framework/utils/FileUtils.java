package framework.utils;

import framework.enums.LogType;
import java.io.*;
import java.nio.file.FileSystems;

public class FileUtils {

    public static String readFromFile(String filePath){
        StringBuilder stringBuilder = new StringBuilder();
        try(BufferedReader br = new BufferedReader(new FileReader(getAbsolutePath(filePath)))) {
            String line = br.readLine();
            while (line != null) {
                stringBuilder.append(line).append(System.lineSeparator());
                line = br.readLine();
            }
        } catch (IOException e) {
            Logger.log(LogType.ERROR,String.format("File with path '%s' has not found!", filePath));
        }
        return stringBuilder.toString();
    }

    private static String getAbsolutePath(String filePath){
        return FileSystems.getDefault().getPath(filePath).normalize().toAbsolutePath().toString();
    }
}