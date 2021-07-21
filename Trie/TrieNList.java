package Trie;

/**
 * @author Jhon Franklin Panocca Merma
 */
public class TrieNList {
    private class Node{
        char key;
        char eok;
        Node next;
        Node alternative;

        public Node(char key){
            this.key = key;
            this.next = null;
            this.alternative = null;
        }
    }

    private Node root;


    public void insert(String word){
        this.root = insert(word, this.root);
    }
    public Node insert(String word, Node node){

		if (word.length()>1) {
            
        }else{
            
        }
        return node;
    }

    public boolean search(String word){

        return false;
    }
    public void delete(String word){

    }

    public void list(){
        
    }

}
