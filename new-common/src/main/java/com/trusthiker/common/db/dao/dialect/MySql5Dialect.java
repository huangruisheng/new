package com.trusthiker.common.db.dao.dialect;

import com.trusthiker.common.db.dao.complexQuery.Sort;

import java.util.List;

/**
 * Created by unknown
 * Modify by com.trusthiker.common
 */
public class MySql5Dialect extends Dialect {

	public String getLimitString(String sql, boolean hasOffset) {
		return MySql5PageHepler.addLimitString(sql, -1, -1);
	}

	@Override
	public String addLimitString(String sql, int offset, int limit) {
		return MySql5PageHepler.addLimitString(sql, offset, limit);
	}

    @Override
    public String addSortString(String sql, List<Sort> sortList) {
        return SortHelper.addSortString(sql, sortList);
    }

    public boolean supportsLimit() {
		return true;
	}

}