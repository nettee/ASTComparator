package me.nettee.astcomparator;

import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTParser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AstParser {

    public static ASTNode parse(String source, int kind) {
        ASTParser parser = ASTParser.newParser(AST.JLS3);
        parser.setSource(source.toCharArray());
        parser.setKind(ASTParser.K_STATEMENTS);

        ASTNode root = parser.createAST(null);
        return root;
    }

    public static void parseCompilationUnit(String source) {
        parse(source, ASTParser.K_COMPILATION_UNIT);
    }

    public static void parseStatements(String source) {
        parse(source, ASTParser.K_STATEMENTS);
    }

    public static void parseExpression(String source) {
        parse(source, ASTParser.K_EXPRESSION);
    }

    private static String readFromFile(String path) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(path));
        StringBuilder sb = new StringBuilder();
        String ls = System.getProperty("line.separator");
        while (true) {
            String line = in.readLine();
            if (line == null) {
                break;
            }
            sb.append(line);
            sb.append(ls);
        }
        in.close();
        return sb.toString();
    }

    public static void main(String[] args) {
        String path = "/home/william/projects/java/query.example/src/simple/extension/Graduate.java";
        String program = null;
        try {
            program = readFromFile(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        parseCompilationUnit(program);
    }
}
