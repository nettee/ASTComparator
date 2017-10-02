package me.nettee.astcomparator;

import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTParser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ast {

    private final ASTNode root;
    private final int kind;

    private Ast(ASTNode root, int kind) {
        this.root = root;
        this.kind = kind;
    }

    public static Ast fromFile(String filepath) {
        try {
            String program = readFromFile(filepath);
            String source = program;
            ASTParser parser = ASTParser.newParser(AST.JLS3);
            parser.setSource(source.toCharArray());
            parser.setKind(ASTParser.K_COMPILATION_UNIT);

            ASTNode root = parser.createAST(null);
            return new Ast(root, ASTParser.K_COMPILATION_UNIT);
        } catch (IOException e) {
            throw new AssertionError(e);
        }
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

    public VectorCounter countVector() {
        VectorCounter counter = new VectorCounter();
        VectorCountVisitor visitor = new VectorCountVisitor(counter);
        root.accept(visitor);
        return counter;
    }

    public String flatten() {
        FlattenVisitor flattenVisitor = new FlattenVisitor();
        root.accept(flattenVisitor);
        return flattenVisitor.getString();
    }

    public double similarityTo(Ast that) {
        VectorSimilarityCalculator calculator = new VectorSimilarityCalculator();
        return calculator.similarity(this, that);
    }

    private interface SimilarityCalculator {
        double similarity(Ast a, Ast b);
    }

    private static class VectorSimilarityCalculator implements SimilarityCalculator {
        public double similarity(Ast a, Ast b) {
            VectorCounter v1 = a.countVector();
            VectorCounter v2 = b.countVector();
            double cosine = v1.cosine(v2);
            return cosine;
        }
    }

    private static class EditDistanceSimilarityCalculator implements  SimilarityCalculator {

        public double similarity(Ast a, Ast b) {
            String s1 = a.flatten();
            String s2 = b.flatten();
            return 0.0;
        }
    }
}
