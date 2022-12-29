import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
public class ObserverTest {
    class GroupAdminTest{
        GroupAdmin admin;
        ConcreteMember []concreteMembers = new ConcreteMember[5];
        @BeforeEach
        static void beforeAll() {
            GroupAdmin admin = new GroupAdmin();
            ConcreteMember []concreteMembers = new ConcreteMember[5];
            for (int i = 0; i < 5; i++) {
                concreteMembers[i]=new ConcreteMember();
            }
        }

        @Test
        void register(){
            for (int i = 0; i < 5; i++) {
                admin.register(concreteMembers[i]);
            }
            for (int i = 0; i < 5; i++) {

            }
        }
    }
    class ConcreteMemberTest{

    }
}
