package linked_list;
public class SLL<E>{
    protected SLLNode<E> head, tail;
    public SLL(){
        this.head = this.tail = null;
    }

    public SLLNode<E> getHead() {
        return head;
    }

    public void setHead(SLLNode<E> head) {
        this.head = head;
    }

    public SLLNode<E> getTail() {
        return tail;
    }

    public void setTail(SLLNode<E> tail) {
        this.tail = tail;
    }
    
    public boolean isEmpty(){
        return head == null;
    }
    public void addToHead(E el){
        head = new SLLNode(el, head);
        if(tail == null) tail = head;
    }
    public void addToTail(E el){
        if(!isEmpty()){
            tail.next = new SLLNode<E>(el);
            tail = tail.next;
        }
        else head = tail = new SLLNode<E>(el);
    }
    public E deleteFromHead(){
        if(isEmpty()) return null;
        E el = head.info;
        if(head == tail) head = tail = null;
        else head = head.next;
        return el;
    }
    public E deleteFromTail(){
        if(isEmpty()) return null;
        E el = tail.info;
        if(head == tail) head = tail = null;
        else{
            SLLNode<E> tmp;
            for(tmp = head; tmp.next!= tail; tmp = tmp.next){
                tail= tmp;
                tail.next = null;
            }
        }
        return el;
    
    }
    public void delete(E el){
        if(!isEmpty())
            if(head == tail) head = tail = null;
            else if(el.equals(head.info))
                head = head.next;
            else{
                SLLNode<E> pred, tmp;
                for(pred= head, tmp = head.next; tmp!= null && !tmp.info.equals(el); pred= pred.next, tmp = tmp.next);
                if(tmp!= null){
                    pred.next = tmp.next;
                    if(tmp == tail) tail = pred;
                }
                    
            }
    }
    public void printAll(){
        for(SLLNode<E> tmp = head; tmp!= null; tmp= tmp. next)
            System.out.println(tmp.info);
    }
    public boolean isInList(E el){
        SLLNode<E> tmp;
        for(tmp = head; tmp != null && !tmp.info.equals(el); tmp = tmp.next);
            return tmp!= null;       
    }
    
}
