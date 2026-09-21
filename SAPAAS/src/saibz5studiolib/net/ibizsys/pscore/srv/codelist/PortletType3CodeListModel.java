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

@CodeList(id="A83CCA7B-3189-4FCD-AF6C-1070FEC398C1", name="\u4e91\u5e73\u53f0\u95e8\u6237\u90e8\u4ef6\u7c7b\u578b\uff08\u5168\u90e8\uff09", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="LIST", text="\u5b9e\u4f53\u5217\u8868", realtext="\u5b9e\u4f53\u5217\u8868"), @CodeItem(value="CHART", text="\u5b9e\u4f53\u56fe\u8868", realtext="\u5b9e\u4f53\u56fe\u8868"), @CodeItem(value="VIEW", text="\u7cfb\u7edf\u89c6\u56fe", realtext="\u7cfb\u7edf\u89c6\u56fe"), @CodeItem(value="REPORT", text="\u5b9e\u4f53\u62a5\u8868", realtext="\u5b9e\u4f53\u62a5\u8868", userdata="\u5d4c\u5165\u5b9e\u4f53\u62a5\u8868\u90e8\u4ef6"), @CodeItem(value="HTML", text="\u7f51\u9875\u90e8\u4ef6", realtext="\u7f51\u9875\u90e8\u4ef6"), @CodeItem(value="FILTER", text="\u8fc7\u6ee4\u5668", realtext="\u8fc7\u6ee4\u5668"), @CodeItem(value="TOOLBAR", text="\u5de5\u5177\u680f", realtext="\u5de5\u5177\u680f"), @CodeItem(value="ACTIONBAR", text="\u64cd\u4f5c\u680f", realtext="\u64cd\u4f5c\u680f"), @CodeItem(value="CUSTOM", text="\u81ea\u5b9a\u4e49", realtext="\u81ea\u5b9a\u4e49"), @CodeItem(value="APPMENU", text="\u5feb\u6377\u83dc\u5355\u680f", realtext="\u5feb\u6377\u83dc\u5355\u680f"), @CodeItem(value="CONTAINER", text="\u5e03\u5c40\u5bb9\u5668", realtext="\u5e03\u5c40\u5bb9\u5668"), @CodeItem(value="RAWITEM", text="\u76f4\u63a5\u5185\u5bb9", realtext="\u76f4\u63a5\u5185\u5bb9")})
public class PortletType3CodeListModel
extends StaticCodeListModelBase {
    public static final String LIST = "LIST";
    public static final String CHART = "CHART";
    public static final String VIEW = "VIEW";
    public static final String REPORT = "REPORT";
    public static final String HTML = "HTML";
    public static final String FILTER = "FILTER";
    public static final String TOOLBAR = "TOOLBAR";
    public static final String ACTIONBAR = "ACTIONBAR";
    public static final String CUSTOM = "CUSTOM";
    public static final String APPMENU = "APPMENU";
    public static final String CONTAINER = "CONTAINER";
    public static final String RAWITEM = "RAWITEM";

    public PortletType3CodeListModel() {
        this.initAnnotation(PortletType3CodeListModel.class);
        this.setUserData2("PortletType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.PortletType3CodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.PortletType3CodeListModel");
    }
}

