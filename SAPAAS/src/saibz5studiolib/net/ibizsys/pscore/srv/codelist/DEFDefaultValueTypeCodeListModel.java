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

@CodeList(id="0328f2d2338826529c9064577f06b263", name="\u5b9e\u4f53\u5c5e\u6027\u9ed8\u8ba4\u503c\u7c7b\u578b", type="STATIC", userscope=false, emptytext="")
@CodeItems(value={@CodeItem(value="SESSION", text="\u7528\u6237\u5168\u5c40\u5bf9\u8c61", realtext="\u7528\u6237\u5168\u5c40\u5bf9\u8c61", userdata="\u9700\u8981\u6307\u5b9a\u9ed8\u8ba4\u503c\u4f5c\u4e3a\u53c2\u6570\u540d\u79f0"), @CodeItem(value="APPLICATION", text="\u7cfb\u7edf\u5168\u5c40\u5bf9\u8c61", realtext="\u7cfb\u7edf\u5168\u5c40\u5bf9\u8c61", userdata="\u9700\u8981\u6307\u5b9a\u9ed8\u8ba4\u503c\u4f5c\u4e3a\u53c2\u6570\u540d\u79f0"), @CodeItem(value="UNIQUEID", text="\u552f\u4e00\u7f16\u7801", realtext="\u552f\u4e00\u7f16\u7801"), @CodeItem(value="CONTEXT", text="\u7f51\u9875\u8bf7\u6c42", realtext="\u7f51\u9875\u8bf7\u6c42", userdata="\u9700\u8981\u6307\u5b9a\u9ed8\u8ba4\u503c\u4f5c\u4e3a\u53c2\u6570\u540d\u79f0"), @CodeItem(value="PARAM", text="\u6570\u636e\u5bf9\u8c61\u5c5e\u6027", realtext="\u6570\u636e\u5bf9\u8c61\u5c5e\u6027", userdata="\u9700\u8981\u6307\u5b9a\u9ed8\u8ba4\u503c\u4f5c\u4e3a\u53c2\u6570\u540d\u79f0"), @CodeItem(value="OPERATOR", text="\u5f53\u524d\u64cd\u4f5c\u7528\u6237(\u7f16\u53f7)", realtext="\u5f53\u524d\u64cd\u4f5c\u7528\u6237(\u7f16\u53f7)"), @CodeItem(value="OPERATORNAME", text="\u5f53\u524d\u64cd\u4f5c\u7528\u6237(\u540d\u79f0)", realtext="\u5f53\u524d\u64cd\u4f5c\u7528\u6237(\u540d\u79f0)"), @CodeItem(value="CURTIME", text="\u5f53\u524d\u65f6\u95f4", realtext="\u5f53\u524d\u65f6\u95f4"), @CodeItem(value="APPDATA", text="\u5f53\u524d\u5e94\u7528\u6570\u636e", realtext="\u5f53\u524d\u5e94\u7528\u6570\u636e", userdata="\u9700\u8981\u6307\u5b9a\u9ed8\u8ba4\u503c\u4f5c\u4e3a\u53c2\u6570\u540d\u79f0"), @CodeItem(value="EXPRESSION", text="\u8868\u8fbe\u5f0f", realtext="\u8868\u8fbe\u5f0f", userdata="\u9700\u8981\u6307\u5b9a\u9ed8\u8ba4\u503c\u4f5c\u4e3a\u8ba1\u7b97\u8868\u8fbe\u5f0f"), @CodeItem(value="ORDERVALUE", text="\u6392\u5e8f\u503c", realtext="\u6392\u5e8f\u503c", userdata="\u53ef\u6307\u5b9a\u521d\u59cb\u5316\u53ca\u6b65\u8fdb\u503c\uff0c\u9ed8\u8ba4\u4e3a1,1\u3002"), @CodeItem(value="USER", text="\u7528\u6237\u81ea\u5b9a\u4e49", realtext="\u7528\u6237\u81ea\u5b9a\u4e49"), @CodeItem(value="USER2", text="\u7528\u6237\u81ea\u5b9a\u4e492", realtext="\u7528\u6237\u81ea\u5b9a\u4e492"), @CodeItem(value="USER3", text="\u7528\u6237\u81ea\u5b9a\u4e493", realtext="\u7528\u6237\u81ea\u5b9a\u4e493"), @CodeItem(value="USER4", text="\u7528\u6237\u81ea\u5b9a\u4e494", realtext="\u7528\u6237\u81ea\u5b9a\u4e494")})
public class DEFDefaultValueTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String SESSION = "SESSION";
    public static final String APPLICATION = "APPLICATION";
    public static final String UNIQUEID = "UNIQUEID";
    public static final String CONTEXT = "CONTEXT";
    public static final String PARAM = "PARAM";
    public static final String OPERATOR = "OPERATOR";
    public static final String OPERATORNAME = "OPERATORNAME";
    public static final String CURTIME = "CURTIME";
    public static final String APPDATA = "APPDATA";
    public static final String EXPRESSION = "EXPRESSION";
    public static final String ORDERVALUE = "ORDERVALUE";
    public static final String USER = "USER";
    public static final String USER2 = "USER2";
    public static final String USER3 = "USER3";
    public static final String USER4 = "USER4";

    public DEFDefaultValueTypeCodeListModel() {
        this.initAnnotation(DEFDefaultValueTypeCodeListModel.class);
        this.setUserData2("DEFDefaultValueType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEFDefaultValueTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEFDefaultValueTypeCodeListModel");
    }
}

