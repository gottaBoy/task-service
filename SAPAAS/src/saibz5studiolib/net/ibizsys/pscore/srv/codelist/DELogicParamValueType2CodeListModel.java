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

@CodeList(id="0F2CA2FE-D9A7-4F29-965F-895227FA355C", name="\u4e91\u5b9e\u4f53\u5904\u7406\u903b\u8f91\u8282\u70b9\u53c2\u6570\u6e90\u503c\u7c7b\u578b\uff08\u652f\u6301\u903b\u8f91\u53c2\u6570\uff09", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="LOGICPARAM", text="\u903b\u8f91\u53c2\u6570\u5bf9\u8c61", realtext="\u903b\u8f91\u53c2\u6570\u5bf9\u8c61"), @CodeItem(value="LOGICPARAMFIELD", text="\u903b\u8f91\u53c2\u6570\u5c5e\u6027", realtext="\u903b\u8f91\u53c2\u6570\u5c5e\u6027"), @CodeItem(value="WEBCONTEXT", text="\u7f51\u9875\u8bf7\u6c42\u4e0a\u4e0b\u6587", realtext="\u7f51\u9875\u8bf7\u6c42\u4e0a\u4e0b\u6587"), @CodeItem(value="APPDATA", text="\u5f53\u524d\u5e94\u7528\u6570\u636e", realtext="\u5f53\u524d\u5e94\u7528\u6570\u636e"), @CodeItem(value="APPLICATION", text="\u7cfb\u7edf\u5168\u5c40\u5bf9\u8c61", realtext="\u7cfb\u7edf\u5168\u5c40\u5bf9\u8c61"), @CodeItem(value="SESSION", text="\u7528\u6237\u5168\u5c40\u5bf9\u8c61", realtext="\u7528\u6237\u5168\u5c40\u5bf9\u8c61"), @CodeItem(value="DATACONTEXT", text="\u6570\u636e\u4e0a\u4e0b\u6587", realtext="\u6570\u636e\u4e0a\u4e0b\u6587"), @CodeItem(value="ENVPARAM", text="\u5f53\u524d\u73af\u5883\u53c2\u6570", realtext="\u5f53\u524d\u73af\u5883\u53c2\u6570"), @CodeItem(value="VIEWPARAM", text="\u5f53\u524d\u89c6\u56fe\u53c2\u6570", realtext="\u5f53\u524d\u89c6\u56fe\u53c2\u6570"), @CodeItem(value="NULLVALUE", text="\u7a7a\u503c\uff08NULL\uff09", realtext="\u7a7a\u503c\uff08NULL\uff09"), @CodeItem(value="SRCVALUE", text="\u76f4\u63a5\u503c", realtext="\u76f4\u63a5\u503c"), @CodeItem(value="EXPRESSION", text="\u8ba1\u7b97\u5f0f", realtext="\u8ba1\u7b97\u5f0f")})
public class DELogicParamValueType2CodeListModel
extends StaticCodeListModelBase {
    public static final String LOGICPARAM = "LOGICPARAM";
    public static final String LOGICPARAMFIELD = "LOGICPARAMFIELD";
    public static final String WEBCONTEXT = "WEBCONTEXT";
    public static final String APPDATA = "APPDATA";
    public static final String APPLICATION = "APPLICATION";
    public static final String SESSION = "SESSION";
    public static final String DATACONTEXT = "DATACONTEXT";
    public static final String ENVPARAM = "ENVPARAM";
    public static final String VIEWPARAM = "VIEWPARAM";
    public static final String NULLVALUE = "NULLVALUE";
    public static final String SRCVALUE = "SRCVALUE";
    public static final String EXPRESSION = "EXPRESSION";

    public DELogicParamValueType2CodeListModel() {
        this.initAnnotation(DELogicParamValueType2CodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DELogicParamValueType2CodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DELogicParamValueType2CodeListModel");
    }
}

