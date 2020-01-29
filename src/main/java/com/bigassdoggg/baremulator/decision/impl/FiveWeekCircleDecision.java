package com.bigassdoggg.baremulator.decision.impl;

import com.bigassdoggg.baremulator.Bar;
import com.bigassdoggg.baremulator.decision.Decision;

/**
 * 与5周之前的到场人数相同
 */
public class FiveWeekCircleDecision extends Decision {


    public FiveWeekCircleDecision(Bar bar, Integer priority) {
        super(bar, priority);
    }

    @Override
    public boolean make() {
        int num = bar.getPresenceList().get(bar.getPresenceListSize() - 5);
        return isNotOverThreshold(num);
    }
}
