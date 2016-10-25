package com.trusthiker.common.db.dao.complexQuery;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by com.trusthiker.common on 2014/12/19.
 */
public class QueryParamBuilder {

    private List<CustomQueryParam> queryParams;

    public QueryParamBuilder() {
        queryParams = new ArrayList<CustomQueryParam>();
    }

    public static QueryParamBuilder newBuilder() {
        return new QueryParamBuilder();
    }

    public QueryParamBuilder addWithValueQueryParam(String property, String operator, Object value) {
        if (StringUtils.isBlank(property) || StringUtils.isBlank(operator) || value == null || StringUtils.isBlank("" + value)) {
            return this;
        }
        queryParams.add(new WithValueQueryParam(property, operator, value));
        return this;
    }

    public QueryParamBuilder addNoValueQueryParam(String property, String condition) {
        if (StringUtils.isBlank(property) || StringUtils.isBlank(condition)) {
            return this;
        }
        queryParams.add(new NoValueQueryParam(property, condition));
        return this;
    }

    public List<CustomQueryParam> build() {
        return queryParams;
    }

}
