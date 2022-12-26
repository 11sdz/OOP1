import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class UndoableStringBuilderTest {
    /**
     Test UndoableStringBuilder function append()
     */
    @org.junit.jupiter.api.Test
    void append() {
        UndoableStringBuilder usb1 = new UndoableStringBuilder();
        assertEquals("",usb1.toString());
        usb1.append("a");
        assertEquals("a",usb1.toString());
        usb1.append("b");
        assertEquals("ab",usb1.toString());
        usb1.append("c");
        assertNotEquals("abZ",usb1.toString());
        assertEquals(usb1.toString().length(),3);
        usb1.append(null);
        assertEquals("abcnull",usb1.toString());
    }
    /**
     Test UndoableStringBuilder function insert(int start,int end,String str)
     */
    @org.junit.jupiter.api.Test
    void delete() {
        UndoableStringBuilder usb1 = new UndoableStringBuilder();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        usb1.delete(13,22);
        String expectedOut = "java.lang.StringIndexOutOfBoundsException:";
        assertTrue(outContent.toString().contains(expectedOut));

        usb1.append("abcdefg");
        usb1.delete(1,3);
        assertNotEquals("abcdefg",usb1.toString());
        assertEquals("adefg",usb1.toString());
        assertEquals(usb1.toString().length(),5);
        usb1.delete(0,5);
        assertEquals("",usb1.toString());
        assertEquals(0,usb1.toString().length());
    }
    /**
    Test UndoableStringBuilder function insert(int offset,String str)
     */
    @org.junit.jupiter.api.Test
    void insert() {
        UndoableStringBuilder usb1 = new UndoableStringBuilder();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        usb1.insert(1,"abc");
        String expectedOut = "java.lang.StringIndexOutOfBoundsException:";
        assertTrue(outContent.toString().contains(expectedOut));

        usb1.append("123456789");
        usb1.insert(3,"abc");
        assertEquals("123abc456789",usb1.toString());
        assertEquals(12,usb1.toString().length());
        usb1.insert(3,null);
        assertEquals("123nullabc456789",usb1.toString());
    }
    /**
     Test UndoableStringBuilder function replace(int start,int end,String str)
     */
    @org.junit.jupiter.api.Test
    void replace() {
        UndoableStringBuilder usb1 = new UndoableStringBuilder();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        usb1.replace(1,4,"abc");
        String expectedOut = "java.lang.StringIndexOutOfBoundsException:";
        assertTrue(outContent.toString().contains(expectedOut));

        usb1.append("123456789");
        usb1.replace(0,3,"abc");
        assertEquals("abc456789",usb1.toString());
        usb1.replace(4,8,"0");
        assertEquals("abc409",usb1.toString());

    }
    /**
     Test UndoableStringBuilder function reverse()
     */
    @org.junit.jupiter.api.Test
    void reverse() {
        UndoableStringBuilder usb1 = new UndoableStringBuilder();
        usb1.append("gfedcba");
        usb1.reverse();
        assertEquals("abcdefg",usb1.toString());
        assertEquals("abcdefg".length(),usb1.toString().length());
    }
    /**
     Test UndoableStringBuilder function undo()
     */
    @org.junit.jupiter.api.Test
    void undo() {
        UndoableStringBuilder usb1 = new UndoableStringBuilder();
        usb1.append("abcdefg");
        usb1.append("012345");
        usb1.delete(0,2);
        usb1.insert(5,null);
        usb1.reverse();
        usb1.replace(0,3,"<3");
        assertEquals("<3210llungfedc",usb1.toString());
        usb1.undo();
        assertEquals("543210llungfedc",usb1.toString());
        usb1.undo();
        assertEquals("cdefgnull012345",usb1.toString());
        usb1.undo();
        assertEquals("cdefg012345",usb1.toString());
        usb1.undo();
        assertEquals("abcdefg012345",usb1.toString());
        usb1.undo();
        assertEquals("abcdefg",usb1.toString());
        usb1.undo();
        assertEquals(usb1.toString(),"");
        usb1.undo();
        assertEquals("",usb1.toString());
    }

    /**
    Testing given Main from the PDF
*/
    @org.junit.jupiter.api.Test
    void exampleMain(){
        UndoableStringBuilder usb = new UndoableStringBuilder();
        usb.append("to be or not to be") ;
        assertEquals("to be or not to be",usb.toString());
        usb.replace(3, 5, "eat") ;
        assertEquals("to eat or not to be",usb.toString());
        usb.replace(17, 19, "eat") ;
        assertEquals("to eat or not to eat",usb.toString());
        usb.reverse();
        assertEquals("tae ot ton ro tae ot",usb.toString());
        usb.undo ();
        assertEquals("to eat or not to eat",usb.toString());
        usb.undo ();
        assertEquals("to eat or not to be",usb.toString());
        usb.undo();
        assertEquals("to be or not to be",usb.toString());
    }
    /**
     Test UndoableStringBuilder function toString()
     */
    @org.junit.jupiter.api.Test
    void testToString() {
        UndoableStringBuilder usb1 = new UndoableStringBuilder();
        usb1.append("abcdefg");
        assertEquals("abcdefg",usb1.toString());
        usb1.append(null);
        assertEquals("abcdefgnull",usb1.toString());
    }
}