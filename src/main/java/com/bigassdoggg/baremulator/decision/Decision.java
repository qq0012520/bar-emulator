package com.bigassdoggg.baremulator.decision;

import com.bigassdoggg.baremulator.Bar;
import com.bigassdoggg.baremulator.Constants;

/**
 * 决策基类
 * <strong>每个决策都是人的主观决策，
 * 但这些主观决策却都依赖历史到场人数的数据</strong>
 */
public abstract class Decision implements Comparable{

    //决策所依赖的酒吧
    protected final Bar bar;

    //决策优先级
    private int priority;

    public Decision(Bar bar,Integer priority) {
        this.bar = bar;
        this.priority = priority;
    }

    public void increasePriority(){
        priority++;
    }

    public void decreasePriority(){
        priority--;
    }

    public int getPriority() {
        return priority;
    }

    /**
     * 传入一个数，判断该数是否未超过阈值
     * @return true 未超过阈值；false 超过阈值
     */
    public boolean isNotOverThreshold(int num){
        return num < Constants.COMFORT_THRESHOLD;
    }

    /**
     * 根据历史到场人数做出决策
     * 如果预测将去酒吧的人数超过阈值，则不去酒吧，否正就去酒吧
     * @return true 代表决定去酒吧；false 代表不去酒吧
     */
    public abstract boolean make();

    @Override
    public int compareTo(Object o) {
        if(o == null)
            return 1;
        Decision decision = (Decision) o;
        return this.priority > decision.priority ? -1 : 1;
    }

    @Override
    public String toString() {
        return "Decision priority: " + priority;
    }
}
