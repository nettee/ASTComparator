package me.nettee.astcomparator;

import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTVisitor;

import java.util.HashMap;
import java.util.Map;

public class VectorCountVisitor extends ASTVisitor {

    private final VectorCounter counter;

    public VectorCountVisitor(VectorCounter counter) {
        this.counter = counter;
    }

    @Override
    public void preVisit(ASTNode node) {
        String classname = node.getClass().getSimpleName();
        counter.add(classname);
    }

}
