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

@CodeList(id="c8b45e5db176d163b0d36594270d4d32", name="\u4e91\u5e73\u53f0\u53d8\u91cf\u793a\u4f8b\u503c\uff08\u7cfb\u7edf\uff09", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="DATACONTEXT", text="\u6570\u636e\u4e0a\u4e0b\u6587", realtext="\u6570\u636e\u4e0a\u4e0b\u6587"), @CodeItem(value="GLOBALCONTEXT", text="\u5168\u5c40\u4e0a\u4e0b\u6587", realtext="\u5168\u5c40\u4e0a\u4e0b\u6587"), @CodeItem(value="SESSIONCONTEXT", text="\u7528\u6237\u4e0a\u4e0b\u6587", realtext="\u7528\u6237\u4e0a\u4e0b\u6587"), @CodeItem(value="SYSTEMCONTEXT", text="\u7cfb\u7edf\u4e0a\u4e0b\u6587", realtext="\u7cfb\u7edf\u4e0a\u4e0b\u6587"), @CodeItem(value="WEBCONTEXT", text="\u7f51\u9875\u8bf7\u6c42\u4e0a\u4e0b\u6587", realtext="\u7f51\u9875\u8bf7\u6c42\u4e0a\u4e0b\u6587")})
public class SysVarTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String DATACONTEXT = "DATACONTEXT";
    public static final String GLOBALCONTEXT = "GLOBALCONTEXT";
    public static final String SESSIONCONTEXT = "SESSIONCONTEXT";
    public static final String SYSTEMCONTEXT = "SYSTEMCONTEXT";
    public static final String WEBCONTEXT = "WEBCONTEXT";

    public SysVarTypeCodeListModel() {
        this.initAnnotation(SysVarTypeCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.SysVarTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.SysVarTypeCodeListModel");
    }
}

