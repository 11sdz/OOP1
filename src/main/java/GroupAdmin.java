import java.util.ArrayList;

public class GroupAdmin implements Sender{
    /**
     * Observer design pattern A one to many dependency between objects, Members subscribe to the GroupAdmin
     * When GroupAdmin changes state , subscribers gets updated automatically
     * GroupAdmin notify to all members registered
     */
    private ArrayList<ConcreteMember> concreteMembers = new ArrayList<ConcreteMember>();
    private UndoableStringBuilder usb= new UndoableStringBuilder();

    /**
     * Registration of members to this GroupAdmin
     * @param obj -Member object
     */
    @Override
    public void register(Member obj) {
        if (!this.concreteMembers.contains((ConcreteMember)obj)){
            this.concreteMembers.add((ConcreteMember) obj);
            obj.update(this.usb);
        }
    }

    /**
     * Unregistration of members from this GroupAdmin
     * @param obj -Member Object
     */
    @Override
    public void unregister(Member obj) {
        if(this.concreteMembers.contains((ConcreteMember)obj)){
            this.concreteMembers.remove((ConcreteMember)obj);
            obj.update(null);
        }
    }

    /**
     * insert action to this UndoableStringBuilder
     * @param offset - offset to insert
     * @param obj - String to insert
     */
    @Override
    public void insert(int offset, String obj) {
        this.usb.insert(offset,obj);
        notifyMembers();
    }

    /**
     * append action to this UndoableStringBuilder
     * @param obj - String to insert
     */
    @Override
    public void append(String obj) {
        this.usb.append(obj);
        notifyMembers();
    }

    /**
     *  delete action to this UndoableStringBuilder
     * @param start - Integer position delete from
     * @param end - delete to
     */
    @Override
    public void delete(int start, int end) {
        this.usb.delete(start, end);
        notifyMembers();
    }

    /**
     * undo action to this UndoableStringBuilder
     */
    @Override
    public void undo() {
        this.usb.undo();
        notifyMembers();
    }

    /**
     * Observer Notify to all members that subscribed
     */
    private void notifyMembers(){
        for (ConcreteMember mem : concreteMembers){
            mem.update(this.usb);
        }
    }
}
