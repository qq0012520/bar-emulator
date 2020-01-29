package com.bigassdoggg.baremulator;

import com.bigassdoggg.baremulator.decision.Decision;
import com.bigassdoggg.baremulator.decision.impl.*;
import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class SimpleTest {

    @Test
    public void simpleTest(){
        Bar bar = new Bar();
        Decision one = new FiveWeekCircleDecision(bar,1);
        Decision two = new InverseLastWeekDecision(bar,12);
        Decision three = new InverseLastWeekDecision(bar,6);
        Decision five = new InverseLastWeekDecision(bar,-4);
        Decision four = new InverseLastWeekDecision(bar,47);
        Decider decider = new Decider();
        decider.addDecisions(one,two,three,four,five);
        decider.printDecisionQueue();
    }

    @Test
    public void someTest(){
        for (int i = 0; i < 50; i++) {
            System.out.println(new Random().nextInt(6));
        }
    }

    @Test
    public void testEcosystem(){
        Ecosystem ecosystem = new Ecosystem();
        ecosystem.init();
        for (int i = 0; i < 100; i++) {
            System.out.println("round : " + ecosystem.round());
        }
    }

    @Test
    public void testQueue(){
        Bar bar = new Bar();
        Decision one = new FiveWeekCircleDecision(bar,6);
        Decision two = new LastFourWeekAvgDecision(bar,5);
        Decision three = new LastWeekDecision(bar,1);
        Decision five = new InverseLastWeekDecision(bar,2);
        Decision four = new MirrorDecision(bar,3);
        Decision six = new TwoWeekCircleDecision(bar,4);
        Decider decider = new Decider();
        decider.addDecisions(one,two,three,four,five,six);
        decider.printDecisionQueue();
        one.decreasePriority();
        one.decreasePriority();

        decider.printDecisionQueue();
    }

}
