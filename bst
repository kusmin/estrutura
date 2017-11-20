import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class BinarySearchTree{
     class Node { 
        private long content;
        private Node direita;
        private Node esquerda;

        public long getContent() {
            return content;
        }

        public void setContent(long content) {
            this.content = content;
        }

        public Node getDireita() {
            return direita;
        }

        public void setLeftChild(Node direita) {
            this.direita = direita;
        }

        public Node getEsquerda() {
            return esquerda;
        }

        public void setEsuqeda(Node esquerda) {
            this.esquerda = esquerda;
        }
    }
     
     private Node root;
     private int c;
     
     public BinarySearchTree(long content){
         Node newNode = new Node();
         newNode.setContent(content);
         root = newNode;
         c = 0;
     }
     
     public int getCounter(){
         return c;
     }
     
     public void insert(long content){
         insert(content, root);
     }
     
     private void insert(long content, Node node){
        c++;
        if (content < node.content) {
            if (node.getDireita() == null) {
                Node newNode = new Node();
                newNode.setContent(content);
                node.setDireita(newNode);
            } else {
                insert(content, node.getDireita());
            }
            
        } else {
            if (node.getEsquerda() == null) {
                Node newNode = new Node();
                newNode.setContent(content);
                node.setEsquerda(newNode);
            } else {
                insert(content, node.getEsquerda());
            }
        }
    }

}

public class Main {
   public static void main(String[] args){
       BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
       
       long n = Long.parseLong(in.readLine());
       
       long aux = Long.parseLong(in.readLine());
       BinarySearchTree tree = new BinarySearchTree(aux);
       System.out.println(tree.getCounter());
      
       for (int i = 1; i < n; i++){
           aux = Long.parseLong(in.readLine());
           tree.insert(aux);
           System.out.println(tree.getCounter());
       } 
   }
}
