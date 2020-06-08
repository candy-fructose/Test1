/**
 * @FileName:
 * @Date:2020/6/1 20:58
 * @Description:
 */
package com.javasm.demo.controller;

import com.javasm.demo.entity.Myuser;
import com.javasm.demo.entity.ResultMap;
import com.javasm.demo.service.MyuserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;

@Controller
public class TestControllor {
    @Resource
    private MyuserService msi;
    @RequestMapping("/date")
    @ResponseBody
    public String dateTest(@RequestParam(required = false) Date date){
        return "testOnly";
    }
    @RequestMapping("/user")
    public String dateTest(Myuser mu,Model model){
        if(mu.getId()!=null) {
            model.addAttribute("myuser", msi.selectByPrimaryKey(mu.getId()));
        }
        return "usertest";
    }
    @RequestMapping("/test")
    @ResponseBody
    public ResultMap<Object> test(Model model){
        return ResultMap.successWithoutData();
    }
    @RequestMapping("/test2")
    @ResponseBody
    public String test2(Model model){
        return "test";
    }

}
