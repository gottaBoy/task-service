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

@CodeList(id="8A53E160-C1A9-4D55-ABFD-0CD6630239CF", name="\u5b9e\u4f53\u805a\u5408\u6570\u636e\u5173\u7cfb\u5c5e\u6027\u6620\u5c04\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="SUM", text="\u5408\u8ba1", realtext="\u5408\u8ba1", userdata="\u5c06\u4ece\u5b9e\u4f53\u7684\u6307\u5b9a\u5c5e\u6027\u7684\u503c\u8fdb\u884c\u5408\u8ba1"), @CodeItem(value="AVG", text="\u5e73\u5747", realtext="\u5e73\u5747", userdata="\u5c06\u4ece\u5b9e\u4f53\u7684\u6307\u5b9a\u5c5e\u6027\u7684\u503c\u8fdb\u884c\u5e73\u5747"), @CodeItem(value="MAX", text="\u6700\u5927\u503c", realtext="\u6700\u5927\u503c", userdata="\u53d6\u4ece\u5b9e\u4f53\u7684\u6307\u5b9a\u5c5e\u6027\u7684\u6700\u5927\u503c"), @CodeItem(value="MIN", text="\u6700\u5c0f\u503c", realtext="\u6700\u5c0f\u503c", userdata="\u53d6\u4ece\u5b9e\u4f53\u7684\u6307\u5b9a\u5c5e\u6027\u7684\u6700\u5c0f\u503c"), @CodeItem(value="COUNT", text="\u8ba1\u6570", realtext="\u8ba1\u6570", userdata="\u4ece\u5b9e\u4f53\u8ba1\u6570"), @CodeItem(value="EXISTS", text="\u5b58\u5728", realtext="\u5b58\u5728", userdata="\u4ece\u5b9e\u4f53\u5b58\u5728\uff0c1\u8868\u793a\u5b58\u5728\uff0c0\u8868\u793a\u4e0d\u5b58\u5728"), @CodeItem(value="NOTEXISTS", text="\u4e0d\u5b58\u5728", realtext="\u4e0d\u5b58\u5728", userdata="\u4ece\u5b9e\u4f53\u4e0d\u5b58\u5728\uff0c1\u8868\u793a\u4e0d\u5b58\u5728\uff0c0\u8868\u793a\u5b58\u5728"), @CodeItem(value="GROUPBY", text="\u5206\u7ec4", realtext="\u5206\u7ec4"), @CodeItem(value="GROUPBY_DAYOFWEEK", text="\u6309\u5468\u5929\u5206\u7ec4", realtext="\u6309\u5468\u5929\u5206\u7ec4", userdata="\u5468\u7684\u7b2c\u51e0\u5929\uff0c\u4ece1\u5f00\u59cb"), @CodeItem(value="GROUPBY_DAYOFMONTH", text="\u6309\u6708\u5929\u5206\u7ec4", realtext="\u6309\u6708\u5929\u5206\u7ec4", userdata="\u6708\u7684\u7b2c\u51e0\u5929\uff0c\u4ece1\u5f00\u59cb"), @CodeItem(value="GROUPBY_DAYOFYEAR", text="\u6309\u5e74\u5929\u5206\u7ec4", realtext="\u6309\u5e74\u5929\u5206\u7ec4", userdata="\u5e74\u4e2d\u7b2c\u51e0\u5929\uff0c\u4ece1\u5f00\u59cb"), @CodeItem(value="GROUPBY_WEEK", text="\u6309\u5468\u5206\u7ec4", realtext="\u6309\u5468\u5206\u7ec4"), @CodeItem(value="GROUPBY_MONTH", text="\u6309\u6708\u4efd\u5206\u7ec4", realtext="\u6309\u6708\u4efd\u5206\u7ec4"), @CodeItem(value="GROUPBY_QUARTER", text="\u6309\u5b63\u5ea6\u5206\u7ec4", realtext="\u6309\u5b63\u5ea6\u5206\u7ec4"), @CodeItem(value="GROUPBY_YEAR", text="\u6309\u5e74\u4efd\u5206\u7ec4", realtext="\u6309\u5e74\u4efd\u5206\u7ec4"), @CodeItem(value="GROUPBY_HOUR", text="\u6309\u5c0f\u65f6\u5206\u7ec4", realtext="\u6309\u5c0f\u65f6\u5206\u7ec4"), @CodeItem(value="GROUPBY_MINUTE", text="\u6309\u5206\u949f\u5206\u7ec4", realtext="\u6309\u5206\u949f\u5206\u7ec4"), @CodeItem(value="USER", text="\u7528\u6237\u81ea\u5b9a\u4e49", realtext="\u7528\u6237\u81ea\u5b9a\u4e49"), @CodeItem(value="USER2", text="\u7528\u6237\u81ea\u5b9a\u4e492", realtext="\u7528\u6237\u81ea\u5b9a\u4e492"), @CodeItem(value="USER3", text="\u7528\u6237\u81ea\u5b9a\u4e493", realtext="\u7528\u6237\u81ea\u5b9a\u4e493"), @CodeItem(value="USER4", text="\u7528\u6237\u81ea\u5b9a\u4e494", realtext="\u7528\u6237\u81ea\u5b9a\u4e494")})
public class DERAggDataDEFMapTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String SUM = "SUM";
    public static final String AVG = "AVG";
    public static final String MAX = "MAX";
    public static final String MIN = "MIN";
    public static final String COUNT = "COUNT";
    public static final String EXISTS = "EXISTS";
    public static final String NOTEXISTS = "NOTEXISTS";
    public static final String GROUPBY = "GROUPBY";
    public static final String GROUPBY_DAYOFWEEK = "GROUPBY_DAYOFWEEK";
    public static final String GROUPBY_DAYOFMONTH = "GROUPBY_DAYOFMONTH";
    public static final String GROUPBY_DAYOFYEAR = "GROUPBY_DAYOFYEAR";
    public static final String GROUPBY_WEEK = "GROUPBY_WEEK";
    public static final String GROUPBY_MONTH = "GROUPBY_MONTH";
    public static final String GROUPBY_QUARTER = "GROUPBY_QUARTER";
    public static final String GROUPBY_YEAR = "GROUPBY_YEAR";
    public static final String GROUPBY_HOUR = "GROUPBY_HOUR";
    public static final String GROUPBY_MINUTE = "GROUPBY_MINUTE";
    public static final String USER = "USER";
    public static final String USER2 = "USER2";
    public static final String USER3 = "USER3";
    public static final String USER4 = "USER4";

    public DERAggDataDEFMapTypeCodeListModel() {
        this.initAnnotation(DERAggDataDEFMapTypeCodeListModel.class);
        this.setUserData2("DERAggDataDEFMapType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DERAggDataDEFMapTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DERAggDataDEFMapTypeCodeListModel");
    }
}

