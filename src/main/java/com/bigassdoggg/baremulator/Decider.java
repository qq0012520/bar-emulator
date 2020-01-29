package com.bigassdoggg.baremulator;

import com.bigassdoggg.baremulator.decision.Decision;

import java.util.*;

/**
 * 决策者
 * 决策者会包含一系列(一个或多个)带有优先级的策略集合
 */
public class Decider {
    private List<Decision> decisionList;

    private Decision current;

    private boolean currentResult;

    public Decider(List<Decision> decisions){
        this();
        this.decisionList.addAll(decisions);
    }

    public Decider() {
        decisionList = new LinkedList<>();
    }

    public void addDecision(Decision decision){
        decisionList.add(decision);
    }

    public void addDecisions(Decision... decisions){
        this.decisionList.addAll(Arrays.asList(decisions));
    }

    /**
     * 决定去不去酒吧
     * @return true 去酒吧；false 不去酒吧
     */
    public boolean makeDecision(){
        Collections.sort(decisionList);
        Decision efficient = decisionList.get(0);
        current = efficient;
        //去酒吧查看人数后，更新队列优先级
        boolean result = efficient.make();
        currentResult = result;
        return result;
    }

    /**
     * 收到反馈
     * @param actualNum 真实的到场人数
     */
    public void feedback(int actualNum){
        if(currentResult){
            //如果之前决定去并且实际到场人数大于阈值，当前策略降级
            if(actualNum > Constants.COMFORT_THRESHOLD){
                current.decreasePriority();
            }else{ //如果之前决定去并且实际到场人数不大于阈值，当前策略升级
                current.increasePriority();
            }
        }else {
            //如果之前决定不去并且实际到场人数大于阈值，当前策略升级
            if(actualNum > Constants.COMFORT_THRESHOLD){
                current.increasePriority();
            }else{ //如果之前决定不去并且实际到场人数不大于阈值，当前策略降级
                current.decreasePriority();
            }
        }
    }

    public void printDecisionQueue(){
        Collections.sort(decisionList);
        int len = decisionList.size();
        for(int i = 0 ;i < len;i++){
            System.out.println(decisionList.get(0));
        }
    }

}
