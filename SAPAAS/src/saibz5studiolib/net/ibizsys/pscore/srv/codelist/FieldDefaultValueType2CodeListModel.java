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

@CodeList(id="B2021658-6740-4A22-B525-3DF1278FE228", name="\u754c\u9762\u9879\u9ed8\u8ba4\u503c\u7c7b\u578b\uff08\u66f4\u65b0\uff09", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="RESET", text="\u7f6e\u7a7a\u5f53\u524d\u503c", realtext="\u7f6e\u7a7a\u5f53\u524d\u503c", userdata="\u7f6e\u7a7a\u5f53\u524d\u503c"), @CodeItem(value="SESSION", text="\u7528\u6237\u5168\u5c40\u5bf9\u8c61", realtext="\u7528\u6237\u5168\u5c40\u5bf9\u8c61", userdata="\u5f53\u524d\u7528\u6237\u7684\u4e0a\u4e0b\u6587\u5bf9\u8c61\uff0c\u9700\u6307\u5b9a\u5c5e\u6027\u952e\u540d"), @CodeItem(value="APPLICATION", text="\u7cfb\u7edf\u5168\u5c40\u5bf9\u8c61", realtext="\u7cfb\u7edf\u5168\u5c40\u5bf9\u8c61", userdata="\u5f53\u524d\u7cfb\u7edf\u7684\u4e0a\u4e0b\u6587\u5bf9\u8c61\uff0c\u9700\u6307\u5b9a\u5c5e\u6027\u952e\u540d"), @CodeItem(value="UNIQUEID", text="\u552f\u4e00\u7f16\u7801", realtext="\u552f\u4e00\u7f16\u7801", userdata="\u751f\u6210\u4e00\u4e2a\u968f\u673a\u6807\u8bc6\uff0c\u4e00\u822c\u4f7f\u7528GUID"), @CodeItem(value="CONTEXT", text="\u7f51\u9875\u8bf7\u6c42", realtext="\u7f51\u9875\u8bf7\u6c42", userdata="\u5f53\u524d\u8bf7\u6c42\u7684\u53c2\u6570\u5bf9\u8c61\uff0c\u9700\u6307\u5b9a\u5c5e\u6027\u952e\u540d"), @CodeItem(value="PARAM", text="\u6570\u636e\u5bf9\u8c61\u5c5e\u6027", realtext="\u6570\u636e\u5bf9\u8c61\u5c5e\u6027", userdata="\u5f53\u524d\u5904\u7406\u7684\u6570\u636e\u5bf9\u8c61\uff0c\u9700\u6307\u5b9a\u5c5e\u6027\u952e\u540d\uff0c\u6570\u636e\u5bf9\u8c61\u5c5e\u6027\u7684\u5904\u7406\u4e00\u822c\u653e\u5728\u6700\u540e\uff0c\u8ba9\u5176\u5b83\u903b\u8f91\u5148\u5b8c\u6210\u6570\u636e\u5bf9\u8c61\u586b\u5145"), @CodeItem(value="OPERATOR", text="\u5f53\u524d\u64cd\u4f5c\u7528\u6237(\u7f16\u53f7)", realtext="\u5f53\u524d\u64cd\u4f5c\u7528\u6237(\u7f16\u53f7)", userdata="\u5f53\u524d\u5904\u7406\u7684\u7528\u6237\u6807\u8bc6"), @CodeItem(value="OPERATORNAME", text="\u5f53\u524d\u64cd\u4f5c\u7528\u6237(\u540d\u79f0)", realtext="\u5f53\u524d\u64cd\u4f5c\u7528\u6237(\u540d\u79f0)", userdata="\u5f53\u524d\u5904\u7406\u7684\u7528\u6237\u540d\u79f0"), @CodeItem(value="CURTIME", text="\u5f53\u524d\u65f6\u95f4", realtext="\u5f53\u524d\u65f6\u95f4", userdata="\u5f53\u524d\u7cfb\u7edf\u65f6\u95f4"), @CodeItem(value="APPDATA", text="\u5f53\u524d\u5e94\u7528\u6570\u636e", realtext="\u5f53\u524d\u5e94\u7528\u6570\u636e", userdata="\u5f53\u524d\u5e94\u7528\u7684\u4e0a\u4e0b\u6587\u5bf9\u8c61\uff0c\u9700\u6307\u5b9a\u5c5e\u6027\u952e\u540d\u3002\u5f53\u524d\u5e94\u7528\u6307\u6b63\u5728\u8fd0\u884c\u7684\u524d\u7aef\u7a0b\u5e8f\u7684\u73af\u5883\u53d8\u91cf\uff0c\u5982\u5e94\u7528\u6253\u5f00\u7684\u6570\u636e\uff0c\u4f7f\u7528\u7684\u7528\u6237\u8eab\u4efd\u7b49")})
public class FieldDefaultValueType2CodeListModel
extends StaticCodeListModelBase {
    public static final String RESET = "RESET";
    public static final String SESSION = "SESSION";
    public static final String APPLICATION = "APPLICATION";
    public static final String UNIQUEID = "UNIQUEID";
    public static final String CONTEXT = "CONTEXT";
    public static final String PARAM = "PARAM";
    public static final String OPERATOR = "OPERATOR";
    public static final String OPERATORNAME = "OPERATORNAME";
    public static final String CURTIME = "CURTIME";
    public static final String APPDATA = "APPDATA";

    public FieldDefaultValueType2CodeListModel() {
        this.initAnnotation(FieldDefaultValueType2CodeListModel.class);
        this.setUserData("IGNOREMODELDSL");
        this.setUserData2("UpdateDefaultValueType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.FieldDefaultValueType2CodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.FieldDefaultValueType2CodeListModel");
    }
}

