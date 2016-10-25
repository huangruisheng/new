package com.trusthiker.dto.user;

/**
 * Created by rui on 16/10/22.
 */
public enum CityStatus {

    ON(1), OFF(0);

    private int value;

    CityStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
