/**
 * @FileName:
 * @Date:2020/6/5 10:40
 * @Description:
 */
package com.javasm.demo.service;

import org.apache.solr.common.SolrDocumentList;

public interface SolrService {
    public void addSolr(String name,Integer price);
    public SolrDocumentList querySolr(String str);
}
