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

@CodeList(id="383B38D5-2E17-46D0-8571-FB301E71ED8A", name="\u9762\u677f\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="0", text="\u9762\u677f\u90e8\u4ef6", realtext="\u9762\u677f\u90e8\u4ef6", userdata="\u5e38\u89c4\u9762\u677f\u90e8\u4ef6"), @CodeItem(value="1", text="\u5e03\u5c40\u9762\u677f", realtext="\u5e03\u5c40\u9762\u677f", userdata="\u7528\u4e8e\u5e38\u89c4\u5e03\u5c40\u7684\u5e03\u5c40\u9762\u677f"), @CodeItem(value="2", text="\u5e03\u5c40\u9762\u677f\uff08\u89c6\u56fe\u589e\u5f3a\uff09", realtext="\u5e03\u5c40\u9762\u677f\uff08\u89c6\u56fe\u589e\u5f3a\uff09", userdata="\u7528\u4e8e\u89c6\u56fe\u5e03\u5c40\u7684\u5e03\u5c40\u9762\u677f")})
public class PanelModeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer PANEL = 0;
    public static final int INT_PANEL = 0;
    public static final Integer LAYOUTPANEL = 1;
    public static final int INT_LAYOUTPANEL = 1;
    public static final Integer VIEWLAYOUTPANEL = 2;
    public static final int INT_VIEWLAYOUTPANEL = 2;

    public PanelModeCodeListModel() {
        this.initAnnotation(PanelModeCodeListModel.class);
        this.setUserData2("PanelMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.PanelModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.PanelModeCodeListModel");
    }
}

