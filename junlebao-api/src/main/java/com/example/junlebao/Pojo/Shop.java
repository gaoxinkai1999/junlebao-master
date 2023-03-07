package com.example.junlebao.Pojo;

import lombok.ToString;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ToString
public class Shop {
   public String location;
   public String name;
   public List<Order> orders;



}
