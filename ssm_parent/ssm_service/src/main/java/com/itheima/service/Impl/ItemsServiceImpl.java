package com.itheima.service.Impl;

import com.itheima.dao.ItemsDao;
import com.itheima.pojo.Items;
import com.itheima.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ItemsServiceImpl implements ItemsService {
    @Autowired
    private ItemsDao itemsDao;

    public List<Items> findAll() {
        return itemsDao.findAll();
    }

    public int save(Items items) {
        int raw = itemsDao.save(items);

        //人为制造出错，测试是否回滚；
        //int a=5/0;
        System.out.println("raw = " + raw);
        return raw;
    }
}
