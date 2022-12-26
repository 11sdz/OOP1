public class Main {
    public static void main(String[] args) {
        GroupAdmin observer = new GroupAdmin();
        Member mem1 = new Member("member1");
        Member mem2 = new Member("member2");

        observer.register(mem1);
        observer.register(mem2);

        observer.append("abc");
        observer.insert(1,"efg");

        System.out.println(mem1);
        System.out.println(mem2);

        observer.undo();
        System.out.println(mem1);
        System.out.println(mem2);
    }
}
