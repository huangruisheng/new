package com.trusthiker.dto.user;

/**
 * Created by rui on 16/10/22.
 */
public enum CityStatus {

    ENABLE(1), DISABLE(0);

    private int value;

    CityStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
