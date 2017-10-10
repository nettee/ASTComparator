package me.nettee.astcomparator;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main {

    private static double getSimilarity(String path1, String path2) {
        Ast ast1 = Ast.fromFile(path1);
        Ast ast2 = Ast.fromFile(path2);
        double similarity = ast1.similarityTo(ast2);
        return similarity;
    }

    public static void main(String[] args) {
        for (Map.Entry<String, String> e1 : PATHS.entrySet()) {
            String key1 = e1.getKey();
            String path1 = e1.getValue();
            for (Map.Entry<String, String> e2 : PATHS.entrySet()) {
                String key2 = e2.getKey();
                String path2 = e2.getValue();
                double similarity = getSimilarity(path1, path2);
                System.out.printf("%s <-> %s: %.3f\n", key1, key2, similarity);
            }
        }
    }

    public static final HashMap<String, String> PATHS = new HashMap<String, String>() {
        {
            put("person", "/home/william/projects/java/astcomparator/src/main/res/Person.java");
            put("student", "/home/william/projects/java/astcomparator/src/main/res/Student.java");
            put("undergraduate", "/home/william/projects/java/astcomparator/src/main/res/UnderGraduate.java");
            put("graduate", "/home/william/projects/java/astcomparator/src/main/res/Graduate.java");
        }
    };
}
