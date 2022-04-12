package org.lightdust.datagen;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;
import java.util.Objects;

public class Tools {
    public static String getEnum(List<String> list,String name) {
        String formatStr = "\n\n\nclass %s(Enum):\n%s";
        list = list.stream().map(s -> String.format("    %s = 'minecraft:%s'", s.toUpperCase().replace('.','_'), s)).toList();
        return String.format(formatStr, name, String.join("\n", list));
    }
}

class FileTool {
    static void mkdirs(String path) {
        String s = "";
        StringBuilder s2 = new StringBuilder();
        for (String p : path.split("/")) {
            if (!Objects.equals(s, "")) {
                s2.append(s).append("/");
            }
            s = p;
        }
        try {
            if (!new File(s2.toString()).mkdirs()) DataGetter.LOGGER.error("%s创建失败".formatted(s2));
        } catch (SecurityException e){
            DataGetter.LOGGER.error(e.toString());
        }
    }

    static void Write(String path, String input) {
        try {
            mkdirs(path);
            // 1、打开流
            Writer w = new FileWriter(path);
            w.write(input);
            w.close();
        } catch (IOException e) {
            System.out.println("文件写入错误：" + e.getMessage());
        }
    }
}
