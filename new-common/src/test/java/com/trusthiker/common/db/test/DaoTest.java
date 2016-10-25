package com.trusthiker.common.db.test;

import com.trusthiker.common.db.bas.model.EventProcess;
import com.trusthiker.common.db.bas.dao.EventProcessDAO;
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
                "   ID                   VARCHAR2(50)         not null,\n" +
                "   EVENT_TYPE_ID        VARCHAR2(50),\n" +
                "   PROCESS_SEQ          NUMERIC(2),\n" +
                "   PROCESS_TYPE         VARCHAR2(50),\n" +
                "   CREATE_USER_CODE     VARCHAR2(50),\n" +
                "   CREATE_TIME          TIMESTAMP,\n" +
                "   MODIFY_USER_CODE     VARCHAR2(50),\n" +
                "   MODIFY_TIME          TIMESTAMP,\n" +
                "   STEP_INTERVAL        NUMERIC(8,2),\n" +
                "   STATUS               VARCHAR2(50),\n" +
                "   constraint PK_EVE_EVENT_PROCESS_ID primary key (ID)\n" +
                ");");
        EventProcess eventProcess = new EventProcess();
        eventProcess.setId("test");
        eventProcess.setProcessType("test");
        eventProcessDAO.insert(eventProcess);
        eventProcess.setId("test1");
        eventProcess.setProcessType("test");
        eventProcessDAO.insert(eventProcess);
    }

    @Test
    public void testGetAll() {
        eventProcessDAO.getAll();
    }

    @Test
    public void testGet() {
        EventProcess params = new EventProcess();
        params.setProcessType("test");
        params.setProcessSeq(111);
        //logger.info(eventProcessDAO.get(params, null, 0, 1).toString());
        List<Sort> sortList = new ArrayList<Sort>();
        sortList.add(new Sort("id"));
        sortList.add(new Sort("processSeq"));
        logger.info(eventProcessDAO.get(params, sortList, 0, 2).toString());
        sortList.remove(0);
        sortList.add(new Sort("id", Sort.Direction.DESC));
        logger.info(eventProcessDAO.get(params, sortList, 0, 2).toString());
    }


    public static void main(String[] args) {
        Integer i = new Integer(1);
        Integer j = 1;
        if(i==j){
            System.out.println("============");
        }else {
            System.out.println("11111111111");
        }

    }



}
