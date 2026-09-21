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

@CodeList(id="3d14e38dcb6906a65dfdb6d40960617c", name="\u4e91\u5e73\u53f0\u53d8\u91cf\u793a\u4f8b\u503c\uff08\u8868\u5355\uff09", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="SESSION", text="\u7528\u6237\u5168\u5c40\u5bf9\u8c61", realtext="\u7528\u6237\u5168\u5c40\u5bf9\u8c61"), @CodeItem(value="APPLICATION", text="\u7cfb\u7edf\u5168\u5c40\u5bf9\u8c61", realtext="\u7cfb\u7edf\u5168\u5c40\u5bf9\u8c61"), @CodeItem(value="UNIQUEID", text="\u552f\u4e00\u7f16\u7801", realtext="\u552f\u4e00\u7f16\u7801"), @CodeItem(value="CONTEXT", text="\u7f51\u9875\u8bf7\u6c42", realtext="\u7f51\u9875\u8bf7\u6c42"), @CodeItem(value="PARAM", text="\u6570\u636e\u5bf9\u8c61\u5c5e\u6027", realtext="\u6570\u636e\u5bf9\u8c61\u5c5e\u6027"), @CodeItem(value="OPERATOR", text="\u5f53\u524d\u64cd\u4f5c\u7528\u6237(\u7f16\u53f7)", realtext="\u5f53\u524d\u64cd\u4f5c\u7528\u6237(\u7f16\u53f7)"), @CodeItem(value="OPERATORNAME", text="\u5f53\u524d\u64cd\u4f5c\u7528\u6237(\u540d\u79f0)", realtext="\u5f53\u524d\u64cd\u4f5c\u7528\u6237(\u540d\u79f0)"), @CodeItem(value="CURTIME", text="\u5f53\u524d\u65f6\u95f4", realtext="\u5f53\u524d\u65f6\u95f4")})
public class FormVarTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String SESSION = "SESSION";
    public static final String APPLICATION = "APPLICATION";
    public static final String UNIQUEID = "UNIQUEID";
    public static final String CONTEXT = "CONTEXT";
    public static final String PARAM = "PARAM";
    public static final String OPERATOR = "OPERATOR";
    public static final String OPERATORNAME = "OPERATORNAME";
    public static final String CURTIME = "CURTIME";

    public FormVarTypeCodeListModel() {
        this.initAnnotation(FormVarTypeCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.FormVarTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.FormVarTypeCodeListModel");
    }
}

