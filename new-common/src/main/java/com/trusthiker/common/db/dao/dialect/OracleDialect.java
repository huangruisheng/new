package com.trusthiker.common.db.dao.dialect;

import com.trusthiker.common.db.dao.complexQuery.Sort;

import java.util.List;

/**
 * Created by unknown
 * Modify by com.trusthiker.common
 */
public class OracleDialect extends Dialect {

	@Override
	public String addLimitString(String sql, int offset, int limit) {
		sql = sql.trim();
		boolean isForUpdate = false;
		if (sql.toLowerCase().endsWith(" FOR UPDATE")) {
			sql = sql.substring(0, sql.length() - 11);
			isForUpdate = true;
		}

		StringBuffer pagingSelect = new StringBuffer(sql.length() + 100);

		pagingSelect.append("SELECT * FROM ( SELECT ROW_.*, ROWNUM ROWNUM_ FROM ( ");

		pagingSelect.append(sql);


        pagingSelect.append(" ) ROW_  WHERE ROWNUM <= "+(offset + limit)+" ) WHERE ROWNUM_ > " + offset);

		if (isForUpdate) {
			pagingSelect.append(" FOR UPDATE");
		}

		return pagingSelect.toString();
	}

    @Override
    public String addSortString(String sql, List<Sort> sortList) {
        return SortHelper.addSortString(sql, sortList);
    }

}