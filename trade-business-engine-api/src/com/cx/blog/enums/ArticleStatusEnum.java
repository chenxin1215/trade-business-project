package com.cx.blog.enums;

/**
 * 〈用户状态〉
 *
 * @author chenxin
 * @date 2020/6/14
 */
public enum ArticleStatusEnum {

    ENABLE(0, "禁用"), DISABLE(1, "启用");

    private int value;

    private String desc;

    ArticleStatusEnum(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public static ArticleStatusEnum parse(int value) {
        for (ArticleStatusEnum type : ArticleStatusEnum.values()) {
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
