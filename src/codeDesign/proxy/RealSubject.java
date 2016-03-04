package codeDesign.proxy;

/**
 * 具体主题
 */
public class RealSubject implements Subject {
    @Override
    public void operate() {
        System.out.printf("realsubject operate started...");
    }
}
