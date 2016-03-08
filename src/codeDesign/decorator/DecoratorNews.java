package codeDesign.decorator;

import java.util.List;

/**
 * 抽象装饰类-所有装饰器的父类
 */
public abstract class DecoratorNews extends ComponentNews {
    private ComponentNews componentNews;

    public DecoratorNews(ComponentNews componentNews) {
        this.componentNews = componentNews;
    }

    @Override
    public List<News> getListOfNews() {
        return componentNews.getListOfNews();
    }

}
