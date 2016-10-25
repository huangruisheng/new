package com.trusthiker.common.db.dao.impl.mybatis.typeHandler;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by com.trusthiker.common on 2015/1/5.
 */
public class JSONObjectTypeHandler extends JSONTypeHandler<JSONObject> {

    public JSONObjectTypeHandler(Class<JSONObject> type) {
        super(type);
    }

    @Override
    protected JSONObject parseJSONString(String jsonString) {
        return JSONObject.parseObject(jsonString);
    }

}
