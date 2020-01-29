package com.bigassdoggg.baremulator.decision.impl;

import com.bigassdoggg.baremulator.Bar;
import com.bigassdoggg.baremulator.decision.Decision;

/**
 * 与上周到场人数以50为中心构成镜像
 * 算法：100 - 上周到场人数 = 镜像人数
 */
public class MirrorDecision extends Decision {

    public MirrorDecision(Bar bar, Integer priority) {
        super(bar, priority);
    }

    @Override
    public boolean make() {
        int num = this.bar.getPresenceList().get(this.bar.getPresenceListSize() - 1);
        return isNotOverThreshold(100 - num);
    }
}
