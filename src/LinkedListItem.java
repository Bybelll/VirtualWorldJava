
public class LinkedListItem {
    private LivingBeing organism;
    private LinkedListItem next;
    private LinkedListItem prev;

    public LinkedListItem(LivingBeing organism) {
        this.organism = organism;
        this.next = null;
        this.prev = null;
    }

    public LinkedListItem getNext() {
        return this.next;
    }

    public void setNext(LinkedListItem newNext) {
        this.next = newNext;
    }

    public LinkedListItem getPrev() {
        return this.prev;
    }

    public void setPrev(LinkedListItem newPrev) {
        this.prev = newPrev;
    }

    public LivingBeing getOrganism() {
        return this.organism;
    }

}
