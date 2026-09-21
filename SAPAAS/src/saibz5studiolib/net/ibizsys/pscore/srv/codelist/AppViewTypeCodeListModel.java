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

@CodeList(id="634300e473c9ac2b3479f2a8df4c5b9a", name="\u4e91\u5e94\u7528\u89c6\u56fe\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="APPINDEXVIEW", text="\u5e94\u7528\u9996\u9875\u89c6\u56fe", realtext="\u5e94\u7528\u9996\u9875\u89c6\u56fe", iconpath="default/psappview/icon_psappviewtype_appindexview.png", iconpathx="default/psappview/icon_psappviewtype_appindexview@{0}x.png"), @CodeItem(value="APPPORTALVIEW", text="\u5e94\u7528\u6570\u636e\u770b\u677f\u89c6\u56fe", realtext="\u5e94\u7528\u6570\u636e\u770b\u677f\u89c6\u56fe", iconpath="default/psappview/icon_psappviewtype_appportalview.png", iconpathx="default/psappview/icon_psappviewtype_appportalview@{0}x.png"), @CodeItem(value="APPUTILVIEW", text="\u5e94\u7528\u529f\u80fd\u89c6\u56fe", realtext="\u5e94\u7528\u529f\u80fd\u89c6\u56fe", iconpath="appviewtype/icon_apputilpage.png", iconpathx="appviewtype/icon_apputilpage@{0}x.png"), @CodeItem(value="APPPANELVIEW", text="\u5e94\u7528\u9762\u677f\u89c6\u56fe", realtext="\u5e94\u7528\u9762\u677f\u89c6\u56fe", iconpath="appviewtype/icon_apppanelview.png", iconpathx="appviewtype/icon_apppanelview@{0}x.png"), @CodeItem(value="APPDEVIEW", text="\u5e94\u7528\u5b9e\u4f53\u89c6\u56fe", realtext="\u5e94\u7528\u5b9e\u4f53\u89c6\u56fe", iconpath="default/psappview/icon_psappviewtype_appdeview.png", iconpathx="default/psappview/icon_psappviewtype_appdeview@{0}x.png", userdata="\u5b9e\u4f53\u89c6\u56fe\u6a21\u578b\u662f\u5e94\u7528\u65e0\u5173\u6027\uff0c\u9700\u8981\u6dfb\u52a0\u5230\u5e94\u7528\u5f62\u6210\u5e94\u7528\u89c6\u56fe\u624d\u80fd\u786e\u8ba4\u5b9e\u73b0\u6280\u672f\uff0c\u5e76\u8fdb\u4e00\u6b65\u7ec6\u5316\u903b\u8f91")})
public class AppViewTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String APPINDEXVIEW = "APPINDEXVIEW";
    public static final String APPPORTALVIEW = "APPPORTALVIEW";
    public static final String APPUTILVIEW = "APPUTILVIEW";
    public static final String APPPANELVIEW = "APPPANELVIEW";
    public static final String APPDEVIEW = "APPDEVIEW";

    public AppViewTypeCodeListModel() {
        this.initAnnotation(AppViewTypeCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.AppViewTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.AppViewTypeCodeListModel");
    }
}

