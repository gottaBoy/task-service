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

@CodeList(id="9A2D8E5A-FC93-4886-A755-E6209FD1CA12", name="\u6570\u636e\u805a\u5408\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="SUM", text="\u5408\u8ba1", realtext="\u5408\u8ba1"), @CodeItem(value="AVG", text="\u5e73\u5747", realtext="\u5e73\u5747"), @CodeItem(value="MAX", text="\u6700\u5927\u503c", realtext="\u6700\u5927\u503c"), @CodeItem(value="MIN", text="\u6700\u5c0f\u503c", realtext="\u6700\u5c0f\u503c"), @CodeItem(value="COUNT", text="\u8ba1\u6570", realtext="\u8ba1\u6570"), @CodeItem(value="EXISTS", text="\u5b58\u5728", realtext="\u5b58\u5728", userdata="\u4ece\u5b9e\u4f53\u5b58\u5728\uff0c1\u8868\u793a\u5b58\u5728\uff0c0\u8868\u793a\u4e0d\u5b58\u5728"), @CodeItem(value="NOTEXISTS", text="\u4e0d\u5b58\u5728", realtext="\u4e0d\u5b58\u5728", userdata="\u4ece\u5b9e\u4f53\u4e0d\u5b58\u5728\uff0c1\u8868\u793a\u4e0d\u5b58\u5728\uff0c0\u8868\u793a\u5b58\u5728"), @CodeItem(value="GROUP", text="\u5206\u7ec4\u9879", realtext="\u5206\u7ec4\u9879"), @CodeItem(value="USER", text="\u7528\u6237\u81ea\u5b9a\u4e49", realtext="\u7528\u6237\u81ea\u5b9a\u4e49"), @CodeItem(value="USER2", text="\u7528\u6237\u81ea\u5b9a\u4e492", realtext="\u7528\u6237\u81ea\u5b9a\u4e492"), @CodeItem(value="USER3", text="\u7528\u6237\u81ea\u5b9a\u4e493", realtext="\u7528\u6237\u81ea\u5b9a\u4e493"), @CodeItem(value="USER4", text="\u7528\u6237\u81ea\u5b9a\u4e494", realtext="\u7528\u6237\u81ea\u5b9a\u4e494")})
public class AggModeCodeListModel
extends StaticCodeListModelBase {
    public static final String SUM = "SUM";
    public static final String AVG = "AVG";
    public static final String MAX = "MAX";
    public static final String MIN = "MIN";
    public static final String COUNT = "COUNT";
    public static final String EXISTS = "EXISTS";
    public static final String NOTEXISTS = "NOTEXISTS";
    public static final String GROUP = "GROUP";
    public static final String USER = "USER";
    public static final String USER2 = "USER2";
    public static final String USER3 = "USER3";
    public static final String USER4 = "USER4";

    public AggModeCodeListModel() {
        this.initAnnotation(AggModeCodeListModel.class);
        this.setUserData2("AggMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.AggModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.AggModeCodeListModel");
    }
}

