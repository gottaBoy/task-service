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

@CodeList(id="429E1C7B-DDCD-4899-B4F0-0DBA36C60DCB", name="\u4e91\u5e94\u7528\u89c6\u56fe\u7c7b\u578b\uff08\u542b\u6269\u5c55\u89c6\u56fe\uff09", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="APPDEVIEW", text="\u5e94\u7528\u5b9e\u4f53\u89c6\u56fe", realtext="\u5e94\u7528\u5b9e\u4f53\u89c6\u56fe", iconpath="default/psappview/icon_psappviewtype_appdeview.png", iconpathx="default/psappview/icon_psappviewtype_appdeview@{0}x.png"), @CodeItem(value="APPINDEXVIEW", text="\u5e94\u7528\u9996\u9875\u89c6\u56fe", realtext="\u5e94\u7528\u9996\u9875\u89c6\u56fe", iconpath="default/psappview/icon_psappviewtype_appindexview.png", iconpathx="default/psappview/icon_psappviewtype_appindexview@{0}x.png"), @CodeItem(value="APPPORTALVIEW", text="\u5e94\u7528\u6570\u636e\u770b\u677f\u89c6\u56fe", realtext="\u5e94\u7528\u6570\u636e\u770b\u677f\u89c6\u56fe", iconpath="default/psappview/icon_psappviewtype_appportalview.png", iconpathx="default/psappview/icon_psappviewtype_appportalview@{0}x.png"), @CodeItem(value="APPDYNADEVIEW", text="\u5e94\u7528\u52a8\u6001\u5b9e\u4f53\u89c6\u56fe", realtext="\u5e94\u7528\u52a8\u6001\u5b9e\u4f53\u89c6\u56fe", iconpath="appviewtype2/icon_appdynadeview.png", iconpathx="appviewtype2/icon_appdynadeview@{0}x.png"), @CodeItem(value="APPUTILVIEW", text="\u5e94\u7528\u529f\u80fd\u89c6\u56fe", realtext="\u5e94\u7528\u529f\u80fd\u89c6\u56fe", iconpath="appviewtype2/icon_apputilview.png", iconpathx="appviewtype2/icon_apputilview@{0}x.png"), @CodeItem(value="APPPANELVIEW", text="\u5e94\u7528\u9762\u677f\u89c6\u56fe", realtext="\u5e94\u7528\u9762\u677f\u89c6\u56fe", iconpath="appviewtype2/icon_apppanelview.png", iconpathx="appviewtype2/icon_apppanelview@{0}x.png")})
public class AppViewType2CodeListModel
extends StaticCodeListModelBase {
    public static final String APPDEVIEW = "APPDEVIEW";
    public static final String APPINDEXVIEW = "APPINDEXVIEW";
    public static final String APPPORTALVIEW = "APPPORTALVIEW";
    public static final String APPDYNADEVIEW = "APPDYNADEVIEW";
    public static final String APPUTILVIEW = "APPUTILVIEW";
    public static final String APPPANELVIEW = "APPPANELVIEW";

    public AppViewType2CodeListModel() {
        this.initAnnotation(AppViewType2CodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.AppViewType2CodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.AppViewType2CodeListModel");
    }
}

