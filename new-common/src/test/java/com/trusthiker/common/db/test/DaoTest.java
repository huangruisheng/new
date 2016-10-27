package com.trusthiker.common.db.test;

import com.trusthiker.common.db.bas.dao.EventProcessDAO;
import com.trusthiker.common.db.bas.model.EventProcess;
import com.trusthiker.common.db.dao.complexQuery.Sort;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.datasource.DataSourceUtils;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author com.zdmoney.zdqd
 */
public class DaoTest extends BaseTest {

    @Resource
    private EventProcessDAO eventProcessDAO;
    @Resource
    private DataSource dataSource;

    @Before
    public void setUp() throws SQLException {
        Connection conn = DataSourceUtils.getConnection(dataSource);
        Statement statement = conn.createStatement();
        statement.execute("DROP TABLE T_EVE_EVENT_PROCESS IF EXISTS;");
        statement.execute("create table T_EVE_EVENT_PROCESS \n" +
                "(\n" +
                "   ID                   INT(10)   AUTO_INCREMENT    not null,\n" +
                "   CREATE_DT          TIMESTAMP,\n" +
                "   UPDATE_DT          TIMESTAMP,\n" +
                "   OPERATOR          VARCHAR(50)\n" +
                ");");
        EventProcess eventProcess = new EventProcess();
        eventProcess.setCreateDt(new Date());
        eventProcessDAO.insert(eventProcess);
        eventProcess.setCreateDt(new Date());
        eventProcess.setUpdateDt(new Date());
        eventProcessDAO.insert(eventProcess);
    }

    @Test
    public void testGetAll() {
        eventProcessDAO.getAll();
    }

    @Test
    public void testGet() {
        EventProcess params = new EventProcess();
        List<Sort> sortList = new ArrayList<Sort>();
        sortList.add(new Sort("id"));
        sortList.add(new Sort("processSeq"));
        logger.info(eventProcessDAO.get(params, sortList, 0, 2).toString());
        sortList.remove(0);
        sortList.add(new Sort("id", Sort.Direction.DESC));
        logger.info(eventProcessDAO.get(params, sortList, 0, 2).toString());
    }




}
