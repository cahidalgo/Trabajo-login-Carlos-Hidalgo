package com.mycompany.registro;
import java.util.Iterator;
/**
 *
 * @author sala4
 */
public class QueLLi <Item> implements Iterable <Item>{
    private Node first;
    private Node last;
    private int count;

    private class Node{
        Item item;
        Node next;
    }
    
    public QueLLi(){
        first=null;
        last=null;
        count=0;
        
    }
    
    public void enqueue(Item item){
        Node oldlast=last;
        last=new Node();
        last.item=item;
        if (isEmpty()) first=last;
        else oldlast.next=last;
         count++;
        
    }
    public Item dequeue(){
        Item item=first.item;
        first=first.next;
        count--;
        if (isEmpty()) last=first; 
           
        return item;
    }
    
    public boolean isEmpty(){
        return first==null;
    }
    
    public int size(){
        return count;
    }
    
    @Override
    public Iterator<Item> iterator() {
        return new LLIterator();
    }
    
    private class LLIterator implements Iterator <Item>{
        private Node current=first;
        
        @Override
        public boolean hasNext(){
            return current !=null;
        }
        @Override
        public Item next(){
            Item item = current.item;
            current=current.next;
            return item;
        }
    }
}
