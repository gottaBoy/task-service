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

@CodeList(id="7ee89be6308ec343d1ffd0c5a03af48b", name="\u4e91\u5e73\u53f0\u53d8\u91cf\u793a\u4f8b\u503c", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="SESSION", text="[\u8868\u5355]\u7528\u6237\u5168\u5c40\u5bf9\u8c61", realtext="[\u8868\u5355]\u7528\u6237\u5168\u5c40\u5bf9\u8c61"), @CodeItem(value="APPLICATION", text="[\u8868\u5355]\u7cfb\u7edf\u5168\u5c40\u5bf9\u8c61", realtext="[\u8868\u5355]\u7cfb\u7edf\u5168\u5c40\u5bf9\u8c61"), @CodeItem(value="UNIQUEID", text="[\u8868\u5355]\u552f\u4e00\u7f16\u7801", realtext="[\u8868\u5355]\u552f\u4e00\u7f16\u7801"), @CodeItem(value="CONTEXT", text="[\u8868\u5355]\u7f51\u9875\u8bf7\u6c42", realtext="[\u8868\u5355]\u7f51\u9875\u8bf7\u6c42"), @CodeItem(value="PARAM", text="[\u8868\u5355]\u6570\u636e\u5bf9\u8c61\u5c5e\u6027", realtext="[\u8868\u5355]\u6570\u636e\u5bf9\u8c61\u5c5e\u6027"), @CodeItem(value="OPERATOR", text="[\u8868\u5355]\u5f53\u524d\u64cd\u4f5c\u7528\u6237(\u7f16\u53f7)", realtext="[\u8868\u5355]\u5f53\u524d\u64cd\u4f5c\u7528\u6237(\u7f16\u53f7)"), @CodeItem(value="OPERATORNAME", text="[\u8868\u5355]\u5f53\u524d\u64cd\u4f5c\u7528\u6237(\u540d\u79f0)", realtext="[\u8868\u5355]\u5f53\u524d\u64cd\u4f5c\u7528\u6237(\u540d\u79f0)"), @CodeItem(value="CURTIME", text="[\u8868\u5355]\u5f53\u524d\u65f6\u95f4", realtext="[\u8868\u5355]\u5f53\u524d\u65f6\u95f4"), @CodeItem(value="DATACONTEXT", text="[\u7cfb\u7edf]\u6570\u636e\u4e0a\u4e0b\u6587", realtext="[\u7cfb\u7edf]\u6570\u636e\u4e0a\u4e0b\u6587"), @CodeItem(value="GLOBALCONTEXT", text="[\u7cfb\u7edf]\u5168\u5c40\u4e0a\u4e0b\u6587", realtext="[\u7cfb\u7edf]\u5168\u5c40\u4e0a\u4e0b\u6587"), @CodeItem(value="SESSIONCONTEXT", text="[\u7cfb\u7edf]\u7528\u6237\u4e0a\u4e0b\u6587", realtext="[\u7cfb\u7edf]\u7528\u6237\u4e0a\u4e0b\u6587"), @CodeItem(value="SYSTEMCONTEXT", text="[\u7cfb\u7edf]\u7cfb\u7edf\u4e0a\u4e0b\u6587", realtext="[\u7cfb\u7edf]\u7cfb\u7edf\u4e0a\u4e0b\u6587"), @CodeItem(value="WEBCONTEXT", text="[\u7cfb\u7edf]\u7f51\u9875\u8bf7\u6c42\u4e0a\u4e0b\u6587", realtext="[\u7cfb\u7edf]\u7f51\u9875\u8bf7\u6c42\u4e0a\u4e0b\u6587")})
public class PSVarTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String SESSION = "SESSION";
    public static final String APPLICATION = "APPLICATION";
    public static final String UNIQUEID = "UNIQUEID";
    public static final String CONTEXT = "CONTEXT";
    public static final String PARAM = "PARAM";
    public static final String OPERATOR = "OPERATOR";
    public static final String OPERATORNAME = "OPERATORNAME";
    public static final String CURTIME = "CURTIME";
    public static final String DATACONTEXT = "DATACONTEXT";
    public static final String GLOBALCONTEXT = "GLOBALCONTEXT";
    public static final String SESSIONCONTEXT = "SESSIONCONTEXT";
    public static final String SYSTEMCONTEXT = "SYSTEMCONTEXT";
    public static final String WEBCONTEXT = "WEBCONTEXT";

    public PSVarTypeCodeListModel() {
        this.initAnnotation(PSVarTypeCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.PSVarTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.PSVarTypeCodeListModel");
    }
}

