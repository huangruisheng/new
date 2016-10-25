package com.trusthiker.common.db.dao.dialect;

import com.trusthiker.common.db.dao.complexQuery.Sort;

import java.util.List;

/**
 * @author com.trusthiker.common
 */
public class H2Dialect extends Dialect {

	@Override
	public String addLimitString(String sql, int offset, int limit) {
		return MySql5PageHepler.addLimitString(sql, offset, limit);
	}

    @Override
    public String addSortString(String sql, List<Sort> sortList) {
        return SortHelper.addSortString(sql, sortList);
    }

}