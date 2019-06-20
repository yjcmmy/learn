package inner;
 //编译器在进行编译的时候，会将成员内部类单独编译成一个字节码文件
//cd C:\Code\learn\JVM\out\production\JVM
//javap -v inner.Outter$Inner
public class Outter {
    private Inner inner = null;
    public Outter() {

    }

    public Inner getInnerInstance() {
        if(inner == null)
            inner = new Inner();
        return inner;
    }

    protected class Inner {
        public Inner() {

        }
    }
}