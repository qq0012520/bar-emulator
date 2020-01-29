package com.bigassdoggg.baremulator.web;

import com.bigassdoggg.baremulator.Ecosystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private Ecosystem ecosystem;

    @GetMapping("/")
    String root(ModelMap model){
        return "redirect:/index";
    }

    @GetMapping("/index")
    String index(ModelMap model){
        List<Integer> datas = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            int num = ecosystem.round();
            datas.add(num);
        }
        model.put("datas",datas);
        return "index";
    }
}
