package com.itheima.test;

import com.itheima.dao.ItemsDao;
import com.itheima.pojo.Items;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class DaoTest {
    @Test
    public void findAll(){
        //创建容器对象
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-mybatis.xml");
        //从容器对象中获取Dao
        ItemsDao itemsDao = context.getBean(ItemsDao.class);
        //使用Dao实现增加，查询
        List<Items> list = itemsDao.findAll();
        for (Items items : list) {
            System.out.println(items);
        }
    }

    @Test
    public void addItems() throws ParseException {
        //创建容器对象
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-mybatis.xml");
        //从容器对象中获取Dao
        ItemsDao itemsDao = context.getBean(ItemsDao.class);
        //使用Dao实现增加，查询
       Items items = new Items();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr="2010-10-10";
        Date date=sdf.parse(dateStr);
        items.setName("李四");
       items.setPrice(2000.0668899F);
       items.setPic("秋天的第一张照片.JPG");
       items.setCreatetime(date);
       items.setDetail("键盘敲烂，月薪过万");
       int raw = itemsDao.save(items);
    }
}
