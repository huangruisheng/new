package com.trusthiker.common.db.dao.impl.mybatis.typeHandler;

import com.alibaba.fastjson.JSONArray;

/**
 * Created by com.trusthiker.common on 2015/1/5.
 */
public class JSONArrayTypeHandler extends JSONTypeHandler<JSONArray> {

    public JSONArrayTypeHandler(Class<JSONArray> type) {
        super(type);
    }

    @Override
    protected JSONArray parseJSONString(String jsonString) {
        return JSONArray.parseArray(jsonString);
    }

}
