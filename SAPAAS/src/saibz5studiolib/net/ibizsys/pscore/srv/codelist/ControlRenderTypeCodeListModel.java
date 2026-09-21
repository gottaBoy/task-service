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

@CodeList(id="0AB77ED8-327A-45FB-B7A9-4CEE7E08A300", name="\u90e8\u4ef6\u7ed8\u5236\u5668\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="LAYOUTPANEL", text="\u5e03\u5c40\u9762\u677f", realtext="\u5e03\u5c40\u9762\u677f"), @CodeItem(value="LAYOUTPANEL_MODEL", text="\u5e03\u5c40\u9762\u677f\uff08\u6a21\u578b\uff09", realtext="\u5e03\u5c40\u9762\u677f\uff08\u6a21\u578b\uff09"), @CodeItem(value="PFPLUGIN", text="\u524d\u7aef\u63d2\u4ef6", realtext="\u524d\u7aef\u63d2\u4ef6")})
public class ControlRenderTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String LAYOUTPANEL = "LAYOUTPANEL";
    public static final String LAYOUTPANEL_MODEL = "LAYOUTPANEL_MODEL";
    public static final String PFPLUGIN = "PFPLUGIN";

    public ControlRenderTypeCodeListModel() {
        this.initAnnotation(ControlRenderTypeCodeListModel.class);
        this.setUserData2("ControlRenderType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.ControlRenderTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.ControlRenderTypeCodeListModel");
    }
}

