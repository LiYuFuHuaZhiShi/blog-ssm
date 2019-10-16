package com.service.util;

import com.entity.Article;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class TimeSortUtil {
    private static TimeSortUtil timeSortUtil;

    @PostConstruct
    public void init() {
        timeSortUtil = this;
    }

    /**
     * 对时间list进行单独排序
     *
     * @param timeList
     */
    public void TimeSort(List<String> timeList) {
        //对时间进行排序
        Collections.sort(timeList, new Comparator<String>() {

            @Override
            public int compare(String s1, String s2) {
                /**
                 * 如果compare返回1，d1时间在d2之前
                 * compare返回0，d1等于d2
                 * compare返回-1，d1在d2之后
                 */
                try {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    Date d1 = sdf.parse(s1);
                    Date d2 = sdf.parse(s2);
                    if (d1.before(d2)) {
                        return 1;
                    }
                    if (d1.equals(d2)) {
                        return 0;
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                return -1;
            }
        });
    }

    /**
     * 按照时间对文章进行倒叙排序
     *
     * @param articles
     */
    public void ListSortByTime(List<Article> articles) {
        Collections.sort(articles, new Comparator<Article>() {
            /*
             * int compare(Article o1, Article o2) 返回一个基本类型的整型，
             * 返回正数表示：o1在o2之前,
             * 返回0 表示：o1和o2相等，
             * 返回负数表示：o1在o2之后
             */
            @Override
            public int compare(Article o1, Article o2) {
                if (o1.getTime().before(o2.getTime())) {
                    return 1;
                }
                if (o1.getTime().equals(o2.getTime())) {
                    return 0;
                }
                return -1;
            }
        });
    }


}
