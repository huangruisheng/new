package com.trusthiker.core.user.model;

import com.trusthiker.common.db.model.Entity;
import com.trusthiker.dto.user.CityStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Table;

/**
 * Created by rui on 16/10/22.
 */
@Data
@NoArgsConstructor
@Table(name = "t_core_city")
@EqualsAndHashCode(callSuper = false)
public class City extends Entity {

    private Integer code;

    private String name;

    private String pinyin;

    private CityStatus status;
}
