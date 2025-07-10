//  트리 순회

import java.util.*;
import java.lang.*;
import java.io.*;


class Node {
    char val;
    Node left;
    Node right;

    Node(char val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Node[] tree = new Node[26];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char parent = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            if (tree[parent - 'A'] == null)
                tree[parent - 'A'] = new Node(parent);
            Node parentNode = tree[parent - 'A'];

            if (left != '.') {
                if (tree[left - 'A'] == null) {
                    tree[left - 'A'] = new Node(left);
                }
                parentNode.left = tree[left - 'A'];
            }

            if (right != '.') {
                if (tree[right - 'A'] == null) {
                    tree[right - 'A'] = new Node(right);
                }
                parentNode.right = tree[right - 'A'];
            }
        }


        Node root = tree[0];

        preOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
        postOrder(root);

    }

    static void preOrder(Node node) {
        if (node == null) return;
        System.out.print(node.val);
        preOrder(node.left);
        preOrder(node.right);
    }

    static void inOrder(Node node) {
        if (node == null) return;
        inOrder(node.left);
        System.out.print(node.val);
        inOrder(node.right);
    }

    static void postOrder(Node node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.val);
    }
}