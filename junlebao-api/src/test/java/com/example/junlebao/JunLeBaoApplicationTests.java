package com.example.junlebao;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.junlebao.Dao.OrderDao;
import com.example.junlebao.Dao.ShopDao;
import com.example.junlebao.Pojo.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class JunLeBaoApplicationTests {


@Autowired
    ShopDao shopDao;
@Autowired
    OrderDao orderDao;
    @Test
    void contextLoads() {
        List<Order> orders = orderDao.getOrders();
        JSONArray objects = JSONArray.parseArray(JSONObject.toJSONString(orders));
        System.out.println(objects);

    }

}
