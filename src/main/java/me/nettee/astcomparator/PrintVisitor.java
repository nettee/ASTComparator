package me.nettee.astcomparator;

import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTVisitor;

public class PrintVisitor extends ASTVisitor {

    @Override
    public void preVisit(ASTNode node) {
        String classname = node.getClass().getSimpleName();

    }

}
