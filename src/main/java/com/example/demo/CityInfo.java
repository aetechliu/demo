package com.example.demo;

import java.io.Serializable;

import lombok.Data;

/**
 * 都市 Entity
 */
@Data
public class CityInfo implements Serializable {
	//这里的名字要和CityMapper.xml中select中定义的一致。
    private String name;
    private String country;
}