package codeDesign.factory;

/**
 * 简单工厂模式 测试类
 */
public class factoryTest {
    public static void main(String[] args) {
        Product product = Creator.factory("product");
        product.operate();
    }
}
