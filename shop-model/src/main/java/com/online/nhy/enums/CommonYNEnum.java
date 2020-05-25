package com.online.nhy.enums;

public enum CommonYNEnum implements IEnum<CommonYNEnum> {
    YES("1","是"),
    NO("2","否");

    
    private String value;
    private String name;
    
    /**
     * @param value
     * @param name
     */
    private CommonYNEnum(String value, String name) {
        this.value = value;
        this.name = name;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public String getName() {
        return name;
    }

    /*
     * 判断传入的枚举值(value)与当前的枚举值是否相等
     * @see org.ebiz.cxj.common.codemapping.ICxjEnum#equals(java.lang.String)
     */
    @Override
    public final boolean equals(String value) {
        return this.getValue().equals(value);
    }

}

