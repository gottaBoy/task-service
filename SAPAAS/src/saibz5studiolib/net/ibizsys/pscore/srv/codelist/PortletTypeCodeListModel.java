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

@CodeList(id="abda81caa87ba3b0b5bdd42ea06e8a15", name="\u4e91\u5e73\u53f0\u95e8\u6237\u90e8\u4ef6\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="LIST", text="\u5b9e\u4f53\u5217\u8868", realtext="\u5b9e\u4f53\u5217\u8868", userdata="\u5d4c\u5165\u5b9e\u4f53\u6570\u636e\u5217\u8868\u90e8\u4ef6"), @CodeItem(value="CHART", text="\u5b9e\u4f53\u56fe\u8868", realtext="\u5b9e\u4f53\u56fe\u8868", userdata="\u5d4c\u5165\u5b9e\u4f53\u56fe\u8868\u90e8\u4ef6"), @CodeItem(value="VIEW", text="\u5b9e\u4f53\u89c6\u56fe", realtext="\u5b9e\u4f53\u89c6\u56fe", userdata="\u5d4c\u5165\u5b9e\u4f53\u89c6\u56fe\u90e8\u4ef6"), @CodeItem(value="REPORT", text="\u5b9e\u4f53\u62a5\u8868", realtext="\u5b9e\u4f53\u62a5\u8868", userdata="\u5d4c\u5165\u5b9e\u4f53\u62a5\u8868\u90e8\u4ef6"), @CodeItem(value="HTML", text="\u7f51\u9875\u90e8\u4ef6", realtext="\u7f51\u9875\u90e8\u4ef6", userdata="\u5d4c\u5165\u6307\u5b9aHTML\u8def\u5f84\u7684\u5185\u5bb9"), @CodeItem(value="TOOLBAR", text="\u5de5\u5177\u680f", realtext="\u5de5\u5177\u680f", userdata="\u5d4c\u5165\u5b9e\u4f53\u5de5\u5177\u680f\u90e8\u4ef6"), @CodeItem(value="ACTIONBAR", text="\u64cd\u4f5c\u680f", realtext="\u64cd\u4f5c\u680f", userdata="\u63d0\u4f9b\u6307\u5b9a\u754c\u9762\u884c\u4e3a\u7ec4\u7684\u64cd\u4f5c\u680f"), @CodeItem(value="FILTER", text="\u8fc7\u6ee4\u5668", realtext="\u8fc7\u6ee4\u5668"), @CodeItem(value="CUSTOM", text="\u81ea\u5b9a\u4e49", realtext="\u81ea\u5b9a\u4e49", userdata="\u81ea\u5b9a\u4e49\u95e8\u6237\u90e8\u4ef6")})
public class PortletTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String LIST = "LIST";
    public static final String CHART = "CHART";
    public static final String VIEW = "VIEW";
    public static final String REPORT = "REPORT";
    public static final String HTML = "HTML";
    public static final String TOOLBAR = "TOOLBAR";
    public static final String ACTIONBAR = "ACTIONBAR";
    public static final String FILTER = "FILTER";
    public static final String CUSTOM = "CUSTOM";

    public PortletTypeCodeListModel() {
        this.initAnnotation(PortletTypeCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.PortletTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.PortletTypeCodeListModel");
    }
}

