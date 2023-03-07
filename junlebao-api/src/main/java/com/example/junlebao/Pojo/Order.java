package com.example.junlebao.Pojo;

import lombok.ToString;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
@ToString
public class Order {
    public  Date date;
    public String shop;
    public int time_space;
    public String location;
}
