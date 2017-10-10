package me.nettee.astcomparator;

import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.StructuralPropertyDescriptor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Flatten the AST to a string.
 */
public class FlattenVisitor extends ASTVisitor {

    private final StringBuilder sb;

    private ASTNode lastNode;

    public FlattenVisitor() {
        sb = new StringBuilder();
        lastNode = null;
    }

    @Override
    public void preVisit(ASTNode node) {
        if (hasChildren(node)) {
            sb.append("[");
        }
        String classname = node.getClass().getSimpleName();
        String label = NODE_LABELS.get(classname);
        sb.append(label);
    }

    @Override
    public void postVisit(ASTNode node) {
        if (hasChildren(node)) {
            sb.append("]");
        }
    }

    private boolean hasChildren(ASTNode node) {
        boolean has = false;
        for (Object o : node.structuralPropertiesForType()) {
            StructuralPropertyDescriptor descriptor = (StructuralPropertyDescriptor) o;
            if (descriptor.isSimpleProperty()) {
                continue;
            }
            Object property = node.getStructuralProperty(descriptor);
            if (descriptor.isChildProperty() && property != null) {
                has = true;
            } else if (descriptor.isChildListProperty() && !((List) property).isEmpty()) {
                has = true;
            }
        }
        return has;
    }

    public String getString() {
        return sb.toString();
    }

    private static final Map<String, String> NODE_LABELS = new HashMap<String, String>() {
        {
            put("AnnotationTypeDeclaration", "A");
            put("AnnotationTypeMemberDeclaration", "B");
            put("AnonymousClassDeclaration", "C");
            put("ArrayAccess", "D");
            put("ArrayCreation", "E");
            put("ArrayInitializer", "F");
            put("ArrayType", "G");
            put("AssertStatement", "H");
            put("Assignment", "I");
            put("Block", "J");
            put("BlockComment", "K");
            put("BooleanLiteral", "L");
            put("BreakStatement", "M");
            put("CastExpression", "N");
            put("CatchClause", "O");
            put("CharacterLiteral", "P");
            put("ClassInstanceCreation", "Q");
            put("CompilationUnit", "R");
            put("ConditionalExpression", "S");
            put("ConstructorInvocation", "T");
            put("ContinueStatement", "U");
            put("CreationReference", "V");
            put("Dimension", "W");
            put("DoStatement", "X");
            put("EmptyStatement", "Y");
            put("EnhancedForStatement", "Z");
            put("EnumConstantDeclaration", "1");
            put("EnumDeclaration", "2");
            put("ExpressionMethodReference", "3");
            put("ExpressionStatement", "4");
            put("FieldAccess", "5");
            put("FieldDeclaration", "6");
            put("ForStatement", "7");
            put("IfStatement", "8");
            put("ImportDeclaration", "9");
            put("InfixExpression", "0");
            put("Initializer", "a");
            put("InstanceofExpression", "b");
            put("IntersectionType", "c");
            put("Javadoc", "d");
            put("LabeledStatement", "e");
            put("LambdaExpression", "f");
            put("LineComment", "g");
            put("MarkerAnnotation", "h");
            put("MemberRef", "i");
            put("MemberValuePair", "j");
            put("MethodDeclaration", "k");
            put("MethodInvocation", "l");
            put("MethodRef", "m");
            put("MethodRefParameter", "n");
            put("Modifier", "o");
            put("NameQualifiedType", "p");
            put("NormalAnnotation", "q");
            put("NullLiteral", "r");
            put("NumberLiteral", "s");
            put("PackageDeclaration", "t");
            put("ParameterizedType", "u");
            put("ParenthesizedExpression", "v");
            put("PostfixExpression", "w");
            put("PrefixExpression", "x");
            put("PrimitiveType", "y");
            put("QualifiedName", "z");
            put("QualifiedType", "!");
            put("ReturnStatement", "@");
            put("SimpleName", "#");
            put("SimpleType", "$");
            put("SingleMemberAnnotation", "%");
            put("SingleVariableDeclaration", "^");
            put("StringLiteral", "&");
            put("SuperConstructorInvocation", "*");
            put("SuperFieldAccess", "(");
            put("SuperMethodInvocation", ")");
            put("SwitchCase", "-");
            put("SwitchStatement", "=");
            put("SynchronizedStatement", "_");
            put("TagElement", "+");
            put("TextElement", "\\");
            put("ThisExpression", "|");
            put("ThrowStatement", "{");
            put("TryStatement", "}");
            put("TypeDeclaration", ";");
            put("TypeDeclarationStatement", "");
            put("TypeLiteral", ":");
            put("TypeMethodReference", ",");
            put("TypeParameter", ".");
            put("UnionType", "/");
            put("VariableDeclarationExpression", "<");
            put("VariableDeclarationFragment", ">");
            put("VariableDeclarationStatement", "?");
            put("WhileStatement", "`");
            put("WildcardType", "~");
        }
    };

}
