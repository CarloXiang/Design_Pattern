package codeDesign.factory;

/**
 * 具体产品角色
 */
public class ConcreteProduct implements Product {
    @Override
    public void operate() {
        System.out.println("具体产品角色");
    }
}
