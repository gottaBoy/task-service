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

@CodeList(id="2e2fbcb172d4ea85d7df101a8913f4b3", name="\u5de5\u5177\u680f\u6837\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="TOOLBAR", text="\u5de5\u5177\u680f", realtext="\u5de5\u5177\u680f"), @CodeItem(value="MENU", text="\u83dc\u5355", realtext="\u83dc\u5355"), @CodeItem(value="CONTEXTMENU", text="\u4e0a\u4e0b\u6587\u83dc\u5355", realtext="\u4e0a\u4e0b\u6587\u83dc\u5355"), @CodeItem(value="MOBNAVLEFTMENU", text="\u79fb\u52a8\u7aef\u5bfc\u822a\u680f\u5de6\u4fa7\u83dc\u5355", realtext="\u79fb\u52a8\u7aef\u5bfc\u822a\u680f\u5de6\u4fa7\u83dc\u5355"), @CodeItem(value="MOBNAVRIGHTMENU", text="\u79fb\u52a8\u7aef\u5bfc\u822a\u680f\u53f3\u4fa7\u83dc\u5355", realtext="\u79fb\u52a8\u7aef\u5bfc\u822a\u680f\u53f3\u4fa7\u83dc\u5355"), @CodeItem(value="MOBWFACTIONMENU", text="\u79fb\u52a8\u7aef\u6d41\u7a0b\u64cd\u4f5c\u83dc\u5355", realtext="\u79fb\u52a8\u7aef\u6d41\u7a0b\u64cd\u4f5c\u83dc\u5355"), @CodeItem(value="MOBBOTTOMMENU", text="\u79fb\u52a8\u7aef\u89c6\u56fe\u4e0b\u65b9\u83dc\u5355", realtext="\u79fb\u52a8\u7aef\u89c6\u56fe\u4e0b\u65b9\u83dc\u5355")})
public class DEToolbarStyleCodeListModel
extends StaticCodeListModelBase {
    public static final String TOOLBAR = "TOOLBAR";
    public static final String MENU = "MENU";
    public static final String CONTEXTMENU = "CONTEXTMENU";
    public static final String MOBNAVLEFTMENU = "MOBNAVLEFTMENU";
    public static final String MOBNAVRIGHTMENU = "MOBNAVRIGHTMENU";
    public static final String MOBWFACTIONMENU = "MOBWFACTIONMENU";
    public static final String MOBBOTTOMMENU = "MOBBOTTOMMENU";

    public DEToolbarStyleCodeListModel() {
        this.initAnnotation(DEToolbarStyleCodeListModel.class);
        this.setUserData2("ToolbarStyle");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEToolbarStyleCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEToolbarStyleCodeListModel");
    }
}

