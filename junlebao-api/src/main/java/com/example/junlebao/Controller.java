package com.example.junlebao;

import com.alibaba.fastjson.JSONObject;
import com.example.junlebao.Dao.OrderDao;
import com.example.junlebao.Dao.ShopDao;
import com.example.junlebao.Pojo.Location;
import com.example.junlebao.Pojo.Order;
import com.example.junlebao.Pojo.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class Controller {
    @Autowired
    OrderDao orderDao;
    @Autowired
    ShopDao shopDao;

    @PostMapping("getLocationsCascader")
    public List<Location> getLocations(){

        return shopDao.getLocations_Cascader();
    }
    @PostMapping("getShopsList")
    public List<Shop> getShopsList(){
         return shopDao.getShopsList();
    }
    @PostMapping("getOrders")
    public List<Order> getShopList(){
         return orderDao.getOrders();
    }
    @PostMapping("addShop")
    public void addShop(@RequestBody Shop shop){
        shopDao.addShop(shop);
    }
    @PostMapping("addOrder")
    public void addOrder(@RequestBody Order order){
        orderDao.delOrderByshop(order.shop);
        orderDao.addOrder(order);
    }
    @PostMapping("delShop")
    public void delShop(@RequestBody JSONObject json){
        String name = json.getString("name");
        orderDao.delOrderByshop(name);
        shopDao.delShopByname(name);
    }



}
