package com.bigassdoggg.baremulator;


import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 生态系统模型，整合了酒吧，人和人的主观决策
 */
@Component
public class Ecosystem {

    public Ecosystem() {
        init();
    }

    /**
     * 总的参与者人数集合
     */
    private List<Decider> participators = new ArrayList<>(Constants.NUMBER_OF_PEOPLE);

    /**
     * 策略生成器
     */
    private DecisionGenerator generator = new DecisionGenerator();

    private Bar bar = new Bar();

    public void init(){
        for (int i = 0; i < 100; i++) {
            //生成参与者
            Decider decider = new Decider(generator.generate(bar));
            participators.add(decider);
        }
    }

    /**
     * 执行一次演化
     */
    public int round(){
        int participateCount = 0;
        for (Decider decider : participators){
            if(decider.makeDecision())
                participateCount++;
        }
        //更新酒吧本轮人数
        bar.addPresence(participateCount);
        //向每个决策者反馈本轮总人数
        for (Decider decider : participators){
            decider.feedback(participateCount);
        }
        return participateCount;
    }
}
