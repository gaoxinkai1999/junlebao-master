package com.example.junlebao.Pojo;

import lombok.ToString;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ToString
public class Location {
    public String name;
    public List<Shop> shops;

}
