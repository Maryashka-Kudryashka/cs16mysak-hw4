package ua.edu.ucu.autocomplete;

import ua.edu.ucu.tries.Trie;
import ua.edu.ucu.tries.Tuple;

import java.util.ArrayList;

/**
 *
 * @author andrii
 */
public class PrefixMatches {

    private Trie trie;

    public PrefixMatches(Trie trie) {
        this.trie = trie;
    }

    public int load(String... strings) {
        for (String line: strings) {
            for (String word: line.split(" ")){
                if (word.length()>2) {
                    trie.add(new Tuple(word, word.length()));
                }
            }
        }


        return 0;
    }

    public boolean contains(String word) {
        return trie.contains(word);
    }

    public boolean delete(String word) {
        return trie.delete(word);
    }

    public Iterable<String> wordsWithPrefix(String pref) {
        return trie.wordsWithPrefix(pref);
    }

    public Iterable<String> wordsWithPrefix(String pref, int k) {
        ArrayList<String> listik = new ArrayList<>();
        ArrayList<String> listichok = new ArrayList<>();
        listik = (ArrayList<String>) trie.wordsWithPrefix(pref);
        for (int i = 0; i < listik.size(); i++) {
                if (listik.get(i).length() < k + pref.length()) {
                    listichok.add(listik.get(i));
                }


            }
            return listichok;
        }

    public int size() {
        return trie.size();
    }
}
