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

@CodeList(id="2f11c09b51535e0abf044de0ab543f7d", name="\u5e94\u7528\u529f\u80fd\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="APPVIEW", text="\u6253\u5f00\u5e94\u7528\u89c6\u56fe", realtext="\u6253\u5f00\u5e94\u7528\u89c6\u56fe", iconpath="appfunctype/icon_appview.png", iconpathx="appfunctype/icon_appview@{0}x.png"), @CodeItem(value="OPENHTMLPAGE", text="\u6253\u5f00HTML\u9875\u9762", realtext="\u6253\u5f00HTML\u9875\u9762", iconpath="appfunctype/icon_openhtmlpage.png", iconpathx="appfunctype/icon_openhtmlpage@{0}x.png"), @CodeItem(value="PDTAPPFUNC", text="\u9884\u7f6e\u5e94\u7528\u529f\u80fd", realtext="\u9884\u7f6e\u5e94\u7528\u529f\u80fd", iconpath="appfunctype/icon_pdtappfunc.png", iconpathx="appfunctype/icon_pdtappfunc@{0}x.png"), @CodeItem(value="UIACTION", text="\u754c\u9762\u884c\u4e3a", realtext="\u754c\u9762\u884c\u4e3a"), @CodeItem(value="JAVASCRIPT", text="\u6267\u884cJavaScript", realtext="\u6267\u884cJavaScript", iconpath="appfunctype/icon_javascript.png", iconpathx="appfunctype/icon_javascript@{0}x.png"), @CodeItem(value="SEARCH", text="\u5168\u5c40\u641c\u7d22", realtext="\u5168\u5c40\u641c\u7d22"), @CodeItem(value="CUSTOM", text="\u81ea\u5b9a\u4e49", realtext="\u81ea\u5b9a\u4e49", iconpath="appfunctype/icon_custom.png", iconpathx="appfunctype/icon_custom@{0}x.png")})
public class AppFuncTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String APPVIEW = "APPVIEW";
    public static final String OPENHTMLPAGE = "OPENHTMLPAGE";
    public static final String PDTAPPFUNC = "PDTAPPFUNC";
    public static final String UIACTION = "UIACTION";
    public static final String JAVASCRIPT = "JAVASCRIPT";
    public static final String SEARCH = "SEARCH";
    public static final String CUSTOM = "CUSTOM";

    public AppFuncTypeCodeListModel() {
        this.initAnnotation(AppFuncTypeCodeListModel.class);
        this.setUserData2("AppFuncType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.AppFuncTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.AppFuncTypeCodeListModel");
    }
}

