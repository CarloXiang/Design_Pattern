package codeDesign.decorator;

import java.util.ArrayList;
import java.util.List;

/**
 * 基于XML读取新闻
 */
public class XMLNews extends ComponentNews{
    @Override
    public List<News> getListOfNews() {
        List<News> list = new ArrayList<News>();
        System.out.println("从XML中取得数据填充到list中");
        return list;
    }
}
