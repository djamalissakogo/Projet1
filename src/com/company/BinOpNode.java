package com.company;

public class BinOpNode extends Node{
    Token operator;
    Node leftVal;
    Node rightVal;

    public BinOpNode(Token operator, Node leftVal, Node rightVal) {
        super();
        this.operator = operator;
        this.leftVal = leftVal;
        this.rightVal = rightVal;
    }
}
