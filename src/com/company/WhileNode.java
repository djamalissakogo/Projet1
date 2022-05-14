package com.company;

import java.util.ArrayList;

public class WhileNode extends Node{
    Token operator;
    Node leftVal;
    Node rightVal;
    public ArrayList<Node> operations = new ArrayList<>();

    public WhileNode(Token operator, Node leftVal, Node rightVal) {
        this.operator = operator;
        this.leftVal = leftVal;
        this.rightVal = rightVal;
    }
    public void addOperations(Node op){
        operations.add(op);
    }
}
