package com.itheima.test;

import com.itheima.pojo.Items;
import com.itheima.service.Impl.ItemsServiceImpl;
import com.itheima.service.ItemsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/*@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-service.xml")*/
public class ItemsServiceImplTest {
  /*  @Autowired
    private ItemsServiceImpl is;*/
    @Test
    public void save(){
        /*
        配置AOP之后，
         ItemsService itemsService = (ItemsService) applicationContext.getBean("itemsServiceImpl");
         得到的itemsService是代理对象
        */
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-service.xml");
        ItemsService itemsService = (ItemsService) applicationContext.getBean("itemsServiceImpl");
        System.out.println("itemsService = " + itemsService);
        Items items = new Items();
        items.setName("测试事务");
        itemsService.save(items);

       /* System.out.println("is = " + is);
        Items items = new Items();
        items.setName("测试事务3");
        is.save(items);
*/

     }

}
