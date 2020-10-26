package com.cx.blog.enums;

/**
 * 〈内容类型枚举〉
 *
 * @author chenxin
 * @date 2020/10/26
 */
public enum ContentTypeEnum {

    SYS(1, "本系统"), ARTICLE(2, "文章");

    private int value;

    private String desc;

    ContentTypeEnum(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public static ContentTypeEnum parse(int value) {
        for (ContentTypeEnum type : ContentTypeEnum.values()) {
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
