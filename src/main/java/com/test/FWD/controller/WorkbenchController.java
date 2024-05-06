package com.test.FWD.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


//工作台
@RestController
@RequestMapping("/workbench")
public class WorkbenchController {


    //在工作台上回显模板记录的接口
    @PostMapping("/list")
    public void list(){

    }

    //点击编辑后根据id查询模板信息并且回显
    @PostMapping("/edit")
    public void editTemplate(){

    }

    //发布模板
    @PostMapping("/publish")
    public void publish(){

    }

}
