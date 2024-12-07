package com.example.service;

import cn.hutool.core.date.DateUtil;
import com.example.entity.Area;
import com.example.entity.Film;
import com.example.mapper.AreaMapper;
import com.example.mapper.FilmMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import cn.hutool.json.JSONUtil;
import cn.hutool.core.util.ObjectUtil;
import com.example.entity.Type;
import com.example.mapper.TypeMapper;
import java.util.ArrayList;

import java.util.List;

/**
 * 业务层方法
 */
@Service
public class FilmService {

    @Resource
    private FilmMapper filmMapper;
    @Resource
    private TypeMapper typeMapper;
    @Resource
    private AreaMapper areaMapper;

    public void add(Film film) {
        film.setTypeIds(JSONUtil.toJsonStr(film.getIds()));
        filmMapper.insert(film);
    }

    public void updateById(Film film) {
        film.setTypeIds(JSONUtil.toJsonStr(film.getIds()));
        filmMapper.updateById(film);
    }


    public void deleteById(Integer id) {
        filmMapper.deleteById(id);
    }

    public void deleteBatch(List<Integer> ids) {
        for (Integer id : ids) {
            filmMapper.deleteById(id);
        }
    }

    public Film selectById(Integer id) {
        Film film = filmMapper.selectById(id);
        List<Integer> ids = JSONUtil.toList(film.getTypeIds(), Integer.class);
        List<String> tmpList = new ArrayList<>();
        for (Integer typeId : ids) {
            Type type = typeMapper.selectById(typeId);
            if (ObjectUtil.isNotEmpty(type)) {
                tmpList.add(type.getTitle());
            }
        }
        Area area = areaMapper.selectById(film.getAreaId());
        if (ObjectUtil.isNotEmpty(area)) {
            film.setAreaName(area.getTitle());
        }
        film.setTypes(tmpList);
        return film;
    }

    public List<Film> selectAll(Film film) {
        return filmMapper.selectAll(film);
    }

    public PageInfo<Film> selectPage(Film film, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Film> list = filmMapper.selectAll(film);
        for (Film dbFilm : list) {
            List<Integer> ids = JSONUtil.toList(dbFilm.getTypeIds(), Integer.class);
            dbFilm.setIds(ids);
            List<String> tmpList = new ArrayList<>();
            for (Integer typeId : ids) {
                Type type = typeMapper.selectById(typeId);
                if (ObjectUtil.isNotEmpty(type)) {
                    tmpList.add(type.getTitle());
                }
            }
            dbFilm.setTypes(tmpList);
        }
        return PageInfo.of(list);
    }

}