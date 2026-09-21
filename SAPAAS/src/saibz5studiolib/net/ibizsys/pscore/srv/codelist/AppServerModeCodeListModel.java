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

@CodeList(id="e53d409ad22d77f923513caed77e9364", name="\u4e91\u5e94\u7528\u4e2d\u5fc3\u5e94\u7528\u670d\u52a1\u5668\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="PSAS", text="\u4e91\u5e73\u53f0\u9884\u7f6e", realtext="\u4e91\u5e73\u53f0\u9884\u7f6e"), @CodeItem(value="PSDEVCENTERSERVER", text="\u5e94\u7528\u4e2d\u5fc3\u81ea\u90e8\u7f72", realtext="\u5e94\u7528\u4e2d\u5fc3\u81ea\u90e8\u7f72")})
public class AppServerModeCodeListModel
extends StaticCodeListModelBase {
    public static final String PSAS = "PSAS";
    public static final String PSDEVCENTERSERVER = "PSDEVCENTERSERVER";

    public AppServerModeCodeListModel() {
        this.initAnnotation(AppServerModeCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.AppServerModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.AppServerModeCodeListModel");
    }
}

