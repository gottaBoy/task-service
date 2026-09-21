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

@CodeList(id="f5c964a551afaea257d001757a0076c6", name="\u5b9e\u4f53\u5904\u7406\u903b\u8f91\u8282\u70b9\u53c2\u6570\u6e90\u503c\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="SRCDLPARAM", text="\u6e90\u903b\u8f91\u53c2\u6570", realtext="\u6e90\u903b\u8f91\u53c2\u6570", userdata="\u6307\u5b9a\u6e90\u5904\u7406\u903b\u8f91\u53c2\u6570"), @CodeItem(value="WEBCONTEXT", text="\u7f51\u9875\u8bf7\u6c42\u4e0a\u4e0b\u6587", realtext="\u7f51\u9875\u8bf7\u6c42\u4e0a\u4e0b\u6587"), @CodeItem(value="APPDATA", text="\u5f53\u524d\u5e94\u7528\u6570\u636e", realtext="\u5f53\u524d\u5e94\u7528\u6570\u636e"), @CodeItem(value="APPLICATION", text="\u7cfb\u7edf\u5168\u5c40\u5bf9\u8c61", realtext="\u7cfb\u7edf\u5168\u5c40\u5bf9\u8c61"), @CodeItem(value="SESSION", text="\u7528\u6237\u5168\u5c40\u5bf9\u8c61", realtext="\u7528\u6237\u5168\u5c40\u5bf9\u8c61"), @CodeItem(value="DATACONTEXT", text="\u6570\u636e\u4e0a\u4e0b\u6587", realtext="\u6570\u636e\u4e0a\u4e0b\u6587"), @CodeItem(value="ENVPARAM", text="\u5f53\u524d\u73af\u5883\u53c2\u6570", realtext="\u5f53\u524d\u73af\u5883\u53c2\u6570"), @CodeItem(value="VIEWPARAM", text="\u5f53\u524d\u89c6\u56fe\u53c2\u6570", realtext="\u5f53\u524d\u89c6\u56fe\u53c2\u6570"), @CodeItem(value="NONEVALUE", text="\u65e0\u503c\uff08NONE\uff09", realtext="\u65e0\u503c\uff08NONE\uff09"), @CodeItem(value="NULLVALUE", text="\u7a7a\u503c\uff08NULL\uff09", realtext="\u7a7a\u503c\uff08NULL\uff09"), @CodeItem(value="SRCVALUE", text="\u76f4\u63a5\u503c", realtext="\u76f4\u63a5\u503c"), @CodeItem(value="EXPRESSION", text="\u8ba1\u7b97\u5f0f", realtext="\u8ba1\u7b97\u5f0f"), @CodeItem(value="COUNT", text="\u6570\u7ec4\u6570\u91cf", realtext="\u6570\u7ec4\u6570\u91cf"), @CodeItem(value="AGGREGATION", text="\u6570\u7ec4\u805a\u5408\u8ba1\u7b97", realtext="\u6570\u7ec4\u805a\u5408\u8ba1\u7b97"), @CodeItem(value="SEQUENCE", text="\u7cfb\u7edf\u503c\u5e8f\u5217", realtext="\u7cfb\u7edf\u503c\u5e8f\u5217")})
public class DELogicParamValueTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String SRCDLPARAM = "SRCDLPARAM";
    public static final String WEBCONTEXT = "WEBCONTEXT";
    public static final String APPDATA = "APPDATA";
    public static final String APPLICATION = "APPLICATION";
    public static final String SESSION = "SESSION";
    public static final String DATACONTEXT = "DATACONTEXT";
    public static final String ENVPARAM = "ENVPARAM";
    public static final String VIEWPARAM = "VIEWPARAM";
    public static final String NONEVALUE = "NONEVALUE";
    public static final String NULLVALUE = "NULLVALUE";
    public static final String SRCVALUE = "SRCVALUE";
    public static final String EXPRESSION = "EXPRESSION";
    public static final String COUNT = "COUNT";
    public static final String AGGREGATION = "AGGREGATION";
    public static final String SEQUENCE = "SEQUENCE";

    public DELogicParamValueTypeCodeListModel() {
        this.initAnnotation(DELogicParamValueTypeCodeListModel.class);
        this.setUserData2("DELogicParamValueType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DELogicParamValueTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DELogicParamValueTypeCodeListModel");
    }
}

