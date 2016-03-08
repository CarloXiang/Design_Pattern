package codeDesign.decorator;

public class Client {
    public static void main(String[] args) {
        // 数据方式获取新闻
        ComponentNews componentNews = new DBNews();
        // 扩展了展示新闻标题同时增加新闻人气的方法
        DecoratorNews decoratorNews = new ConcreteDecoratorAddAmount(componentNews);
        // 扩展了展示新闻标题同时将新闻标题加入RSS中的方法
        decoratorNews = new ConcreteDecoratorAddRss(decoratorNews);
        decoratorNews.getListOfNews();
    }
}
