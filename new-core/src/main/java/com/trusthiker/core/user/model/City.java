package com.trusthiker.core.user.model;

import com.trusthiker.dto.user.CityStatus;
import lombok.Data;

/**
 * Created by rui on 16/10/22.
 */
@Data
public class City {

    private Long id;

    private Integer code;

    private String name;

    private String pinyin;

    private CityStatus status;
}
