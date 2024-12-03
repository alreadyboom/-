package com.example.mapper;

import com.example.entity.Film;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface FilmMapper {

    int insert(Film film);

    void updateById(Film film);

    void deleteById(Integer id);

    @Select("select * from `film` where id = #{id}")
    Film selectById(Integer id);

    List<Film> selectAll(Film film);

}
