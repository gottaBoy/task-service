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

@CodeList(id="625230c9d66239d22d368256435c95e2", name="\u4e91\u5e73\u53f0\u540e\u53f0\u5904\u7406\u90e8\u4ef6", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="GRID", text="\u6570\u636e\u8868\u683c", realtext="\u6570\u636e\u8868\u683c"), @CodeItem(value="FORM", text="\u7f16\u8f91\u8868\u5355", realtext="\u7f16\u8f91\u8868\u5355"), @CodeItem(value="SEARCHFORM", text="\u641c\u7d22\u8868\u5355", realtext="\u641c\u7d22\u8868\u5355"), @CodeItem(value="DATAVIEW", text="\u6570\u636e\u89c6\u56fe", realtext="\u6570\u636e\u89c6\u56fe"), @CodeItem(value="TREEGRID", text="\u6570\u636e\u6811\u8868\u683c", realtext="\u6570\u636e\u6811\u8868\u683c"), @CodeItem(value="WFEXPBAR", text="\u6d41\u7a0b\u5bfc\u822a\u680f", realtext="\u6d41\u7a0b\u5bfc\u822a\u680f"), @CodeItem(value="TREEVIEW", text="\u6811\u89c6\u56fe", realtext="\u6811\u89c6\u56fe"), @CodeItem(value="TREEEXPBAR", text="\u6811\u89c6\u56fe\u5bfc\u822a\u680f", realtext="\u6811\u89c6\u56fe\u5bfc\u822a\u680f"), @CodeItem(value="LIST", text="\u6570\u636e\u5217\u8868", realtext="\u6570\u636e\u5217\u8868"), @CodeItem(value="CHART", text="\u6570\u636e\u56fe\u8868", realtext="\u6570\u636e\u56fe\u8868"), @CodeItem(value="CUSTOM", text="\u81ea\u5b9a\u4e49\u90e8\u4ef6", realtext="\u81ea\u5b9a\u4e49\u90e8\u4ef6"), @CodeItem(value="VIEWCONTROLLER", text="\u89c6\u56fe\u63a7\u5236\u5668", realtext="\u89c6\u56fe\u63a7\u5236\u5668"), @CodeItem(value="OTHER", text="\u5176\u5b83", realtext="\u5176\u5b83")})
public class AjaxCtrlTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String GRID = "GRID";
    public static final String FORM = "FORM";
    public static final String SEARCHFORM = "SEARCHFORM";
    public static final String DATAVIEW = "DATAVIEW";
    public static final String TREEGRID = "TREEGRID";
    public static final String WFEXPBAR = "WFEXPBAR";
    public static final String TREEVIEW = "TREEVIEW";
    public static final String TREEEXPBAR = "TREEEXPBAR";
    public static final String LIST = "LIST";
    public static final String CHART = "CHART";
    public static final String CUSTOM = "CUSTOM";
    public static final String VIEWCONTROLLER = "VIEWCONTROLLER";
    public static final String OTHER = "OTHER";

    public AjaxCtrlTypeCodeListModel() {
        this.initAnnotation(AjaxCtrlTypeCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.AjaxCtrlTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.AjaxCtrlTypeCodeListModel");
    }
}

