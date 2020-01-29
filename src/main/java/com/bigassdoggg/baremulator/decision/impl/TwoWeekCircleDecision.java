package com.bigassdoggg.baremulator.decision.impl;

import com.bigassdoggg.baremulator.Bar;
import com.bigassdoggg.baremulator.decision.Decision;

/**
 * 与两周之前的到场人数相同
 */
public class TwoWeekCircleDecision extends Decision {

    public TwoWeekCircleDecision(Bar bar, Integer priority) {
        super(bar, priority);
    }

    @Override
    public boolean make() {
        int num = bar.getPresenceList().get(bar.getPresenceListSize() - 2);
        return isNotOverThreshold(num);
    }
}
