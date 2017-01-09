package ua.edu.ucu.tries;

import java.util.ArrayList;
import java.util.stream.Stream;

public class RWayTrie implements Trie {
    private Node root;

    public RWayTrie() {
        this.root = new Node();
    }


    @Override
    public void add(Tuple t) {
        String word = t.getTerm();
        Integer value = t.getWeight();
        root.put(root, word, value, 0);
    }

    @Override
    public boolean contains(String word) {
        if (root.get(root, word, 0) != null){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public boolean delete(String word) {
        if(root.put(root, word, 0,0).getVal() == 0){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public Iterable<String> words() {
        ArrayList<String> all_words = new ArrayList<>();
        root.DFS(root, "", all_words );
        return all_words;
    }

    @Override
    public Iterable<String> wordsWithPrefix(String s){
        ArrayList<String> wrd = new ArrayList<>();
        Node nd = root.get(root, s, 0);
        root.DFS(nd,s,wrd);
        return wrd;
    }

    @Override
    public int size() {
        ArrayList<String> nw = new ArrayList<>();
        return root.size(root,"", nw);
    }

}
