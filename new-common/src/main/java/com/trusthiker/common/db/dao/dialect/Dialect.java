package com.trusthiker.common.db.dao.dialect;

import com.trusthiker.common.db.dao.complexQuery.Sort;

import java.util.List;

/**
 * 数据库方言。
 * Created by unknown
 * Modify by com.trusthiker.common
 */
public abstract class Dialect {

    public abstract String addLimitString(String sql, int skipResults, int maxResults);

    public abstract String addSortString(String sql, List<Sort> sortList);

}