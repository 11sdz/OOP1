import java.util.ArrayList;

public class GroupAdmin implements Sender{
    private ArrayList<Member> members = new ArrayList<Member>();
    private UndoableStringBuilder usb= new UndoableStringBuilder();
    @Override
    public void register(Member obj) {
        if (members.contains(obj)){
            return;
        }else{
            members.add(obj);
        }
    }

    @Override
    public void unregister(Member obj) {
        if(members.contains(obj)){
            members.remove(obj);
        }else return;
    }

    @Override
    public void insert(int offset, String obj) {
        usb.insert(offset,obj);
        notifyMembers();
    }

    @Override
    public void append(String obj) {
        usb.append(obj);
        notifyMembers();
    }

    @Override
    public void delete(int start, int end) {
        usb.delete(start, end);
        notifyMembers();
    }

    @Override
    public void undo() {
        usb.undo();
        notifyMembers();
    }
    private void notifyMembers(){
        for (Member mem : members){
            mem.update(usb);
        }
    }
}
