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

@CodeList(id="3FE67ABC-F485-49F4-ABF2-558AF1DDFE21", name="\u4e91\u5e73\u53f0\u90e8\u4ef6\u7c7b\u578b\uff08\u9762\u677f\u9879\u652f\u6301\uff09\uff08\u4ec5\u89c6\u56fe\uff09", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="VIEWPANEL", text="\u89c6\u56fe\u9762\u677f", realtext="\u89c6\u56fe\u9762\u677f")})
public class PanelCtrlType2CodeListModel
extends StaticCodeListModelBase {
    public static final String VIEWPANEL = "VIEWPANEL";

    public PanelCtrlType2CodeListModel() {
        this.initAnnotation(PanelCtrlType2CodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.PanelCtrlType2CodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.PanelCtrlType2CodeListModel");
    }
}

