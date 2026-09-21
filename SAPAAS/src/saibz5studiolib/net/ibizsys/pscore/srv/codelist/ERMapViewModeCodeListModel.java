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

@CodeList(id="f31a8afd2ef37779999f74906b483127", name="\u7cfb\u7edfER\u56fe\u89c6\u56fe\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="PV", text="\u7269\u7406\u89c6\u56fe", realtext="\u7269\u7406\u89c6\u56fe"), @CodeItem(value="LV", text="\u903b\u8f91\u89c6\u56fe", realtext="\u903b\u8f91\u89c6\u56fe")})
public class ERMapViewModeCodeListModel
extends StaticCodeListModelBase {
    public static final String PV = "PV";
    public static final String LV = "LV";

    public ERMapViewModeCodeListModel() {
        this.initAnnotation(ERMapViewModeCodeListModel.class);
        this.setUserData2("ERMapViewMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.ERMapViewModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.ERMapViewModeCodeListModel");
    }
}

