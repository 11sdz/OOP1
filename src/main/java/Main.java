public class Main {
    public static void main(String[] args) {
        GroupAdmin observer = new GroupAdmin();
        Member mem1 = new Member();
        Member mem2 = new Member();
        Member mem3 = new Member();
        Member mem4 = new Member();
        Member mem5 = new Member();
        Member mem6 = new Member();

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
    }
}
