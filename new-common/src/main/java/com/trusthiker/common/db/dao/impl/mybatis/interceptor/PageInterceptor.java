package com.trusthiker.common.db.dao.impl.mybatis.interceptor;

import com.trusthiker.common.db.dao.dialect.Dialect;
import com.trusthiker.common.db.dao.impl.mybatis.DialectParser;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.ibatis.reflection.wrapper.DefaultObjectWrapperFactory;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.RowBounds;

import java.sql.Connection;
import java.util.Properties;

/**
 * 支持物理分页。
 * Created by unknown
 * Modify by com.trusthiker.common
 */
@Intercepts({@Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class})})
public class PageInterceptor implements Interceptor {

    protected final Log logger = LogFactory.getLog(getClass());

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
        BoundSql boundSql = statementHandler.getBoundSql();
        MetaObject metaStatementHandler = MetaObject.forObject(statementHandler, new DefaultObjectFactory(), new DefaultObjectWrapperFactory());
        RowBounds rowBounds = (RowBounds) metaStatementHandler.getValue("delegate.rowBounds");
        if ((rowBounds != null) && (rowBounds != RowBounds.DEFAULT)) {
            Configuration configuration = (Configuration) metaStatementHandler.getValue("delegate.configuration");
            Dialect dialect = DialectParser.parse(configuration);
            String sql = (String) metaStatementHandler.getValue("delegate.boundSql.sql");
            sql = dialect.addLimitString(sql, rowBounds.getOffset(), rowBounds.getLimit());

            metaStatementHandler.setValue("delegate.boundSql.sql", sql);
            metaStatementHandler.setValue("delegate.rowBounds.offset", RowBounds.NO_ROW_OFFSET);
            metaStatementHandler.setValue("delegate.rowBounds.limit", RowBounds.NO_ROW_LIMIT);
        }

        logger.debug("SQL : " + boundSql.getSql());
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
    }

}