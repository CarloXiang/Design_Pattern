package codeDesign.adapter2;

// 测试类
public class Client {
    public static void main(String[] args) {
        // 使用普通功能类
        Target concreteTarget = new ConcreteTarget();
        concreteTarget.request();

        // 使用特殊功能类，即适配器类
        // 需要先创建一个被适配器类的对象作为参数
        Target adapter = new Adapter(new Adaptee());
        adapter.request();
    }
}
