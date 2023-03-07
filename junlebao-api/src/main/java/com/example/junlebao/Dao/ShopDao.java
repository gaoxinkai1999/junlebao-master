package com.example.junlebao.Dao;

import com.example.junlebao.Pojo.Location;
import com.example.junlebao.Pojo.Shop;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ShopDao {
    @Select("select * from db02.shop group by location")
    @Results({
            @Result(column = "location", property = "name"),
            @Result(
                    property = "shops",
                    column = "location",
                    javaType = List.class,
                    many = @Many(select = "com.example.junlebao.Dao.ShopDao.getShopByLocation")
            )
    })
    List<Location> getLocations_Cascader();

    @Select("select * from db02.shop where location =#{location}")
    List<Shop> getShopByLocation(String location);


    @Select("select * from db02.shop")
    List<Shop>getShopsList();

    @Insert("insert into db02.shop(name,location) values(#{name},#{location})")
    void addShop(Shop shop);

    @Delete("delete from db02.shop where name = #{name}")
    void delShopByname(String name);

}
