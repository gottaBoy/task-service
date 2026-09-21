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

@CodeList(id="6CB28D4E-4350-4006-8877-9C90C3D09D8B", name="\u5b9e\u4f53\u6570\u636e\u6d41\u9884\u7f6e\u6570\u636e\u6e90", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="SESSION", text="\u7528\u6237\u5168\u5c40\u5bf9\u8c61", realtext="\u7528\u6237\u5168\u5c40\u5bf9\u8c61"), @CodeItem(value="DATACONTEXT", text="\u6570\u636e\u4e0a\u4e0b\u6587", realtext="\u6570\u636e\u4e0a\u4e0b\u6587"), @CodeItem(value="ENVPARAM", text="\u5f53\u524d\u73af\u5883\u53c2\u6570", realtext="\u5f53\u524d\u73af\u5883\u53c2\u6570")})
public class DEDataFlowPredefinedSourceCodeListModel
extends StaticCodeListModelBase {
    public static final String SESSION = "SESSION";
    public static final String DATACONTEXT = "DATACONTEXT";
    public static final String ENVPARAM = "ENVPARAM";

    public DEDataFlowPredefinedSourceCodeListModel() {
        this.initAnnotation(DEDataFlowPredefinedSourceCodeListModel.class);
        this.setUserData2("DEDataFlowPredefinedSource");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEDataFlowPredefinedSourceCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEDataFlowPredefinedSourceCodeListModel");
    }
}

