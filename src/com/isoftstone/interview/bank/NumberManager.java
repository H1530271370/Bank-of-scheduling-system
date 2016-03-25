package com.isoftstone.interview.bank;

import java.util.ArrayList;
import java.util.List;

/**
 * Function: 号码管理器
 * User: huoyaning
 * Date: 2016/3/23
 * Time: 16:05
 */
public class NumberManager {

    private int lastNumber = 1;
    private List<Integer> queueNumber = new ArrayList<Integer>();

    public synchronized Integer generateNewManager() {
        queueNumber.add(lastNumber);
        return lastNumber++;
    }

    public synchronized Integer fetchServiceNumber() {
        Integer number = null;
        if (queueNumber.size() > 0) {
            number = queueNumber.remove(0);
        }
        return number;
    }



}
