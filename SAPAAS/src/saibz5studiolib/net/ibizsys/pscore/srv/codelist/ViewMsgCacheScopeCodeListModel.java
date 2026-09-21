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

@CodeList(id="01b4266c4f377eb93f58cfe913e75938", name="\u89c6\u56fe\u6d88\u606f\u7f13\u5b58\u8303\u56f4", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="GLOBAL", text="\u5168\u5c40", realtext="\u5168\u5c40")})
public class ViewMsgCacheScopeCodeListModel
extends StaticCodeListModelBase {
    public static final String GLOBAL = "GLOBAL";

    public ViewMsgCacheScopeCodeListModel() {
        this.initAnnotation(ViewMsgCacheScopeCodeListModel.class);
        this.setUserData2("ViewMsgCacheScope");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.ViewMsgCacheScopeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.ViewMsgCacheScopeCodeListModel");
    }
}

