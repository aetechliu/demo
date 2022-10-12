package com.example.demo;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CityMapper {

    /**
     * ユーザー情報全件検索
     * @param user 検索用リクエストデータ
     * @return 検索結果
     */
    List<CityInfo> allCity();
    
}

  
