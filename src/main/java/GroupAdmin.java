import java.util.ArrayList;

public class GroupAdmin implements Sender{
    /**
     * Observer design pattern A one to many dependency between objects, Members subscribe to the GroupAdmin
     * When GroupAdmin changes state , subscribers gets updated automatically
     * GroupAdmin notify to all members registered
     */
    private ArrayList<Member> members = new ArrayList<Member>();
    private UndoableStringBuilder usb= new UndoableStringBuilder();

    /**
     * Registration of members to this GroupAdmin
     * @param obj
     */
    @Override
    public void register(Member obj) {
        if (this.members.contains(obj)){
            return;
        }else{
            this.members.add(obj);
            obj.update(this.usb);
        }
    }

    /**
     * Unregistration of members from this GroupAdmin
     * @param obj
     */
    @Override
    public void unregister(Member obj) {
        if(this.members.contains(obj)){
            this.members.remove(obj);
            obj.update(null);
        }else return;
    }

    /**
     * insert action to this UndoableStringBuilder
     * @param offset
     * @param obj
     */
    @Override
    public void insert(int offset, String obj) {
        this.usb.insert(offset,obj);
        notifyMembers();
    }

    /**
     * append action to this UndoableStringBuilder
     * @param obj
     */
    @Override
    public void append(String obj) {
        this.usb.append(obj);
        notifyMembers();
    }

    /**
     *  delete action to this UndoableStringBuilder
     * @param start
     * @param end
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
        for (Member mem : members){
            mem.update(this.usb);
        }
    }
}
