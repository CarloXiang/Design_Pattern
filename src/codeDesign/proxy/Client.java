package codeDesign.proxy;

/**
 * 测试类
 */
public class Client {
    public static void main(String[] args) {
        Subject subject = new RealSubject();
        Proxy proxy = new Proxy(subject);
        proxy.operate();
    }
}
