package me.nettee.astcomparator;

import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTParser;

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

    public static void main(String[] args) {
        String s = "int a = 1";
        parseStatements(s);
    }
}
