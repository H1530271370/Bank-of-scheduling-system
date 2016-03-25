package com.scheduling.bank;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Function: 主函数
 * User: huoyaning
 * Date: 2016/3/24
 * Time: 14:53
 */
public class MainClass {

    public static void main(String[] args) {
        //创建4个普通窗口
        for (int i = 1; i < 5; i++) {
            ServiceWindow commonWindow = new ServiceWindow();
            commonWindow.setType(CustomerType.COMMON);
            commonWindow.setWindowId(i);
            commonWindow.start();
        }

        //创建一个快速窗口
        ServiceWindow expressWindow = new ServiceWindow();
        expressWindow.setType(CustomerType.EXPRESS);
        expressWindow.setWindowId(5);
        expressWindow.start();

        //创建一个VIP窗口
        ServiceWindow vipWindow = new ServiceWindow();
        vipWindow.setType(CustomerType.VIP);
        vipWindow.setWindowId(6);
        vipWindow.start();

        /**
         * 普通客户取号
         */
        Executors.newScheduledThreadPool(1).scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                Integer number = NumberMachine.getInstance().getCommonManager().generateNewManager();
                System.out.println(number + "号普通客户正在等待服务");
            }
        }, 0, Constants.COMMON_CUSTOMER_INTERVAL_TIME, TimeUnit.SECONDS);

        /**
         * 快速客户取号
         */
        Executors.newScheduledThreadPool(1).scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                Integer number = NumberMachine.getInstance().getExpressManager().generateNewManager();
                System.out.println(number + "号快速客户正在等待服务");
            }
        }, 0, Constants.COMMON_CUSTOMER_INTERVAL_TIME * 2, TimeUnit.SECONDS);

        /**
         * VIP客户取号
         */
        Executors.newScheduledThreadPool(1).scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                Integer number = NumberMachine.getInstance().getVipManager().generateNewManager();
                System.out.println(number + "号VIP客户正在等待服务");
            }
        }, 0, Constants.COMMON_CUSTOMER_INTERVAL_TIME * 6, TimeUnit.SECONDS);

    }

}
