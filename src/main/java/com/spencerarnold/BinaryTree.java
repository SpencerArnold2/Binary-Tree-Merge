package com.spencerarnold;

import java.util.List;

public class BinaryTree{
    private Node root;

    public BinaryTree(Node root){
        this.root = root;
    }
    Node root(){ return root; }

    Node parent(Node n){ return n.parent(); }

    List<Node> children(Node n){ return n.children(); }

    Node left(Node n){ return n.left();}

    Node right(Node n){ return n.right();}

    int numChildren(Node n){
        return this.size(n);        
    }

    boolean hasChildren(Node n){
        return this.size(n) > 0;
    }

    boolean isRoot(Node n){
        return n==root;
    }

    int size()
    {
        return size(root);
    }
 
    /* computes number of nodes in tree */
    int size(Node node)
    {
        if (node == null)
            return 0;
        else
            return(size(node.left()) + 1 + size(node.right()));
    }

    boolean isEmpty(){
        return size() == 0;
    }

    
}
