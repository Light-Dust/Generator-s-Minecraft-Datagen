package org.lightdust.datagen;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class tools {

    public static String escape(int N, String s) {
        // 这个额外套了一层
        return String.join("", Collections.nCopies((1 << N + 1) - 1, "\\")) + s;
    }

    public static String getEnum(List<String> list,String name) {
        String formatStr = "enum %s{\n%s}";
        list = list.stream().map(s -> String.format("    %s = 'minecraft:%s'", s.toUpperCase(), s)).toList();
        return String.format(formatStr, name, String.join(",\n", list));
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
        new File(s2.toString()).mkdirs();
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
