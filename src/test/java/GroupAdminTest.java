import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GroupAdminTest {

    Member m = new Member("m1");
    UndoableStringBuilder usb = new UndoableStringBuilder();


    @Test
    void registerTest() {
        usb.register(m);
        assertEquals(true, usb.containsObserver(m));
    }

    @Test
    void unregisterTest() {
        usb.register(m);
        usb.unregister(m);
        assertEquals(false, usb.containsObserver(m));
    }

    @Test
    // Check the register function doesn't save a member twice
    void registerTest2() {
        usb.register(m);
        usb.register(m);
        usb.unregister(m);
        assertEquals(false, usb.containsObserver(m));
    }

    @Test
    void notifyMembersTest(){
        usb.register(m);
        usb.append("Hi");
        assertEquals(usb, m.getUsbShallowCopy());
    }
}
