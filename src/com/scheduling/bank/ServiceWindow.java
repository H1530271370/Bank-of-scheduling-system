package com.scheduling.bank;

import java.util.Random;
import java.util.concurrent.Executors;

/**
 * Function: 服务窗口
 * User: huoyaning
 * Date: 2016/3/23
 * Time: 19:17
 */
public class ServiceWindow {

    private CustomerType type = CustomerType.COMMON;
    private int windowId = 1;

    public void start() {
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    switch (type) {
                        case COMMON:
                            commonService();
                            break;
                        case EXPRESS:
                            expressService();
                            break;
                        case VIP:
                            vipService();
                            break;
                        default:
                            break;
                    }
                }
            }
        });
    }

    /**
     * 普通客户服务
     */
    private void commonService() {
        String windowName = windowId + "号" + type + "窗口";
        Integer number = NumberMachine.getInstance().getCommonManager().fetchServiceNumber();
        System.out.println(windowName + "正在获取任务");
        if (number != null) {
            System.out.println(windowName + "正在为" + number + "号" + "普通" + "客户提供服务");
            long serviceTime = new Random().nextInt(Constants.MAX_SERVICE_TIME - Constants.MIN_SERVICE_TIME) + 1
                    + Constants.MIN_SERVICE_TIME;
            try {
                Thread.sleep(serviceTime);
            } catch (Exception e) {

            }
            System.out.println(windowName + "为" + (number + 1) + "号" + type + "客户完成服务,耗时" + serviceTime / 1000 + "秒");
        } else {
            try {
                Thread.sleep(1000);
                System.out.println(windowName + "没有" + "普通" + "客户，休息1秒");
            } catch (Exception e) {

            }
        }
    }

    /**
     * 快速客户服务
     */
    private void expressService() {
        String windowName = windowId + "号" + type + "窗口";
        Integer number = NumberMachine.getInstance().getExpressManager().fetchServiceNumber();
        System.out.println(windowName + "正在获取任务");
        if (number != null) {
            System.out.println(windowName + "正在为" + number + "号" + type + "客户提供服务");
            try {
                Thread.sleep(1000);
            } catch (Exception e) {

            }
            System.out.println(windowName + "为" + (number + 1) + "号" + type + "客户完成服务,耗时" + 1 + "秒");
        } else {
            System.out.println(windowName + "没有取到任务");
            commonService();
        }
    }

    /**
     * VIP客户服务
     */
    private void vipService() {
        String windowName = windowId + "号" + type + "窗口";
        Integer number = NumberMachine.getInstance().getVipManager().fetchServiceNumber();
        System.out.println(windowName + "正在获取任务");
        if (number != null) {
            System.out.println(windowName + "正在为" + number + "号" + type + "客户提供服务");
            long serviceTime = new Random().nextInt(Constants.MAX_SERVICE_TIME - Constants.MIN_SERVICE_TIME) + 1 + Constants.MIN_SERVICE_TIME;
            try {
                Thread.sleep(serviceTime);
            } catch (Exception e) {

            }
            System.out.println(windowName + "为" + number + "号" + type + "客户完成服务,耗时" + serviceTime / 1000 + "秒");
        } else {
            System.out.println(windowName + "没有取到任务");
            commonService();
        }
    }

    public void setType(CustomerType type) {
        this.type = type;
    }

    public void setWindowId(int windowId) {
        this.windowId = windowId;
    }

}
