package me.nettee.astcomparator;

import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTParser;

public class AstParser {

    public static void parseStatement(String source) {
        ASTParser parser = ASTParser.newParser(AST.JLS3);
        parser.setSource(source.toCharArray());
        parser.setKind(ASTParser.K_STATEMENTS);

        ASTNode root = parser.createAST(null);
    }

    public static void main(String[] args) {
        String s = "int a = 1";
        parseStatement(s);
    }
}
