/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.codelist.CodeItem
 *  net.ibizsys.paas.codelist.CodeItems
 *  net.ibizsys.paas.codelist.CodeList
 *  net.ibizsys.paas.codelist.ICodeList
 *  net.ibizsys.paas.sysmodel.CodeListGlobal
 *  net.ibizsys.paas.sysmodel.ICodeListModel
 *  net.ibizsys.paas.sysmodel.StaticCodeListModelBase
 */
package net.ibizsys.pscore.srv.codelist;

import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.ICodeListModel;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;

@CodeList(id="a60bc9440d28f1768a08c1c6baa6c1e0", name="\u4e91\u5e73\u53f0\u5927\u6570\u636e\u5e93\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09", ormode="STR", valueseparator=";", textseparator="\u3001")
@CodeItems(value={@CodeItem(value="MONGODB", text="MongoDB", realtext="MongoDB"), @CodeItem(value="SOLR", text="Solr", realtext="Solr"), @CodeItem(value="ES", text="ElasticSearch", realtext="ElasticSearch"), @CodeItem(value="HBASE", text="HBase", realtext="HBase"), @CodeItem(value="MILVUS", text="Milvus", realtext="Milvus"), @CodeItem(value="NEO4J", text="Neo4j", realtext="Neo4j"), @CodeItem(value="USER", text="\u7528\u6237\u81ea\u5b9a\u4e49", realtext="\u7528\u6237\u81ea\u5b9a\u4e49"), @CodeItem(value="USER2", text="\u7528\u6237\u81ea\u5b9a\u4e492", realtext="\u7528\u6237\u81ea\u5b9a\u4e492")})
public class BDTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String MONGODB = "MONGODB";
    public static final String SOLR = "SOLR";
    public static final String ES = "ES";
    public static final String HBASE = "HBASE";
    public static final String MILVUS = "MILVUS";
    public static final String NEO4J = "NEO4J";
    public static final String USER = "USER";
    public static final String USER2 = "USER2";

    public BDTypeCodeListModel() {
        this.initAnnotation(BDTypeCodeListModel.class);
        this.setUserData2("BDType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.BDTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.BDTypeCodeListModel");
    }
}

