package Trie;

public class TrieNVector {
	
	class Node{
		private Node[] items;
		Node(int n){
			this.items = new Node[n];
		}
	}
	
	private Node root;
	private int alpha;
	private char eok;
	
	public TrieNVector(int alpha, char eok) {
		this.alpha = alpha;
		this.eok = eok;
		this.root = new Node(this.alpha + 1);
	}
	private int mapping(char c)	{
		if (c == this.eok) {
			return this.alpha;
		}
		System.out.println("--- "+(c-'a'));
		return (c - 'a');
	}
	
	public void insert(String pattern) {  //pattern incluye eok
		Node aux = this.root;

		int pos;
		for(int i=0; i< pattern.length(); i++) {
			pos = mapping(pattern.charAt(i));
			if (aux.items[pos] == null) {
				if(pos == this.alpha )
					aux.items[pos] = aux;
				else 
					aux.items[pos] = new Node(this.alpha + 1);
				
			}
			aux = aux.items[pos];
		}
	}
	public boolean search(String pattern) {
		Node aux = this.root;
		int pos;
		for(int i=0; i< pattern.length(); i++) {
			pos = mapping(pattern.charAt(i));
			if (aux.items[pos] != null)
				aux = aux.items[pos];
			else
				return false;
		}
		return true;
	}
	
	
}
