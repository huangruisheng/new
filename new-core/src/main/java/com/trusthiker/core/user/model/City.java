package com.trusthiker.core.user.model;

import com.trusthiker.common.db.model.Entity;
import com.trusthiker.dto.user.CityStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by rui on 16/10/22.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class City extends Entity {

    private Integer code;

    private String name;

    private String pinyin;

    private CityStatus status;
}
