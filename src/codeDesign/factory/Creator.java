package codeDesign.factory;

/**
 * 工厂类角色
 */
public class Creator {
    public static Product factory(String type) {
        Product product = null;
        if ("product".equals(type)) {
            product = new ConcreteProduct();
        } else if ("product2".equals(type)) {
            product = new ConcreteProduct2();
        }
        return product;
    }
}
