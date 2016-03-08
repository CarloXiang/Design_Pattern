package codeDesign.decorator;

import java.util.List;

/**
 * 组件对象的接口，可以给这些对象动态的添加职责
 */
public abstract class ComponentNews {
    public abstract List<News> getListOfNews();
}
