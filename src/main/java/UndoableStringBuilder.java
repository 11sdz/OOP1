import java.util.Stack;

public class UndoableStringBuilder implements MyStringBuilderInterface,Cloneable{
    /** Exercise 0 part 1
     * Tair Salomi ID = 313357196
     * Daniel Zinn ID = 208640326
     *  <p>String builder that supports Undo operations using linear Data Structure Stack (LIFO)</p>
     */

    private StringBuilder stringBuilder;
    private Stack<String> undoStack;

    public UndoableStringBuilder() {
        stringBuilder = new StringBuilder();
        undoStack = new Stack<String>();
    }
    /*public UndoableStringBuilder(String str){
        this.stringBuilder = new StringBuilder(str);
        undoStack = new Stack<String>();
    }*/
    /**
     * <p>appends the specified String to this {@code StringBuilder} StringBuilder</p>
     * <p>push into the {@code Stack} the latest String</p>
     * @param str the string to append
     * @return UndoableStringBuilder a reference to this object
     */
    @Override
    public UndoableStringBuilder append(String str) {
        this.undoStack.push(this.stringBuilder.toString());
        this.stringBuilder.append(str);
        return this;
    }
    /**
     *  <P>delete the sequence between the starting index to the ending index</P>
     *  <p><i>temp</i> is storing the latest StringBuilder string.
     *  then try to delete if the action fails catching error and return
     *  if the action is successful we push the latest string to the {@code Stack} <i>undoStack</i>
     *
     *  </p>
     * @param start the starting index to delete
     * @param end the ending index to delete
     * @return a reference to this object
     */
    @Override
    public UndoableStringBuilder delete(int start, int end) {
        String temp = this.stringBuilder.toString();
        try{
            this.stringBuilder.delete(start,end);
        }catch (StringIndexOutOfBoundsException e){
            System.out.println("index out of bounds "+e);
            return this;
        }
        undoStack.push(temp);
        return this;
    }

    /**
     * <P>
     *     inserting string <i>str</i> into the sequence at the <i>offset</i> index
     *     if str is null inserting "null"
     *     temp is storing the latest StringBuilder string. then try to insert if the action fails catching error and return
     *     if the action is successful we push temp into the Stack undoStack
     * </P>
     * @param offset the "starting index"
     * @param str the String to insert
     * @return reference to this object
     */
    @Override
    public UndoableStringBuilder insert(int offset, String str) {
        String temp = this.stringBuilder.toString();
        try{
            this.stringBuilder.insert(offset,str);
        }catch (StringIndexOutOfBoundsException e){
            System.out.println("index out of bounds "+e);
            return this;
        }
        this.undoStack.push(temp);
        return this;
    }

    /**
     * <P>
     *     delete string from the starting index to the end index and inserting str String from the start to the end of the string
     *     or to the ending of the sequence
     *     if the action fails catching error and return
     *     if the action is successful we push the temp into the {@code Stack} <i>undoStack</i>
     * </P>
     * @param start strating index
     * @param end ending idex
     * @param str the replacing string
     * @return a reference to this object
     */
    @Override
    public UndoableStringBuilder replace(int start, int end, String str){
        String temp = this.stringBuilder.toString();
        try {
            this.stringBuilder.replace(start, end, str);
        }catch (StringIndexOutOfBoundsException e){
            System.out.println("index out of bounds "+e);
            return this;
        }
        this.undoStack.push(temp);
        return this;
    }

    /**
     * reversing the sequence . for example "abc" -> "cba"
     * @return a reference to this object
     */
    @Override
    public UndoableStringBuilder reverse() {
        this.undoStack.push(this.stringBuilder.toString());
        this.stringBuilder.reverse();
        return this;
    }

    /**
     * reseting the stringBuilder
     * then pulling the latest string from the stack and appending the stringBuilder
     */
    public void undo() {
        if (undoStack.empty()) return;
        this.stringBuilder.delete(0,stringBuilder.length());
        this.stringBuilder.append(undoStack.pop());
    }

    /**
     * @return String
     */
    @Override
    public String toString() {
        return stringBuilder.toString();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
