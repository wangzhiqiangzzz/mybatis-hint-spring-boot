package com.github.hint.enums;

/**
 * @EnumName MysqlEnum
 * @Description
 * @Author wzq
 * @Date 2025/5/19 14:44
 * @Version 1.0
 */
public enum MysqlEnum {

    TO_MASTER("/*FORCE_MASTER*/", "强制走主库"),
    TO_SLAVE("/*FORCE_SLAVE*/", "强制走从库");
    private final String hint;
    private final String desc;

    MysqlEnum(String hint, String desc) {
        this.hint = hint;
        this.desc = desc;
    }

    public String getHint() {
        return hint;
    }

    public String getDesc() {
        return desc;
    }
}
