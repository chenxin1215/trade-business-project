package com.cx.blog.enums;

/**
 * 〈通用状态枚举〉
 *
 * @author chenxin
 * @date 2020/6/14
 */
public enum BaseStateEnum {

    ENABLE(1, "启用"), DISABLE(2, "禁用");

    private int value;

    private String desc;

    BaseStateEnum(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public static BaseStateEnum parse(int value) {
        for (BaseStateEnum type : BaseStateEnum.values()) {
            if (value == type.value) {
                return type;
            }
        }
        return null;
    }

    public int value() {
        return value;
    }

    public String toString() {
        return this.desc;
    }

}
