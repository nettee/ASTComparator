package me.nettee.astcomparator;

public class Main {

    public static void main(String[] args) {
        String path = "/home/william/projects/java/query.example/src/simple/extension/Graduate.java";
        Ast ast1 = Ast.fromFile(path);
        Ast ast2 = Ast.fromFile(path);
        double similarity = ast1.similarityTo(ast2);
        System.out.println(similarity);
    }
    
}
