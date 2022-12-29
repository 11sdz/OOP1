public class ConcreteMember implements Member {
    private String name;
    private static int id = 1;
    private UndoableStringBuilder usbShallowCopy;

    public ConcreteMember(String name) {
        this.name = name;
    }
    public ConcreteMember(){
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
