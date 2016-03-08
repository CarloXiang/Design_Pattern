package codeDesign.observer;

public class Client {
    public static void main(String[] args) {
        // 创建主题对象
        ConcreteSubject concreteSubject = new ConcreteSubject();
        // 创建观察者对象
        ConcreteObserver concreteObserver = new ConcreteObserver();
        // 将观察者对象登记到主题对象上
        concreteSubject.attach(concreteObserver);
        // 改变主题对象的状态
        concreteSubject.change("new state");
    }
}
