/**
 * @FileName:
 * @Date:2020/6/5 10:42
 * @Description:
 */
package com.javasm.demo.service.impl;

import com.javasm.demo.service.SolrService;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.apache.solr.common.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;

@Service
public class SolrServiceImpl implements SolrService {

    @Resource
    private SolrClient sc;

    @Override
    public void addSolr(String name, Integer price) {
        if (!StringUtils.isEmpty(name)) {
            SolrInputDocument entries = new SolrInputDocument();
            entries.addField("game_id", 1000);
            entries.addField("game_name", name);
            entries.addField("game_price", price);
            try {
                sc.add("javasm", entries);
                sc.commit("javasm");
            } catch (SolrServerException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public SolrDocumentList querySolr(String condition) {
        SolrQuery params = new SolrQuery();

        //查询条件, 这里的 q 对应 下面图片标红的地方
        params.set("q", "*" + condition + "*");

        //过滤条件
//        params.set("fq", "game_price:[100 TO 100000]");

        //排序
//        params.addSort("game_name", SolrQuery.ORDER.asc);

        //分页
//        params.setStart(0);
//        params.setRows(20);

        //默认域，查询条件的key
        params.set("df", "game_name");

        //只查询指定域，返回查询结果的键值对
//        params.set("fl", "id,product_title,product_price");

       /* //高亮，
        //打开开关
        params.setHighlight(true);
        //指定高亮域
        params.addHighlightField("game_name");
        //设置前缀
        params.setHighlightSimplePre("<span style='color:red'>");
        //设置后缀
        params.setHighlightSimplePost("</span>");*/

        QueryResponse queryResponse = null;
        try {
            queryResponse = sc.query("javasm",params);
            SolrDocumentList results = queryResponse.getResults();
//查询结果条数
            long numFound = results.getNumFound();

            System.out.println(numFound);
            return results;
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}