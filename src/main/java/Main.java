public class Main {
    public static void main(String[] args) {
        GroupAdmin observer = new GroupAdmin();
        System.out.println(observer);
        ConcreteMember mem1 = new ConcreteMember();
        ConcreteMember mem2 = new ConcreteMember();
        ConcreteMember mem3 = new ConcreteMember();
        ConcreteMember mem4 = new ConcreteMember();
        ConcreteMember mem5 = new ConcreteMember();
        ConcreteMember mem6 = new ConcreteMember();

        System.out.println(mem1);

        observer.register(mem1);
        observer.register(mem2);

        observer.append("abc");
        observer.insert(1,"efg");

        observer.register(mem3);
        observer.register(mem4);

        observer.append("123");

        observer.register(mem5);
        observer.register(mem6);

        System.out.println(mem1);
        System.out.println(mem2);
        System.out.println(mem3);
        System.out.println(mem4);
        System.out.println(mem5);
        System.out.println(mem6);

        observer.undo();
        observer.unregister(mem1);
        observer.unregister(mem6);

        System.out.println(mem1);
        System.out.println(mem2);
        System.out.println(mem3);
        System.out.println(mem4);
        System.out.println(mem5);
        System.out.println(mem6);

        System.out.println(observer);
    }
}
