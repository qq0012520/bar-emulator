package com.bigassdoggg.baremulator;

import com.bigassdoggg.baremulator.decision.Decision;
import com.bigassdoggg.baremulator.decision.impl.*;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * 决策生成器，随机生成1到多个决策
 */
public class DecisionGenerator {
    private List<Class> decisionClasses = new ArrayList<>(Arrays
            .asList(FiveWeekCircleDecision.class
                    , InverseLastWeekDecision.class
                    , LastFourWeekAvgDecision.class
                    , LastWeekDecision.class
                    , MirrorDecision.class
                    , TwoWeekCircleDecision.class));
    private Random random = new Random();

    /**
     * 生成1到多个策略集合
     */
    public List<Decision> generate(Bar bar){
        List<Decision> decisionList = new ArrayList<>();
        int amount = random.nextInt(7) + 1; //1-6
        for(int i = 0;i < amount;i++){
            Class decisionClass = decisionClasses.get(random.nextInt(6));
            try {
                Constructor con = decisionClass.getConstructor(
                        Bar.class,Integer.class);
                //优先级初始化为0-5
                Decision decision = (Decision) con.newInstance(bar,random.nextInt(6));
                decisionList.add(decision);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return decisionList;
    }
}
