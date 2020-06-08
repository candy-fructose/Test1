/**
 * @FileName:
 * @Date:2020/6/5 10:38
 * @Description:
 */
package com.javasm.demo.controller;

import com.javasm.demo.entity.ResultMap;
import com.javasm.demo.service.SolrService;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/solr")
public class SolrController {

    @Resource
    private SolrService solrService;


    /*对象：gid，name，price
    * */
    @GetMapping("/add/{name}/{price}")
    public ResultMap<Object> addSolr(@PathVariable("name")String name, @PathVariable("price")Integer price){
        // TODO: 2020/6/5  数据校验
        solrService.addSolr(name,price);
        return ResultMap.successWithoutData();
    }

    @RequestMapping("/query/{condition}")
    // TODO: 2020/6/5 数据校验 
    public SolrDocumentList querySolr(@PathVariable("condition")String condition){
        return solrService.querySolr(condition);
    }
}
