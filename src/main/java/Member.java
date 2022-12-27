public class Member implements MemberInterface {
    private final String name;
    private UndoableStringBuilder usbShallowCopy;

    public Member(String name) {
        this.name = name;
    }

    @Override
    public void update(UndoableStringBuilder usb) {
        try {
            usbShallowCopy = (UndoableStringBuilder) usb.clone();
        }catch (CloneNotSupportedException e){
            System.out.println(e);
        }
    }

    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", usbShallowCopy=" + usbShallowCopy +
                '}';
    }
    
    @Override 
    public String getName() {
        return name;
    }
    
    @Override 
    public UndoableStringBuilder getUsbShallowCopy() {
        return usbShallowCopy;
    }
}
