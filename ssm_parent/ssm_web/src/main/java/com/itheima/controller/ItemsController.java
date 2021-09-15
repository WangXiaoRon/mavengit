package com.itheima.controller;

import com.itheima.pojo.Items;
import com.itheima.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value ="/items")
public class ItemsController {

    @Autowired
    private ItemsService itemsService;

    /**
     * 列表访问
     * @param model
     * @returnl
     */
    @RequestMapping(value ="/list")
    public String list(Model model){
        System.out.println("来到了itemsController的list方法中...");
        //聚合查询
        List<Items> items = itemsService.findAll();
        for (Items item : items) {
            System.out.println(item);
        }
       //存入回显
        model.addAttribute("items",items);
        return "items";
    }

    /**
     * 事务测试增加商品
     * @param items
     * @return
     */
    @RequestMapping(value ="/save")
    public String save(Items items){
        try {
            int raw = itemsService.save(items);
            if(raw>0){
                return "redirect:/items/list";

            }
            return "redirect:/error.jsp";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/error.jsp";
        }
    }
}
