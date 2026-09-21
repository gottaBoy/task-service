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

@CodeList(id="d99089ee3e8feac00584558319c9b069", name="\u5916\u90e8\u63a5\u53e3\u5bf9\u8c61\u5c5e\u6027\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="SIMPLE", text="\u7b80\u5355\u503c", realtext="\u7b80\u5355\u503c"), @CodeItem(value="SUBSYSSADE", text="\u5f15\u7528\u63a5\u53e3\u5bf9\u8c61", realtext="\u5f15\u7528\u63a5\u53e3\u5bf9\u8c61")})
public class SubSysSADEFieldTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String SIMPLE = "SIMPLE";
    public static final String SUBSYSSADE = "SUBSYSSADE";

    public SubSysSADEFieldTypeCodeListModel() {
        this.initAnnotation(SubSysSADEFieldTypeCodeListModel.class);
        this.setUserData2("SubSysSADEFieldType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.SubSysSADEFieldTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.SubSysSADEFieldTypeCodeListModel");
    }
}

