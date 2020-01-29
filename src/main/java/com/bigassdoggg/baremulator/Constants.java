package com.bigassdoggg.baremulator;

/**
 * 一些常量
 */
public class Constants {
    /**
     * 总的参与预测的人数
     */
    public static final int NUMBER_OF_PEOPLE = 100;

    /**
     * 酒吧舒适的阈值，如果酒吧人数超过该阈值，那么就会不舒服
     */
    public static final int COMFORT_THRESHOLD = 60;

    /**
     * 过去21周以来的到场人数序列
     * 每个数字代表某周的星期4的到场人数
     */
    public static final Integer[] SEQUENCE_OF_PAST_PRESENCE =
        new Integer[]{
                45,52,50,50,40,67,70
                ,45,87,55,68,95,30,10
                ,70,55,10,44,60,90,30
        };
}
