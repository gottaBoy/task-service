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

@CodeList(id="FE18D184-64D3-4C1F-BBD2-F3EAC1FB345F", name="\u8868\u5355\u4fe1\u606f\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="0", text="\u65e0\u542f\u7528", realtext="\u65e0\u542f\u7528"), @CodeItem(value="1", text="\u542f\u7528", realtext="\u542f\u7528"), @CodeItem(value="3", text="\u542f\u7528\uff08\u9009\u62e9\u63a7\u4ef6\u81ea\u52a8\u8f6c\u6362\uff09", realtext="\u542f\u7528\uff08\u9009\u62e9\u63a7\u4ef6\u81ea\u52a8\u8f6c\u6362\uff09", userdata="\u9009\u62e9\u63a7\u4ef6\u5c06\u6839\u636e\u5f15\u7528\u6570\u636e\u662f\u5426\u63d0\u4f9b\u4fe1\u606f\u5c55\u793a\u89c6\u56fe\u8f6c\u6362\u4e3a\u94fe\u63a5\u90e8\u4ef6\u6216\u6807\u7b7e\u90e8\u4ef6"), @CodeItem(value="5", text="\u542f\u7528\uff08\u63a7\u4ef6\u4ee5\u53ea\u8bfb\u5f62\u5f0f\u5448\u73b0\uff09", realtext="\u542f\u7528\uff08\u63a7\u4ef6\u4ee5\u53ea\u8bfb\u5f62\u5f0f\u5448\u73b0\uff09", userdata="\u63a7\u4ef6\u5c06\u9ed8\u8ba4\u542f\u7528\u53ea\u8bfb\u5f62\u5f0f")})
public class FormInfoModeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer NONE = 0;
    public static final int INT_NONE = 0;
    public static final Integer ENABLED = 1;
    public static final int INT_ENABLED = 1;
    public static final Integer AUTO = 3;
    public static final int INT_AUTO = 3;
    public static final Integer READONLY = 5;
    public static final int INT_READONLY = 5;

    public FormInfoModeCodeListModel() {
        this.initAnnotation(FormInfoModeCodeListModel.class);
        this.setUserData2("InfoFormMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.FormInfoModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.FormInfoModeCodeListModel");
    }
}

