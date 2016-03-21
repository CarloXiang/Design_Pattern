package codeDesign.strategy;

/**
 * 价格类
 */
public class Price {
    // 持有一个具体的策略对象
    private MemberStrategy strategy;

    /**
     * 构造函数，传入一个具体的策略对象
     * @param strategy 具体的策略对象
     */
    public Price(MemberStrategy strategy) {
        this.strategy = strategy;
    }

    public double quote(double booksPrice) {
        return strategy.calcPrice(booksPrice);
    }
}
