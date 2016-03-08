package codeDesign.decorator;

import java.util.List;

/**
 * 具体装饰器-扩展新闻组件：给新闻添加人气的方法类
 */
public class ConcreteDecoratorAddAmount extends DecoratorNews {
    public ConcreteDecoratorAddAmount(ComponentNews componentNews) {
        super(componentNews);
    }

    public void addAmount() {
        // 新闻人气加一
        System.out.println("新闻人气已经加一");
    }

    @Override
    public List<News> getListOfNews() {
        addAmount();
        return super.getListOfNews();
    }
}
