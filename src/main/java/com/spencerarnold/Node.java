package com.spencerarnold;


import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class Node {
    private int value;
    private Node parent;
    private Node left;
    private Node right;
    private List<Node> children;

    public Node(int value, Node parent){
        this.value = value;
        this.parent = parent;
        
        this.children = new Stack<Node>();
    }
    public Node parent(){ return parent; }

    public List<Node> children() { return children; }

    public void setParent(Node parent){ this.parent = parent; }

    public void addChild(Node child){ 
        if(left==null){
            this.left=child;
            this.children.add(0, child);
        }
        else if(right==null){
            this.right=child;
            this.children.add(1, child);
        }
        else{
            throw new IllegalArgumentException();
        }
    }

    public Node addChild(int value){ 
        if(left==null){
            this.left = new Node(value, this);
            this.children.add(this.left);
            return this.left;
        }
        else if(right==null){
            this.right = new Node(value, this);;
            this.children.add(this.right);
            return this.right;
        }
        else{
            throw new IllegalArgumentException();
        }
    }

    public Node left() { return left; }

    public void setLeft(Node newLeft) {
        if(this.left==null){
            this.left = newLeft;
            this.children.add(newLeft);
        }
        else{
            this.left.setValue(newLeft.getValue()); 
        }
        
    }

    public void setRight(Node newRight) { 
        if(right==null){
            this.right = newRight;
            this.children.add(newRight);
        }
        else{
            this.right.setValue(newRight.getValue());
        }
    }

    public Node right() { return right; }

    public int getValue(){ return value; }

    public int setValue(int value){ this.value = value; return value; }

    public String toString() {
        StringBuilder buffer = new StringBuilder(50);
        print(buffer, "", "");
        return buffer.toString();
    }

    private void print(StringBuilder buffer, String prefix, String childrenPrefix) {
        buffer.append(prefix);
        buffer.append(this.getValue());
        buffer.append('\n');
        for (Iterator<Node> it = this.children.iterator(); it.hasNext();) {
            Node next = it.next();
            if(next==null) continue;
            if (it.hasNext()) {
                next.print(buffer, childrenPrefix + "├── ", childrenPrefix + "│   ");
            } else {
                next.print(buffer, childrenPrefix + "└── ", childrenPrefix + "    ");
            }
        }
    }

}
