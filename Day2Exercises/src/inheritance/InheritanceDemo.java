package inheritance;


class Parent{
    public final void test(){
        System.out.println("Parent : test");
    }
}

class Child extends Parent{
    public void test2(){
        test();
    }
}


public class InheritanceDemo {
    public static void main(String[] args) {
        Parent p = new Parent();
        p.test();
    }
}
