package com.bigassdoggg.baremulator.decision.impl;

import com.bigassdoggg.baremulator.Bar;
import com.bigassdoggg.baremulator.decision.Decision;

/**
 * 根据上一周的数据，如果上一周人数大于阈值则去酒吧
 * 如果上一周小于阈值，则不去酒吧（逆向思维）
 */
public class InverseLastWeekDecision extends Decision {

    public InverseLastWeekDecision(Bar bar, Integer priority) {
        super(bar, priority);
    }

    @Override
    public boolean make() {
        int lastNum = bar.getPresenceList().get(bar.getPresenceListSize() - 1);
        return !isNotOverThreshold(lastNum);
    }
}
