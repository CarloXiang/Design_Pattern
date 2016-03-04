package codeDesign.factory2;

// 具体产品角色
public class Broom implements Moveable {
    @Override
    public void run() {
        System.out.printf("broom....");
    }
}
