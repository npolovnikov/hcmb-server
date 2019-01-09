package com.pologames.hcmb.server.pojo;

import java.util.Random;

/**
 * Created by npolovnikov on 28.11.17.
 */
public enum PositionEnum {
    G, D, L, R, C;

    public static PositionEnum random() {
        return values()[new Random().nextInt(values().length - 1)];
    }
    public boolean isAttack(){
        return this == C || this == R || this == L;
    }
}
