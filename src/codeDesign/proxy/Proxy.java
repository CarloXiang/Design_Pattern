package codeDesign.proxy;

/**
 * 代理类
 */
public class Proxy implements Subject {

    private Subject subject;

    public Proxy() {
        this.subject = new RealSubject();
    }

    @Override
    public void operate() {
        System.out.printf("before operate......");
        subject.operate();
        System.out.printf("after operate......");
    }
}
