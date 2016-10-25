package com.trusthiker.common.db.dao.complexQuery;

import lombok.Getter;

/**
 * @author com.trusthiker.common
 */
public class NoValueQueryParam extends CustomQueryParam {

    @Getter
    private String condition;

    public NoValueQueryParam(String property, String condition) {
        super.property = property;
        this.condition = condition;
    }
}
