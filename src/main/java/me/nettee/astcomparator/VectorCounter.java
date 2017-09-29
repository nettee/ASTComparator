package me.nettee.astcomparator;

import java.util.HashMap;
import java.util.Map;

public class VectorCounter {

    private int[] vector;

    public VectorCounter() {
        vector = new int[N];
        for (int i = 0; i < N; i++) {
            vector[i] = 0;
        }
    }

    public void add(String name) {
        int index = NAME_INDEX.get(name);
        vector[index]++;
    }

    public double cosine(VectorCounter that) {
        return this.dot(that) / (this.mod() * that.mod());
    }

    public double dot(VectorCounter that) {
        double acc = 0.0;
        for (int i = 0; i < N; i++) {
            acc += this.vector[i] * that.vector[i];
        }
        return acc;
    }

    public double mod() {
        double acc = 0.0;
        for (int i = 0; i < N; i++) {
            int count = vector[i];
            acc += count * count;
        }
        return Math.sqrt(acc);
    }

    public void print() {
        for (int i = 0; i < N; i++) {
            String name = NODE_NAMES[i];
            int count = vector[i];
            if (count != 0) {
                System.out.printf("%s: %d\n", name, count);
            }
        }
    }

    private static final String[] NODE_NAMES = {
            "AnnotationTypeDeclaration",
            "AnnotationTypeMemberDeclaration",
            "AnonymousClassDeclaration",
            "ArrayAccess",
            "ArrayCreation",
            "ArrayInitializer",
            "ArrayType",
            "AssertStatement",
            "Assignment",
            "Block",
            "BlockComment",
            "BooleanLiteral",
            "BreakStatement",
            "CastExpression",
            "CatchClause",
            "CharacterLiteral",
            "ClassInstanceCreation",
            "CompilationUnit",
            "ConditionalExpression",
            "ConstructorInvocation",
            "ContinueStatement",
            "CreationReference",
            "Dimension",
            "DoStatement",
            "EmptyStatement",
            "EnhancedForStatement",
            "EnumConstantDeclaration",
            "EnumDeclaration",
            "ExpressionMethodReference",
            "ExpressionStatement",
            "FieldAccess",
            "FieldDeclaration",
            "ForStatement",
            "IfStatement",
            "ImportDeclaration",
            "InfixExpression",
            "Initializer",
            "InstanceofExpression",
            "IntersectionType",
            "Javadoc",
            "LabeledStatement",
            "LambdaExpression",
            "LineComment",
            "MarkerAnnotation",
            "MemberRef",
            "MemberValuePair",
            "MethodDeclaration",
            "MethodInvocation",
            "MethodRef",
            "MethodRefParameter",
            "Modifier",
            "NameQualifiedType",
            "NormalAnnotation",
            "NullLiteral",
            "NumberLiteral",
            "PackageDeclaration",
            "ParameterizedType",
            "ParenthesizedExpression",
            "PostfixExpression",
            "PrefixExpression",
            "PrimitiveType",
            "QualifiedName",
            "QualifiedType",
            "ReturnStatement",
            "SimpleName",
            "SimpleType",
            "SingleMemberAnnotation",
            "SingleVariableDeclaration",
            "StringLiteral",
            "SuperConstructorInvocation",
            "SuperFieldAccess",
            "SuperMethodInvocation",
            "SwitchCase",
            "SwitchStatement",
            "SynchronizedStatement",
            "TagElement",
            "TextElement",
            "ThisExpression",
            "ThrowStatement",
            "TryStatement",
            "TypeDeclaration",
            "TypeDeclarationStatement",
            "TypeLiteral",
            "TypeMethodReference",
            "TypeParameter",
            "UnionType",
            "VariableDeclarationExpression",
            "VariableDeclarationFragment",
            "VariableDeclarationStatement",
            "WhileStatement",
            "WildcardType",
    };

    private static final int N = NODE_NAMES.length;

    private static final HashMap<String, Integer> NAME_INDEX = new HashMap<String, Integer>() {
        {
            for (int i = 0; i < N; i++) {
                put(NODE_NAMES[i], i);
            }
        }
    };
}
