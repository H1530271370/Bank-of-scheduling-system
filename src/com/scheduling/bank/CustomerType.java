package com.scheduling.bank;

/**
 * Function: 窗口类型
 * User: huoyaning
 * Date: 2016/3/23
 * Time: 19:20
 */
public enum CustomerType {

    COMMON,
    EXPRESS,
    VIP;

    @Override
    public String toString() {
        switch (this) {
            case COMMON:
                return "普通";
            case EXPRESS:
                return "快速";
            case VIP:
                return name();
        }
        return null;
    }
}
