package com.example.junlebao.Dao;

import com.example.junlebao.Pojo.Order;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface OrderDao {

    @Select("select min(date) as date,shop,datediff(now(),min(date)) as time_space from db02.order group by shop")
    @Results({
            @Result(column = "shop",property = "shop"),
            @Result(column = "shop", property = "location",
                    one = @One(select = "com.example.junlebao.Dao.OrderDao.getLocationByShop")),
    })
    List<Order> getOrders();

    @Select("select location from db02.shop where name=#{shop}")
    String getLocationByShop(String shop);

    @Insert("insert into db02.order(shop,date) values(#{shop},#{date})")
    void addOrder(Order order);

    @Delete("delete from db02.order where shop = #{shop}")
    void delOrderByshop(String shop);



}
