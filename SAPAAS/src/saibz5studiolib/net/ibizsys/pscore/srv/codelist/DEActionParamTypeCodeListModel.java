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

@CodeList(id="05034ce6590d21d9ea1bd254d9e7c4f8", name="\u5b9e\u4f53\u884c\u4e3a\u53c2\u6570\u503c\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u4e0d\u8bbe\u7f6e\uff09")
@CodeItems(value={@CodeItem(value="INPUTVALUE", text="\u8f93\u5165\u503c\uff08\u9ed8\u8ba4\uff09", realtext="\u8f93\u5165\u503c\uff08\u9ed8\u8ba4\uff09", userdata="\u63a5\u53d7\u6307\u5b9a\u53c2\u6570\u7684\u4f20\u5165\u503c"), @CodeItem(value="NONEVALUE", text="\u65e0\u503c\uff08\u4e0d\u8bbe\u7f6e\uff09", realtext="\u65e0\u503c\uff08\u4e0d\u8bbe\u7f6e\uff09", userdata="\u5ffd\u7565\u6307\u5b9a\u53c2\u6570\u7684\u4f20\u5165\u503c"), @CodeItem(value="PARAM", text="\u6570\u636e\u5bf9\u8c61\u5c5e\u6027", realtext="\u6570\u636e\u5bf9\u8c61\u5c5e\u6027", userdata="\u53c2\u6570\u503c\u6765\u81ea\u4f20\u5165\u6570\u636e\u5bf9\u8c61\u7684\u5c5e\u6027\uff0c\u9700\u6307\u5b9a\u5c5e\u6027\u952e\u540d"), @CodeItem(value="VALUE", text="\u6307\u5b9a\u503c", realtext="\u6307\u5b9a\u503c", userdata="\u53c2\u6570\u503c\u6765\u81ea\u8bbe\u5b9a\u7684\u76f4\u63a5\u503c"), @CodeItem(value="NULLVALUE", text="\u7a7a\u503c", realtext="\u7a7a\u503c", userdata="\u53c2\u6570\u503c\u8bbe\u5b9a\u4e3a\u7a7a\u503c"), @CodeItem(value="SESSION", text="\u7528\u6237\u5168\u5c40\u5bf9\u8c61", realtext="\u7528\u6237\u5168\u5c40\u5bf9\u8c61", userdata="\u53c2\u6570\u503c\u6765\u81ea\u7528\u6237\u4e0a\u4e0b\u6587\u5bf9\u8c61\u7684\u5c5e\u6027\uff0c\u9700\u6307\u5b9a\u5c5e\u6027\u952e\u540d"), @CodeItem(value="APPLICATION", text="\u7cfb\u7edf\u5168\u5c40\u5bf9\u8c61", realtext="\u7cfb\u7edf\u5168\u5c40\u5bf9\u8c61", userdata="\u53c2\u6570\u503c\u6765\u81ea\u7cfb\u7edf\u4e0a\u4e0b\u6587\u5bf9\u8c61\u7684\u5c5e\u6027\uff0c\u9700\u6307\u5b9a\u5c5e\u6027\u952e\u540d"), @CodeItem(value="UNIQUEID", text="\u552f\u4e00\u7f16\u7801", realtext="\u552f\u4e00\u7f16\u7801", userdata="\u53c2\u6570\u503c\u8bbe\u5b9a\u4e3a\u751f\u968f\u673a\u6807\u8bc6"), @CodeItem(value="CONTEXT", text="\u7f51\u9875\u8bf7\u6c42", realtext="\u7f51\u9875\u8bf7\u6c42", userdata="\u53c2\u6570\u503c\u6765\u81ea\u5f53\u524d\u8bf7\u6c42\u7684\u53c2\u6570\u5bf9\u8c61\uff0c\u9700\u6307\u5b9a\u5c5e\u6027\u952e\u540d"), @CodeItem(value="OPERATOR", text="\u5f53\u524d\u64cd\u4f5c\u7528\u6237(\u7f16\u53f7)", realtext="\u5f53\u524d\u64cd\u4f5c\u7528\u6237(\u7f16\u53f7)", userdata="\u53c2\u6570\u503c\u8bbe\u5b9a\u4e3a\u5f53\u524d\u7528\u6237\u6807\u8bc6"), @CodeItem(value="OPERATORNAME", text="\u5f53\u524d\u64cd\u4f5c\u7528\u6237(\u540d\u79f0)", realtext="\u5f53\u524d\u64cd\u4f5c\u7528\u6237(\u540d\u79f0)", userdata="\u53c2\u6570\u503c\u8bbe\u5b9a\u4e3a\u5f53\u524d\u7528\u6237\u540d\u79f0"), @CodeItem(value="CURTIME", text="\u5f53\u524d\u65f6\u95f4", realtext="\u5f53\u524d\u65f6\u95f4", userdata="\u53c2\u6570\u503c\u8bbe\u5b9a\u4e3a\u5f53\u524d\u65f6\u95f4"), @CodeItem(value="APPDATA", text="\u5f53\u524d\u5e94\u7528\u6570\u636e", realtext="\u5f53\u524d\u5e94\u7528\u6570\u636e", userdata="\u53c2\u6570\u503c\u6765\u81ea\u5e94\u7528\u4e0a\u4e0b\u6587\u5bf9\u8c61\u7684\u5c5e\u6027\uff0c\u9700\u6307\u5b9a\u5c5e\u6027\u952e\u540d"), @CodeItem(value="EXPRESSION", text="\u8868\u8fbe\u5f0f", realtext="\u8868\u8fbe\u5f0f", userdata="\u53c2\u6570\u503c\u6765\u81ea\u8ba1\u7b97\u8868\u8fbe\u5f0f"), @CodeItem(value="USER", text="\u7528\u6237\u81ea\u5b9a\u4e49", realtext="\u7528\u6237\u81ea\u5b9a\u4e49"), @CodeItem(value="USER2", text="\u7528\u6237\u81ea\u5b9a\u4e492", realtext="\u7528\u6237\u81ea\u5b9a\u4e492"), @CodeItem(value="USER3", text="\u7528\u6237\u81ea\u5b9a\u4e493", realtext="\u7528\u6237\u81ea\u5b9a\u4e493"), @CodeItem(value="USER4", text="\u7528\u6237\u81ea\u5b9a\u4e494", realtext="\u7528\u6237\u81ea\u5b9a\u4e494")})
public class DEActionParamTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String INPUTVALUE = "INPUTVALUE";
    public static final String NONEVALUE = "NONEVALUE";
    public static final String PARAM = "PARAM";
    public static final String VALUE = "VALUE";
    public static final String NULLVALUE = "NULLVALUE";
    public static final String SESSION = "SESSION";
    public static final String APPLICATION = "APPLICATION";
    public static final String UNIQUEID = "UNIQUEID";
    public static final String CONTEXT = "CONTEXT";
    public static final String OPERATOR = "OPERATOR";
    public static final String OPERATORNAME = "OPERATORNAME";
    public static final String CURTIME = "CURTIME";
    public static final String APPDATA = "APPDATA";
    public static final String EXPRESSION = "EXPRESSION";
    public static final String USER = "USER";
    public static final String USER2 = "USER2";
    public static final String USER3 = "USER3";
    public static final String USER4 = "USER4";

    public DEActionParamTypeCodeListModel() {
        this.initAnnotation(DEActionParamTypeCodeListModel.class);
        this.setUserData2("DEActionParamValueType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEActionParamTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEActionParamTypeCodeListModel");
    }
}

