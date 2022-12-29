import org.junit.*;

import org.junit.runner.*;
import org.junit.runners.JUnit4;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(JUnit4.class)
public class ObserverTest{
    private UndoableStringBuilder usb;
    private GroupAdmin admin;
    private ConcreteMember []concreteMembers;
    @Before
    public void beforeEach(){
        usb = new UndoableStringBuilder();
        this.admin=new GroupAdmin();
        this.concreteMembers = new ConcreteMember[5];
        for (int i = 0; i < 5; i++) {
         this.concreteMembers[i]=new ConcreteMember();
         this.admin.register(concreteMembers[i]);
        }
    }

    @Test
    public void update() {
        this.usb.append("abc");
        for (int i = 0; i < 5; i++) {
            assertEquals("",this.concreteMembers[i].toString());
            this.concreteMembers[i].update(this.usb);
        }
        for (int i = 0; i < 5; i++) {
            assertEquals(this.concreteMembers[i].toString(),this.usb.toString());
        }
    }

    @Test
    public void register() {
        for (int i = 0; i < 5; i++) {
            assertTrue(this.admin.isRegistered(this.concreteMembers[i]));
        }

    }

    @Test
    public void unregister() {
        for (int i = 0; i < 5; i++) {
            this.admin.unregister(this.concreteMembers[i]);
            assertFalse(this.admin.isRegistered(this.concreteMembers[i]));
        }
    }

    @Test
    public void undoableStringBuilderActions() {
        //append Testing
        this.admin.append("abc");
        assertEquals("abc",this.admin.toString());
        for (int i = 0; i < 5; i++) {
            assertEquals(this.admin.toString(),this.concreteMembers[i].toString());
        }
        //insert Testing
        this.admin.insert(2,"123");
        assertEquals("ab123c",this.admin.toString());
        for (int i = 0; i < 5; i++) {
            assertEquals(this.admin.toString(),this.concreteMembers[i].toString());
        }
        //delete Testing
        this.admin.delete(2,5);
        assertEquals("abc",this.admin.toString());
        for (int i = 0; i < 5; i++) {
            assertEquals(this.admin.toString(),this.concreteMembers[i].toString());
        }
        //undo Testing
        this.admin.undo();
        assertEquals("ab123c",this.admin.toString());
        for (int i = 0; i < 5; i++) {
            assertEquals(this.admin.toString(),this.concreteMembers[i].toString());
        }
    }
}

