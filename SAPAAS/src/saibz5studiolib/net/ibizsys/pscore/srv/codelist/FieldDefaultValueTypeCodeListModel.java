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

@CodeList(id="4cb3b0296ceaa610b2ec2d5eb5187606", name="\u754c\u9762\u9879\u9ed8\u8ba4\u503c\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="SESSION", text="\u7528\u6237\u5168\u5c40\u5bf9\u8c61", realtext="\u7528\u6237\u5168\u5c40\u5bf9\u8c61", userdata="\u5f53\u524d\u7528\u6237\u4e0a\u4e0b\u6587\uff0c\u9700\u6307\u5b9a\u5c5e\u6027\u540d\u79f0"), @CodeItem(value="APPLICATION", text="\u7cfb\u7edf\u5168\u5c40\u5bf9\u8c61", realtext="\u7cfb\u7edf\u5168\u5c40\u5bf9\u8c61", userdata="\u5f53\u524d\u7cfb\u7edf\u7684\u4e0a\u4e0b\u6587\u5bf9\u8c61\uff0c\u9700\u6307\u5b9a\u5c5e\u6027\u952e\u540d"), @CodeItem(value="UNIQUEID", text="\u552f\u4e00\u7f16\u7801", realtext="\u552f\u4e00\u7f16\u7801", userdata="\u751f\u6210\u4e00\u4e2a\u968f\u673a\u6807\u8bc6\uff0c\u4e00\u822c\u4e3aGUID"), @CodeItem(value="CONTEXT", text="\u7f51\u9875\u8bf7\u6c42", realtext="\u7f51\u9875\u8bf7\u6c42", userdata="\u5f53\u524d\u8bf7\u6c42\u7684\u53c2\u6570\u5bf9\u8c61\uff0c\u9700\u6307\u5b9a\u53c2\u6570\u540d\u79f0"), @CodeItem(value="PARAM", text="\u6570\u636e\u5bf9\u8c61\u5c5e\u6027", realtext="\u6570\u636e\u5bf9\u8c61\u5c5e\u6027", userdata="\u5f53\u524d\u5904\u7406\u7684\u6570\u636e\u5bf9\u8c61\uff0c\u9700\u6307\u5b9a\u5c5e\u6027\u540d\u79f0"), @CodeItem(value="OPERATOR", text="\u5f53\u524d\u64cd\u4f5c\u7528\u6237(\u7f16\u53f7)", realtext="\u5f53\u524d\u64cd\u4f5c\u7528\u6237(\u7f16\u53f7)", userdata="\u5f53\u524d\u7528\u6237\u6807\u8bc6"), @CodeItem(value="OPERATORNAME", text="\u5f53\u524d\u64cd\u4f5c\u7528\u6237(\u540d\u79f0)", realtext="\u5f53\u524d\u64cd\u4f5c\u7528\u6237(\u540d\u79f0)", userdata="\u5f53\u524d\u7528\u6237\u540d\u79f0"), @CodeItem(value="CURTIME", text="\u5f53\u524d\u65f6\u95f4", realtext="\u5f53\u524d\u65f6\u95f4", userdata="\u5f53\u524d\u7cfb\u7edf\u65f6\u95f4"), @CodeItem(value="APPDATA", text="\u5f53\u524d\u5e94\u7528\u6570\u636e", realtext="\u5f53\u524d\u5e94\u7528\u6570\u636e", userdata="\u5f53\u524d\u5e94\u7528\u4e0a\u4e0b\u6587\uff0c\u9700\u6307\u5b9a\u5c5e\u6027\u540d\u79f0")})
public class FieldDefaultValueTypeCodeListModel
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

    public FieldDefaultValueTypeCodeListModel() {
        this.initAnnotation(FieldDefaultValueTypeCodeListModel.class);
        this.setUserData2("CreateDefaultValueType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.FieldDefaultValueTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.FieldDefaultValueTypeCodeListModel");
    }
}

