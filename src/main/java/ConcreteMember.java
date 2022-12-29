public class ConcreteMember implements Member {
    private String name;
    private static int id = 1;
    private UndoableStringBuilder usbShallowCopy;

    /**
     * Constructor with given Name
     * @param name
     */
    public ConcreteMember(String name) {
        this.name = name;
    }

    /**
     * empty constructor
     * generating ID number/name
     */
    public ConcreteMember(){
        this.name= String.valueOf(this.id);
        this.id++;
    }

    /**
     * Observer Update action
     * Updating shadow clone of UndoableStringBuilder
     * @param usb
     */
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

    /**
     * ToString method
     * Printing name and the UndoableStringBuilder string
     * @return
     */
    @Override
    public String toString() {
        return this.usbShallowCopy.toString();
    }
}
