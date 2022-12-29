import org.junit.*;

import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.junit.runner.*;
import org.junit.runners.JUnit4;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(JUnit4.class)
public class ObserverTest{
    private UndoableStringBuilder usb;
    private GroupAdmin admin;
    private ConcreteMember []concreteMembers;
    public static final Logger logger = LoggerFactory.getLogger(ObserverTest.class);
    private static boolean firstRun = true;
    /**
     *Initalizing before each Test
     */
    @Before
    public void beforeEach(){
        System.out.println("Initializing Tests");
        logger.info(JvmUtilities::jvmInfo);
        usb = new UndoableStringBuilder();
        this.admin=new GroupAdmin();
        if (firstRun) {
            logger.info(() -> "Admin (Before Subscribers / registering users) = "
                    + JvmUtilities.objectTotalSize(this.admin));
            logger.info(() -> "FootPrint Admin (Before Subcribers / registering users) = "
                    + JvmUtilities.objectFootprint(this.admin));
            this.firstRun=false;
        }
        this.concreteMembers = new ConcreteMember[5];
        for (int i = 0; i < 5; i++) {
         this.concreteMembers[i]=new ConcreteMember();
         this.admin.register(concreteMembers[i]);
        }
    }

    /**
     * Testing Updates to members
     */
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
        logger.info(()->"UndoableStringBuilder = "+JvmUtilities.objectTotalSize(this.usb));
        logger.info(()->"Member 1 = "+JvmUtilities.objectTotalSize(this.concreteMembers[0]));
        logger.info(()->"Member 2 = "+JvmUtilities.objectTotalSize(this.concreteMembers[1]));
        logger.info(()->"Member 3 = "+JvmUtilities.objectTotalSize(this.concreteMembers[2]));
        logger.info(()->"Member 4 = "+JvmUtilities.objectTotalSize(this.concreteMembers[3]));
        logger.info(()->"Member 5 = "+JvmUtilities.objectTotalSize(this.concreteMembers[4]));
        logger.info(()->"Admin = "+JvmUtilities.objectTotalSize(this.admin)+"\n" +
                "All Members Contains the same UndoableStringBuilder Shallow Copy therefore they have equal Memory allocation");
    }

    /**
     * Testing members is registered
     */
    @Test
    public void register() {
        for (int i = 0; i < 5; i++) {
            assertTrue(this.admin.isRegistered(this.concreteMembers[i]));
        }
    }

    /**
     * Testing removing of members
     */
    @Test
    public void unregister() {
        logger.info(()->"Admin (contains all members) "+JvmUtilities.objectTotalSize(this.admin));
        logger.info(()->"FootPrint Admin = "+JvmUtilities.objectFootprint(this.admin));
        logger.info(()->"FootPrint Member 1 registered = "+JvmUtilities.objectFootprint(this.concreteMembers[0]));
        for (int i = 0; i < 5; i++) {
            this.admin.unregister(this.concreteMembers[i]);
            assertFalse(this.admin.isRegistered(this.concreteMembers[i]));
        }
        logger.info(()->"Admin (after removing all members) = "+JvmUtilities.objectTotalSize(this.admin));
        logger.info(()->"FootPrint Admin = "+JvmUtilities.objectFootprint(this.admin));
        logger.info(()->"FootPrint Member 1 unregistered = "+JvmUtilities.objectFootprint(this.concreteMembers[0]));
    }

    /**
     * Testing actions on UndoableStringBuilders
     * also tests notfiyMembers - updating all members shallow copy of the UndoableStringBuilder in GroupAdmin after each change
     */
    @Test
    public void undoableStringBuilderActions() {
        //append Testing
        this.admin.append("abc");
        logger.info(()->"Admin Totalsize (usb =abc) = "+JvmUtilities.objectTotalSize(this.admin));
        assertEquals("abc",this.admin.toString());
        for (int i = 0; i < 5; i++) {
            assertEquals(this.admin.toString(),this.concreteMembers[i].toString());
        }
        //insert Testing
        this.admin.insert(2,"123");
        logger.info(()->"Admin Totalsize (usb =ab123c) = "+JvmUtilities.objectTotalSize(this.admin));
        assertEquals("ab123c",this.admin.toString());
        for (int i = 0; i < 5; i++) {
            assertEquals(this.admin.toString(),this.concreteMembers[i].toString());
        }
        //delete Testing
        this.admin.delete(2,5);
        logger.info(()->"Admin Totalsize (usb =abc) = "+JvmUtilities.objectTotalSize(this.admin));
        assertEquals("abc",this.admin.toString());
        for (int i = 0; i < 5; i++) {
            assertEquals(this.admin.toString(),this.concreteMembers[i].toString());
        }
        //undo Testing
        this.admin.undo();
        logger.info(()->"Admin Totalsize (usb =ab123c) = "+JvmUtilities.objectTotalSize(this.admin));
        assertEquals("ab123c",this.admin.toString());
        for (int i = 0; i < 5; i++) {
            assertEquals(this.admin.toString(),this.concreteMembers[i].toString());
        }
    }
}

