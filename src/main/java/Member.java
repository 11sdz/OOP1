public class Member implements MemberInterface {
    private String name;
    private static int id = 1;
    private UndoableStringBuilder usbShallowCopy;

    public Member(String name) {
        this.name = name;
    }
    public Member(){
        this.name= String.valueOf(this.id);
        this.id++;
    }

    @Override
    public void update(UndoableStringBuilder usb) {
        try {
            if(usb!=null) {
                usbShallowCopy = (UndoableStringBuilder) usb.clone();
            }else{
                usbShallowCopy = null;
            }
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
}
