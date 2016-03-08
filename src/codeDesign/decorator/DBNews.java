package codeDesign.decorator;

import java.util.ArrayList;
import java.util.List;

/**
 * 基于数据库读取新闻的类
 */
public class DBNews extends ComponentNews{
    @Override
    public List<News> getListOfNews() {
        List<News> list = new ArrayList<News>();
        System.out.println("从数据库中取得数据填充到list中");
        return list;
    }
}
