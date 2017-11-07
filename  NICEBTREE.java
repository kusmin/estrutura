/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed3;


import java.util.Scanner;

class Arvore {
    class No { 
        private char conteudo;
        private No left;
        private No right;

        public char getConteudo() {
            return conteudo;
        }

        public void setConteudo(char conteudo) {
            this.conteudo = conteudo;
        }

        public No getLeft() {
            return left;
        }

        public void setLeft(No left) {
            this.left = left;
        }

        public No getRight() {
            return right;
        }

        public void setRight(No right) {
            this.right = right;
        }



    }
    private String traversal;
    private int index;
    private No root;
    
   
    public Arvore(String t) {
        traversal = t;
        index = 0;
        
        
        No newNo = new No();
        root = newNo;
        root.setConteudo(traversal.charAt(index));
        if (root.getConteudo() == 'l') {
            root.setLeft(null);
            root.setRight(null);
        } else {
            root.setLeft(add(root, traversal.charAt(++index)));
            root.setRight(add(root, traversal.charAt(++index)));
        }
    }
    
   
    private No add(No parent, char conteudo) {
        No newNo = new No();
        newNo.setConteudo(conteudo);
        
        
        if (conteudo == 'l') {
            newNo.setLeft(null);
            newNo.setRight(null);
        } 
       
        else {
            newNo.setLeft(add(newNo, traversal.charAt(++index)));
            newNo.setRight(add(newNo, traversal.charAt(++index)));
        }

        return newNo;
    }
    
   
    public int getDepth() {
        
        return getDepth(root) - 1;
    }
    
    
    private int getDepth(No node) {
        if (node == null) {
            return 0;
        }

        int leftDepth = getDepth(node.getLeft());
        int rightDepth = getDepth(node.getRight()); 
        
        if (leftDepth > rightDepth) {
            return ++leftDepth;
        } else {
            return  ++rightDepth;
        }
    }
}

class  NICEBTREE {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        s.nextLine();

        String traversal;
        int i;
        for (i = 0; i < t; i++) {
            traversal = s.nextLine();

            Arvore arvore = new Arvore(traversal);
            System.out.println(arvore.getDepth());
            
        }
    }
}