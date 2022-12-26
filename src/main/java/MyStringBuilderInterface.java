public interface MyStringBuilderInterface {
    public UndoableStringBuilder append(String str);
    public UndoableStringBuilder delete(int start, int end);
    public UndoableStringBuilder insert(int offset, String str);
    public UndoableStringBuilder replace(int start, int end, String str);
    public UndoableStringBuilder reverse();
}
