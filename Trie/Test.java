package Trie;

public class Test {
    public static void main(String[] args) {
        TrieNVector t = new TrieNVector(26, '$');
		
		t.insert("mama$");
		t.insert("mamita$");
		t.insert("mami$");
		t.insert("mamacita$");
		t.insert("mom$");
		t.insert("papa$");
		t.insert("paito$");
		t.insert("cuadro$");
		t.insert("mam$");
		
		System.out.println("mami ?" + t.search("mami$"));
		System.out.println("mamis ?" + t.search("mamis$"));
		System.out.println("papito ?" + t.search("papito$"));
		System.out.println("paito ?" + t.search("paito$"));
		System.out.println("mamacita ?" + t.search("mamacita$"));
		System.out.println("mam ?" + t.search("mam$"));
		
	
    }
}
