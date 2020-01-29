package com.bigassdoggg.baremulator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 艾尔法努酒吧
 * 该酒吧每周4晚上会举办活动，他会记录活动当晚的到场人数
 */
public class Bar {
    private List<Integer> presenceList;

    public List<Integer> getPresenceList(){
        return Collections.unmodifiableList(presenceList);
    }

    public int getPresenceListSize(){
        return presenceList.size();
    }

    public void addPresence(Integer presenceNum){
        presenceList.add(presenceNum);
    }

    public Bar(){
        presenceList = new ArrayList<>();
        presenceList.addAll(Arrays.asList(Constants.SEQUENCE_OF_PAST_PRESENCE));
    }

    @Override
    public String toString() {
        return "AL Bar presence record size: " + presenceList.size();
    }
}
