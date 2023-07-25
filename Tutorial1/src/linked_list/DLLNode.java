
package linked_list;

public class DLLNode <E>{
    E info;
    DLLNode<E> next, pre;
    public DLLNode() {
      
    }
    public DLLNode(E info, DLLNode<E> pre, DLLNode <E> next){
     this.info = info ; this.next = next; this.pre = pre;   
    }

    public E getInfo() {
        return info;
    }

    public DLLNode<E> getNext() {
        return next;
    }

    public void setNext(DLLNode<E> next) {
        this.next = next;
    }

    public DLLNode<E> getPre() {
        return pre;
    }

    public void setPre(DLLNode<E> pre) {
        this.pre = pre;
    }
    
}
