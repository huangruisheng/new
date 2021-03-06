package com.trusthiker.common.db.dao.impl.mybatis;

import com.trusthiker.common.db.dao.dialect.Dialect;
import com.trusthiker.common.db.dao.dialect.H2Dialect;
import com.trusthiker.common.db.dao.dialect.MySql5Dialect;
import com.trusthiker.common.db.dao.dialect.OracleDialect;
import com.trusthiker.common.db.enums.DBDialectType;
import org.apache.ibatis.session.Configuration;

public class DialectParser {

    public static Dialect parse(Configuration configuration) {
        DBDialectType databaseType = null;
        try {
            databaseType = DBDialectType.valueOf(configuration.getVariables().getProperty("dialect").toUpperCase());
        } catch (Exception e) {
            // ignore
        }
        if (databaseType == null) {
            throw new RuntimeException("the value of the dialect property in configuration.xml is not defined : " + configuration.getVariables().getProperty("dialect"));
        }
        Dialect dialect = null;
        switch (databaseType) {
            case MYSQL:
                dialect = new MySql5Dialect();
                break;
            case ORACLE:
                dialect = new OracleDialect();
                break;
            case H2:
                dialect = new H2Dialect();
                break;
        }
        return dialect;
    }

}
