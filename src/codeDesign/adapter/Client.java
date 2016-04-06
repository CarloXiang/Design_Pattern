package codeDesign.adapter;

// 测试类
public class Client {
    public static void main(String[] args) {
        // 使用普通功能类
        Target concreteTarget = new ConcreteTarget();
        concreteTarget.request();

        // 使用特殊功能，即适配类
        Target adapter = new Adapter();
        adapter.request();
    }
}
