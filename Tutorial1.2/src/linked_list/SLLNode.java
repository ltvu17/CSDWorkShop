package linked_list;
public class SLLNode<E> {
    E info;
    SLLNode<E> next;
    public SLLNode(){
        next = null;
    }
    public SLLNode(E el){
        this.info = el; this.next = null;
    }
    public SLLNode(E el, SLLNode<E> next){
        this.info = el; this.next = next;
    }
    
}
