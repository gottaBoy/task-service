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

@CodeList(id="0356B745-3878-4499-B45C-3C298672FB1F", name="\u5e94\u7528\u83dc\u5355\u6309\u94ae\u884c\u4e3a\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="NONE", text="\u65e0\u5904\u7406", realtext="\u65e0\u5904\u7406"), @CodeItem(value="APPFUNC", text="\u5e94\u7528\u529f\u80fd", realtext="\u5e94\u7528\u529f\u80fd", userdata="\u6309\u94ae\u70b9\u51fb\u5e94\u7528\u529f\u80fd\u5904\u7406"), @CodeItem(value="UIACTION", text="\u754c\u9762\u884c\u4e3a", realtext="\u754c\u9762\u884c\u4e3a", userdata="\u6309\u94ae\u70b9\u51fb\u89e6\u53d1\u754c\u9762\u884c\u4e3a\u5904\u7406"), @CodeItem(value="UILOGIC", text="\u754c\u9762\u903b\u8f91", realtext="\u754c\u9762\u903b\u8f91"), @CodeItem(value="OPENVIEW", text="\u6253\u5f00\u5e94\u7528\u89c6\u56fe", realtext="\u6253\u5f00\u5e94\u7528\u89c6\u56fe"), @CodeItem(value="OPENHTMLPAGE", text="\u6253\u5f00\u94fe\u63a5", realtext="\u6253\u5f00\u94fe\u63a5"), @CodeItem(value="APP_LOGOUT", text="\u767b\u51fa\u64cd\u4f5c", realtext="\u767b\u51fa\u64cd\u4f5c"), @CodeItem(value="CUSTOM", text="\u81ea\u5b9a\u4e49\u4ee3\u7801", realtext="\u81ea\u5b9a\u4e49\u4ee3\u7801")})
public class AppMenuButtonActionTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String NONE = "NONE";
    public static final String APPFUNC = "APPFUNC";
    public static final String UIACTION = "UIACTION";
    public static final String UILOGIC = "UILOGIC";
    public static final String OPENVIEW = "OPENVIEW";
    public static final String OPENHTMLPAGE = "OPENHTMLPAGE";
    public static final String APP_LOGOUT = "APP_LOGOUT";
    public static final String CUSTOM = "CUSTOM";

    public AppMenuButtonActionTypeCodeListModel() {
        this.initAnnotation(AppMenuButtonActionTypeCodeListModel.class);
        this.setUserData2("AppMenuButtonActionType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.AppMenuButtonActionTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.AppMenuButtonActionTypeCodeListModel");
    }
}

