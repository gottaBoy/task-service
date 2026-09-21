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

@CodeList(id="ad8c27775804c415d6a30a5bccb8c5f5", name="\u641c\u7d22\u5c5e\u6027\u6570\u636e\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="TEXT", text="Text", realtext="Text"), @CodeItem(value="INTEGER", text="Integer", realtext="Integer"), @CodeItem(value="LONG", text="Long", realtext="Long"), @CodeItem(value="DATE", text="Date", realtext="Date"), @CodeItem(value="FLOAT", text="Float", realtext="Float"), @CodeItem(value="DOUBLE", text="Double", realtext="Double"), @CodeItem(value="BOOLEAN", text="Boolean", realtext="Boolean"), @CodeItem(value="OBJECT", text="Object", realtext="Object"), @CodeItem(value="AUTO", text="Auto", realtext="Auto", userdata="\u81ea\u52a8\u5224\u65ad"), @CodeItem(value="NESTED", text="Nested", realtext="Nested"), @CodeItem(value="IP", text="Ip", realtext="Ip"), @CodeItem(value="ATTACHMENT", text="Attachment", realtext="Attachment"), @CodeItem(value="KEYWORD", text="Keyword", realtext="Keyword"), @CodeItem(value="DENSE_VECTOR", text="DenseVector", realtext="DenseVector"), @CodeItem(value="GEO_POINT", text="GeoPoint", realtext="GeoPoint")})
public class SearchFieldDataTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String TEXT = "TEXT";
    public static final String INTEGER = "INTEGER";
    public static final String LONG = "LONG";
    public static final String DATE = "DATE";
    public static final String FLOAT = "FLOAT";
    public static final String DOUBLE = "DOUBLE";
    public static final String BOOLEAN = "BOOLEAN";
    public static final String OBJECT = "OBJECT";
    public static final String AUTO = "AUTO";
    public static final String NESTED = "NESTED";
    public static final String IP = "IP";
    public static final String ATTACHMENT = "ATTACHMENT";
    public static final String KEYWORD = "KEYWORD";
    public static final String DENSE_VECTOR = "DENSE_VECTOR";
    public static final String GEO_POINT = "GEO_POINT";

    public SearchFieldDataTypeCodeListModel() {
        this.initAnnotation(SearchFieldDataTypeCodeListModel.class);
        this.setUserData2("SearchFieldDataType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.SearchFieldDataTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.SearchFieldDataTypeCodeListModel");
    }
}

