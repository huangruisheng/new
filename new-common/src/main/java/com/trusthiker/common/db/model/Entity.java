package com.trusthiker.common.db.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Example:
 *
 * @author com.trusthiker.common
 * @ Data
 * @ Table(name = "T_BAS_USER")
 * public class User extends Entity {
 * @ Id
 * private String id;
 * @ OrderColumn
 * private String name;
 * @ OrderColumn(name = "DESC")
 * private String userCode; // default column name : USER_CODE
 * @ Column(name = "PASS")
 * private String password;
 * <p/>
 * private String status;
 * @ Column(name = "S_COLUMN") // default column name : SOME_COLUMN
 * private String getSomeColumn() {
 * return null;
 * }
 * @ Transient
 * private String getSomeNoneColumn() {
 * return null;
 * }
 * <p/>
 * }
 */
@Data
public abstract class Entity implements Serializable {

    private static final long serialVersionUID = 4212679023438415647L;

    private Integer id;

    private String operator;

    private Date createDt;

    private Date updateDt;


}