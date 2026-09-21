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

@CodeList(id="8ADB44E7-BD13-4737-9892-CEF4DF4435DE", name="\u591a\u7f16\u8f91\u89c6\u56fe\u9762\u677f\u6837\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="TAB_TOP", text="\u4e0a\u5206\u9875", realtext="\u4e0a\u5206\u9875"), @CodeItem(value="ROW", text="\u884c\u8bb0\u5f55", realtext="\u884c\u8bb0\u5f55")})
public class MultiEditViewPanelStylesCodeListModel
extends StaticCodeListModelBase {
    public static final String TAB_TOP = "TAB_TOP";
    public static final String ROW = "ROW";

    public MultiEditViewPanelStylesCodeListModel() {
        this.initAnnotation(MultiEditViewPanelStylesCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.MultiEditViewPanelStylesCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.MultiEditViewPanelStylesCodeListModel");
    }
}

