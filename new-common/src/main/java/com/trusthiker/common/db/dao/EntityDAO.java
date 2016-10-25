package com.trusthiker.common.db.dao;

import com.trusthiker.common.db.dao.complexQuery.CustomQueryParam;
import com.trusthiker.common.db.dao.complexQuery.Sort;
import com.trusthiker.common.db.dao.impl.mybatis.BaseSQLProvider;
import com.trusthiker.common.db.model.Entity;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
rui
 */
public interface EntityDAO<T extends Entity> {

    @SelectProvider(type = BaseSQLProvider.class, method = "getAll")
    @ResultMap("getMap")
    public List<T> getAll();

    @SelectProvider(type = BaseSQLProvider.class, method = "getById")
    @ResultMap("getMap")
    public T getById(Object id);

    @SelectProvider(type = BaseSQLProvider.class, method = "get")
    @ResultMap("getMap")
    public T getOne(@Param("findParams") T findParams);

    @SelectProvider(type = BaseSQLProvider.class, method = "countGet")
    public int countGet(@Param("findParams") T findParams);

    @SelectProvider(type = BaseSQLProvider.class, method = "get")
    @ResultMap("getMap")
    public List<T> get(@Param("findParams") T findParams);

    @SelectProvider(type = BaseSQLProvider.class, method = "get")
    @ResultMap("getMap")
    public List<T> get(@Param("findParams") T findParams, @Param("sortList") List<Sort> sortList, @Param("start") Integer start, @Param("limit") Integer limit);

    @SelectProvider(type = BaseSQLProvider.class, method = "countFind")
    public int countFind(@Param("findParams") T findParams);

    @SelectProvider(type = BaseSQLProvider.class, method = "find")
    @ResultMap("getMap")
    public List<T> find(@Param("findParams") T findParams);

    @SelectProvider(type = BaseSQLProvider.class, method = "find")
    @ResultMap("getMap")
    public List<T> find(@Param("findParams") T findParams, @Param("sortList") List<Sort> sortList, @Param("start") Integer start, @Param("limit") Integer limit);

    @SelectProvider(type = BaseSQLProvider.class, method = "countQuery")
    public int countQuery(@Param("queryParams") List<CustomQueryParam> customQueryParams);

    @SelectProvider(type = BaseSQLProvider.class, method = "query")
    @ResultMap("getMap")
    public List<T> query(@Param("queryParams") List<CustomQueryParam> customQueryParams, @Param("sortList") List<Sort> sortList);

    @SelectProvider(type = BaseSQLProvider.class, method = "query")
    @ResultMap("getMap")
    public List<T> query(@Param("queryParams") List<CustomQueryParam> customQueryParams, @Param("sortList") List<Sort> sortList, @Param("start") Integer start, @Param("limit") Integer limit);

    @InsertProvider(type = BaseSQLProvider.class, method = "insert")
    public int insert(T t);

    @DeleteProvider(type = BaseSQLProvider.class, method = "delete")
    public int delete(Object id);

    @UpdateProvider(type = BaseSQLProvider.class, method = "update")
    public int update(T t);

    public int generateId();

}
