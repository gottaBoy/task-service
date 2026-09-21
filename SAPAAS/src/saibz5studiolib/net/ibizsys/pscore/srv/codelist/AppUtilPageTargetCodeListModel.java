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

@CodeList(id="fddd70f8cac64c0f9ab02447064e34eb", name="\u7cfb\u7edf\u5e94\u7528\u529f\u80fd\u9875\u9762\u76ee\u6807\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="PAGEURL", text="\u9875\u9762\u8def\u5f84", realtext="\u9875\u9762\u8def\u5f84"), @CodeItem(value="APPVIEW", text="\u5e94\u7528\u89c6\u56fe", realtext="\u5e94\u7528\u89c6\u56fe"), @CodeItem(value="LAYOUTPANEL", text="\u5e03\u5c40\u9762\u677f", realtext="\u5e03\u5c40\u9762\u677f")})
public class AppUtilPageTargetCodeListModel
extends StaticCodeListModelBase {
    public static final String PAGEURL = "PAGEURL";
    public static final String APPVIEW = "APPVIEW";
    public static final String LAYOUTPANEL = "LAYOUTPANEL";

    public AppUtilPageTargetCodeListModel() {
        this.initAnnotation(AppUtilPageTargetCodeListModel.class);
        this.setUserData2("AppUtilPageTargetType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.AppUtilPageTargetCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.AppUtilPageTargetCodeListModel");
    }
}

