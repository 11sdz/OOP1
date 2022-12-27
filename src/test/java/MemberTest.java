import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MemeberTest {

    Member m = new Member("m1");
    UndoableStringBuilder usb = new UndoableStringBuilder();

    @Test
    void MemberTest() {
        assertEquals("m1", m.getName());
    }

    @Test
    void updateTest(UndoableStringBuilder usb) {
        usb.append("Hi");
        m.update(usb);
        assertEquals("Member= m1 usbShallowCopy= Hi", m.toString());
      
        usb.append("Hello");
        m.update(usb);
        assertEquals("Member= m1 usbShallowCopy= HiHello", m.toString());
    }

}
