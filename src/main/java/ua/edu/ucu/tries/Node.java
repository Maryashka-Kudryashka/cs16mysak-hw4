package ua.edu.ucu.tries;
import java.util.ArrayList;

public class Node {
    private static int R = 26; // radix
    private Node root; // root of trie
    private Integer val;
    private Node[] next = new Node[R];
    private int frst = 97;

    public Integer getVal() {
        return val;
    }

    protected Node put(Node x, String key, Integer val, int d) {
        // Change value associated with key if in subtrie rooted at x.
        if (x == null) x = new Node();
        if (d == key.length()) { x.val = val; return x; }
        char c = key.charAt(d); // Use dth key char to identify subtrie.
        x.next[c - frst] = put(x.next[c - frst], key, val, d+1);
        return x;
    }

    protected Node get(Node x, String key, int d) {
        // Return value associated with key in the subtrie rooted at x.
        if (x == null) return null;
        if (d == key.length()) return x;
        char c = key.charAt(d); // Use dth key char to identify subtrie.
        return get(x.next[c -frst], key, d+1);
    }

    protected void DFS(Node x, String tmp, ArrayList<String> lst) {
        if (x != null) {
            if (x.getVal() != null && x.getVal() > 0) lst.add(tmp);
            for (int i = 0; i < R; i++) {
                DFS(x.next[i], tmp + (char) (i+frst), lst);
            }
        }
    }

    protected int size (Node x, String tmp, ArrayList<String> lst) {
        if (x != null) {
            if (x.getVal() != null && x.getVal() > 0) lst.add(tmp);
            for (int i = 0; i < R; i++) {
                DFS(x.next[i], tmp + (char) (i+frst), lst);
            }
        }
        return lst.size();
    }





}
