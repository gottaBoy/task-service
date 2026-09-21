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

@CodeList(id="2419293d48497594aa470623762e7b26", name="\u9762\u677f\u6570\u636e\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="0", text="\u4e0d\u83b7\u53d6\uff08\u4f7f\u7528\u4f20\u5165\u6570\u636e\uff09", realtext="\u4e0d\u83b7\u53d6\uff08\u4f7f\u7528\u4f20\u5165\u6570\u636e\uff09"), @CodeItem(value="1", text="\u672a\u4f20\u5165\u65f6\u83b7\u53d6", realtext="\u672a\u4f20\u5165\u65f6\u83b7\u53d6"), @CodeItem(value="2", text="\u59cb\u7ec8\u83b7\u53d6", realtext="\u59cb\u7ec8\u83b7\u53d6"), @CodeItem(value="3", text="\u7ed1\u5b9a\u5230\u5e94\u7528\u5168\u5c40\u53d8\u91cf", realtext="\u7ed1\u5b9a\u5230\u5e94\u7528\u5168\u5c40\u53d8\u91cf", userdata="\u7ed1\u5b9a\u5230\u5e94\u7528\u5168\u5c40\u5171\u4eab\u53d8\u91cf"), @CodeItem(value="4", text="\u7ed1\u5b9a\u5230\u8def\u7531\u89c6\u56fe\u4f1a\u8bdd\u53d8\u91cf", realtext="\u7ed1\u5b9a\u5230\u8def\u7531\u89c6\u56fe\u4f1a\u8bdd\u53d8\u91cf", userdata="\u7ed1\u5b9a\u5f53\u524d\u9876\u7ea7\u89c6\u56fe\uff08\u8def\u7531\u6216\u5f39\u7a97\u6a21\u5f0f\uff09\u7684\u4f1a\u8bdd\u5171\u4eab\u53d8\u91cf"), @CodeItem(value="5", text="\u7ed1\u5b9a\u5230\u5f53\u524d\u89c6\u56fe\u4f1a\u8bdd\u53d8\u91cf", realtext="\u7ed1\u5b9a\u5230\u5f53\u524d\u89c6\u56fe\u4f1a\u8bdd\u53d8\u91cf", userdata="\u7ed1\u5b9a\u5f53\u524d\u89c6\u56fe\uff08\u4ec5\u5728\u5f53\u524d\u89c6\u56fe\u8303\u56f4\uff09\u7684\u4f1a\u8bdd\u5171\u4eab\u53d8\u91cf")})
public class PanelGetDataModeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer INPUTDATA = 0;
    public static final int INT_INPUTDATA = 0;
    public static final Integer NOINPUTDATA = 1;
    public static final int INT_NOINPUTDATA = 1;
    public static final Integer ALWAYS = 2;
    public static final int INT_ALWAYS = 2;
    public static final Integer APPGLOBALPARAM = 3;
    public static final int INT_APPGLOBALPARAM = 3;
    public static final Integer ROUTEVIEWSESSIONPARAM = 4;
    public static final int INT_ROUTEVIEWSESSIONPARAM = 4;
    public static final Integer VIEWSESSIONPARAM = 5;
    public static final int INT_VIEWSESSIONPARAM = 5;

    public PanelGetDataModeCodeListModel() {
        this.initAnnotation(PanelGetDataModeCodeListModel.class);
        this.setUserData2("PanelGetDataMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.PanelGetDataModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.PanelGetDataModeCodeListModel");
    }
}

