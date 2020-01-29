package com.bigassdoggg.baremulator.decision.impl;

import com.bigassdoggg.baremulator.Bar;
import com.bigassdoggg.baremulator.Constants;
import com.bigassdoggg.baremulator.decision.Decision;
import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;

import java.math.BigDecimal;
import java.util.List;

/**
 * 过去四周到场人数的平均值(四舍五入)
 */
public class LastFourWeekAvgDecision extends Decision {

    public LastFourWeekAvgDecision(Bar bar, Integer priority) {
        super(bar, priority);
    }

    @Override
    public boolean make() {
        List<Integer> pList = bar.getPresenceList();
        int firstIndex = pList.size() - 1;

        int oneWeek = pList.get(firstIndex);
        int twoWeek = pList.get(firstIndex - 1);
        int threeWeek = pList.get(firstIndex - 2);
        int fourWeek = pList.get(firstIndex - 3);
        int avg = new BigDecimal(oneWeek + twoWeek + threeWeek + fourWeek)
                .divide(new BigDecimal(4),0,BigDecimal.ROUND_HALF_UP).intValue();
        return isNotOverThreshold(avg);
    }
}
