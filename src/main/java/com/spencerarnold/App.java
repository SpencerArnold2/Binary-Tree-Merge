package com.spencerarnold;

import java.util.Scanner;
import java.util.Stack;

public class App {
    public static void main(String[] args) throws InterruptedException {
        String commandString = "Binary Tree Tool\nOptions:\n1: Create binary tree\n2: List trees\n3: Merge two trees\n4: Exit\n";
        String choice = null;
        Scanner input = new Scanner(System.in);
        Stack<BinaryTree> stack = new Stack<BinaryTree>();
        do {
            System.out.print(commandString);
            choice = input.nextLine();
            switch (choice) {
                case "1":
                    System.out.println("Enter in binary tree values starting with the root seperated by a space.");
                    System.out.println("Example: 1 2 3");
                    String str = input.nextLine();
                    String[] splitStr = str.split(" ");
                    int[] values = new int[splitStr.length];
                    for (int i = 0; i < splitStr.length; i++) {
                        values[i] = Integer.parseInt(splitStr[i]);
                    }
                    Node newRoot = new Node(values[0], null);
                    Node pointer = newRoot;
                    int height = 1;
                    int currentHeightCounter = 0;
                    Stack<Node> visited = new Stack<Node>();
                    for (int i = 1; i < values.length; i++) {
                        visited.push(pointer.addChild(values[i]));
                        currentHeightCounter++;
                        if (currentHeightCounter / (height) == 2) {
                            pointer = visited.get(i - 1 - height);
                            height++;
                        }
                    }
                    System.out.println(newRoot.toString());
                    stack.push(new BinaryTree(newRoot));
                    break;
                case "2":
                    for (int i = 0; i < stack.size(); i++) {
                        System.out.println(i + ":\n" + stack.get(i).root().toString());
                    }
                    break;
                case "3":
                    System.out.println();
                    for (int i = 0; i < stack.size(); i++) {
                        System.out.println(i + ":\n" + stack.get(i).root().toString());
                    }
                    System.out.println("Select two trees seperated by a space.");
                    System.out.println("Example: 0 1");
                    str = input.nextLine();
                    splitStr = str.split(" ");
                    values = new int[splitStr.length];
                    for (int i = 0; i < splitStr.length; i++) {
                        values[i] = Integer.parseInt(splitStr[i]);
                    }
                    Node r3 = mergeTrees(stack.get(values[0]).root(), stack.get(values[1]).root());
                    System.out.println(r3.toString());

            }
        } while (!choice.equals("4"));
        input.close();

    }

    public static Node mergeTrees(Node r1, Node r2) {
        Node r3 = r1;
        if (r1 == null && r2 == null) {
            return null;
        }
        if (r1 == null) {
            return r2;
        }
        if (r2 == null) {
            return r1;
        }
        r3.setValue(r1.getValue() + r2.getValue());
        r3.setLeft(mergeTrees(r1.left(), r2.left()));
        r3.setRight(mergeTrees(r1.right(), r2.right()));
        return r3;
    }
}
