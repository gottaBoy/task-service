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

@CodeList(id="5b1d1ebf609451508a7eac283ba690e5", name="\u89c6\u56fe\u9762\u677f\u5e03\u5c40\u5206\u7c7b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="VIEW", text="\u89c6\u56fe\u5e03\u5c40", realtext="\u89c6\u56fe\u5e03\u5c40"), @CodeItem(value="DATAITEM", text="\u6570\u636e\u9879\u5e03\u5c40", realtext="\u6570\u636e\u9879\u5e03\u5c40")})
public class PanelLayoutCatCodeListModel
extends StaticCodeListModelBase {
    public static final String VIEW = "VIEW";
    public static final String DATAITEM = "DATAITEM";

    public PanelLayoutCatCodeListModel() {
        this.initAnnotation(PanelLayoutCatCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.PanelLayoutCatCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.PanelLayoutCatCodeListModel");
    }
}

