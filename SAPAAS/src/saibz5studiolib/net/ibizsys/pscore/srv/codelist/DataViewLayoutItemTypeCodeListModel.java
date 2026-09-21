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

@CodeList(id="6D00466A-2684-4F5A-A2BE-DCB00FEAC67E", name="\u5361\u7247\u89c6\u56fe\u5e03\u5c40\u9879\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="PANEL", text="\u9762\u677f", realtext="\u9762\u677f"), @CodeItem(value="FORM", text="\u8868\u5355", realtext="\u8868\u5355")})
public class DataViewLayoutItemTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String PANEL = "PANEL";
    public static final String FORM = "FORM";

    public DataViewLayoutItemTypeCodeListModel() {
        this.initAnnotation(DataViewLayoutItemTypeCodeListModel.class);
        this.setUserData2("DataViewLayoutItemType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DataViewLayoutItemTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DataViewLayoutItemTypeCodeListModel");
    }
}

