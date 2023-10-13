package com.back.back.model;

public enum FlagEnum {
    Visa((short) 1),
    MasterCard((short) 2),
    AmericanExpress((short) 3),
    ELO((short) 4);

    private final short value;

    FlagEnum(short value){
        this.value = value;
    }

    public short getValue(){
        return value;
    }
}
