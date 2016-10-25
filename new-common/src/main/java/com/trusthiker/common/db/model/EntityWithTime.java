package com.trusthiker.common.db.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * Created by com.trusthiker.common on 2014/12/26.
 */
@Data
@EqualsAndHashCode(callSuper=false)
public abstract class EntityWithTime extends Entity {

    private Date createTime;

    private Date modifyTime;

}
