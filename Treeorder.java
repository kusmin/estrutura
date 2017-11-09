/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treeorder;

import java.io.*;

class Main {
	
	static class No{
		int valor;
		No left;
		No right;
		
		public No(int valor) {
			this.valor = valor;
			left = null;
			right = null;
		}
	}
	
	static class Arvore{
		protected String posStr = "";
		protected static int preIndex = 0;
		
		//method used to build arvore using both preOrder and inOrder traversals
		private No buildTree(String in[], String pre[], int inStrt, int inEnd) 
	    {
	        if (inStrt > inEnd) 
	            return null;
	        
	        int value = Integer.parseInt(pre[preIndex++]);
	        No tNO = new No(value);
	 
	        if (inStrt == inEnd)
	            return tNO;
	  
	        int inIndex = search(in, inStrt, inEnd, tNO.valor);
	  
	        tNO.left = buildTree(in, pre, inStrt, inIndex - 1);
	        tNO.right = buildTree(in, pre, inIndex + 1, inEnd);
	  
	        return tNO;
	    }
		
		//method used to find preOrder element inOrder array 
		private int search(String arr[], int strt, int end, int value) 
	    {
	        int i;
	        for (i = strt; i <= end; i++) 
	        {
	        	int arrValue = Integer.parseInt(arr[i]);
	            if ( arrValue == value)
	                return i;
	        }
	        return i;
	    }
		
		private void posOrderTree(No no) 
	    {
	        if (no == null) return;
		    
	  
	        posOrderTree(no.left);
	  
	  	
	        posOrderTree(no.right);
	        
		
	        posStr += no.valor + " ";
	    }
		
		private String equalsStr() {
			return posStr;
		}
		
	}
	
	public static void main(String[] args) throws IOException{
		try {
			
			Arvore arvore = new Arvore();
			
			
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			int size = Integer.parseInt(in.readLine());
		
			
			String pre = in.readLine();
			String preOrder[] = pre.split(" ");
			
			
			String pos = in.readLine();
			
			
			String inOr = in.readLine();
			String inOrder[] = inOr.split(" ");
			
			
			No root = arvore.buildTree(inOrder, preOrder, 0, size-1);
			
			
			arvore.posOrderTree(root);
			
			String posTree = arvore.equalsStr();
			
			
			String posStr = posTree.substring(0, posTree.length() - 1);
			if(pos.equals(posStr)) {
				System.out.println("yes");
			}else {
				System.out.println("no");
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}