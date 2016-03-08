package codeDesign.decorator;

import java.util.List;

/**
 * 具体装饰器-把新闻加入到RSS中
 */
public class ConcreteDecoratorAddRss extends DecoratorNews {
    public ConcreteDecoratorAddRss(ComponentNews componentNews) {
        super(componentNews);
    }

    public void addRss() {
        // 新闻标题已经被RSS收录
        System.out.println("新闻标题已经加入到RSS中");
    }

    @Override
    public List<News> getListOfNews() {
        // 此处添加扩展代码；将新闻标题加入到RSS中
        addRss();
        return super.getListOfNews();
    }
}
