
package linked_list;
public class DLL<E> extends DLLNode{
    private DLLNode<E> header;
    private DLLNode<E> trailer;
    private int size = 0;
    public DLL(){
        header = new DLLNode(null,null,null);
        trailer = new DLLNode(null, header, null);
        header.setNext(trailer);
    }

    public DLLNode<E> getHeader() {
        return header;
    }

    public void setHeader(DLLNode<E> header) {
        this.header = header;
    }

    public DLLNode<E> getTrailer() {
        return trailer;
    }

    public void setTrailer(DLLNode<E> trailer) {
        this.trailer = trailer;
    }
    
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public E first(){
        if(isEmpty()) return null;
        return header.getNext().getInfo();
    }
    public E last(){
        if(isEmpty()) return null;
        return trailer.getPre().getInfo();
    }
    public void addFirst(E e) {
        addBetween(e, header, header.getNext());
        
    }
    public void addLast(E e){
        addBetween(e, trailer.getPre(), trailer);
    }
    public void addBetween(E e, DLLNode <E> predecessor, DLLNode <E> successor){
        DLLNode <E> newest = new DLLNode<E>( e,predecessor,successor);
        predecessor.setNext(newest);
        successor.setPre(newest);
        size++;
    }
    public E remove(DLLNode<E> node){
        DLLNode<E> predecessor = node.getPre();
        DLLNode<E> successor = node.getNext();
        predecessor.setNext(node);
        successor.setPre(node);
        size --;
        return node.getInfo();
    }    
    public void printAll(){
        for(DLLNode<E> tmp = header; tmp != null ;tmp = tmp.next)
            if(tmp.info != null)
            System.out.println(tmp.info);
    }
}
