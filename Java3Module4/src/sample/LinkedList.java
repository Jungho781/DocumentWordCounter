package sample;

class ListNode<E>{
    E data;
    ListNode<E> nextNode;
    ListNode(E object){this(object,null);}
    ListNode(E object,ListNode<E>node){
        data=object;
        nextNode=node;
    }
    public void setNextNode(ListNode<E>node){
        nextNode=node;
    }
    public void setData(E data){
        this.data=data;
    }
    ListNode<E>getNext(){
        return nextNode;
    }

    E getData(){return data;}
    ListNode<E>getNextNode(){return nextNode;}
}

public class LinkedList<E> {

    private ListNode<E> firstNode;
    private ListNode<E> lastNode;
    private String name;

    public LinkedList() {
        this("list");
    }

    public LinkedList(String listName) {
        name = listName;
        firstNode = lastNode = null;
    }

    public boolean isEmpty() {
        return firstNode == null;
    }

    public int size() {
        int size = 0;

        if (!isEmpty()){
            size=1;
            ListNode<E> current = firstNode;
            while (current.nextNode != null) {
                current = current.nextNode;
                size++;}
        }
        return size;
    }

    public void addFirst(E data) {
        if (isEmpty()) {
            firstNode = lastNode = new ListNode<E>(data);
        } else {
            firstNode = new ListNode<>(data, firstNode);
        }
    }

    public void addLast(E data) {
        if (isEmpty()) {
            firstNode = lastNode = new ListNode<>(data);
        } else {
            lastNode = lastNode.nextNode = new ListNode<>(data);
        }

    }

    public void add(E data, int index) {
        if(index>size()){
            throw new IndexOutOfBoundsException("Use addLast to add data to end of list");
        }
        ListNode<E> newNode=new ListNode<>(data);
        ListNode<E> previous=firstNode;
        int count=1;
        while(count<index-1){
            previous=previous.nextNode;
            count++;
        }
        ListNode<E>current=previous.nextNode;
        newNode.nextNode=current;
        previous.nextNode=newNode;
    }

    public E getComponents(){
        int count=1;
        ListNode<E>current=firstNode;
        while(count<size()){
            current=current.nextNode;
            count++;
        }
        return current.data;
    }

    public E remove(int index) {
        if (index > size()) {
            throw new IndexOutOfBoundsException("Target is out of bounds");
        }

        ListNode<E> previous = firstNode;
        int count = 1;
        while (count < index - 1) {
            previous = previous.nextNode;
            count++;
        }
        ListNode<E> current = previous.nextNode;
        previous.nextNode = current.nextNode;
        current.nextNode = null;
        return current.data;
    }

    public String toString() {
        StringBuilder out= new StringBuilder();
        ListNode<E>current=firstNode;
        int count=0;
        while (count<size()){
            if(current.nextNode==null){
                out.append(current.data);
                count++;
            }
            else {
                out.append(current.data);
                out.append(", ");
                current=current.nextNode;
                count++;
            }
        }
        return out.toString();
    }

    public void print(){
        if(isEmpty()){
            System.out.printf("Empty %s%n",name);
            return;
        }
        System.out.printf("The %s is: ",name);
        ListNode<E> current=firstNode;
        int count=0;
        while(count<size()){
            if (current.nextNode==null){
                System.out.printf("%s ",current.data);
            }
            else {
                System.out.printf("%s, ",current.data);
                current=current.nextNode;
            }
            count++;
        }
        System.out.println();
    }
}