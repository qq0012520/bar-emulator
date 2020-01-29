package com.bigassdoggg.baremulator.decision.impl;

import com.bigassdoggg.baremulator.Bar;
import com.bigassdoggg.baremulator.Constants;
import com.bigassdoggg.baremulator.decision.Decision;

import java.util.List;

/**
 * 预测与上周到场人数一样
 */
public class LastWeekDecision extends Decision {

    public LastWeekDecision(Bar bar, Integer priority) {
        super(bar, priority);
    }

    @Override
    public boolean make() {
        List<Integer> presenceList = this.bar.getPresenceList();
        //获取上周到场人数
        int lastNum = presenceList.get(presenceList.size() - 1);
        return lastNum < Constants.COMFORT_THRESHOLD;
    }

}
