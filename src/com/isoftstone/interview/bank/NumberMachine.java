package com.isoftstone.interview.bank;

/**
 * Function: 号码机器
 * User: huoyaning
 * Date: 2016/3/23
 * Time: 16:25
 */
public class NumberMachine {

    private NumberManager commonManager = new NumberManager();
    private NumberManager expressManager = new NumberManager();
    private NumberManager vipManager = new NumberManager();

    public NumberManager getCommonManager() {
        return commonManager;
    }

    public NumberManager getExpressManager() {
        return expressManager;
    }

    public NumberManager getVipManager() {
        return vipManager;
    }

    private NumberMachine() {}

    public static NumberMachine getInstance() {
        return instance;
    }

    private static NumberMachine instance = new NumberMachine();

}
