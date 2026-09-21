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

@CodeList(id="A62CA54F-3B94-4C2E-BFB6-6E622749A308", name="\u5e73\u53f0\u5361\u7247\u89c6\u56fe\u9879\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="DATAITEM", text="\u6570\u636e\u9879", realtext="\u6570\u636e\u9879", userdata="\u5e38\u89c4\u7684\u6570\u636e\u9879"), @CodeItem(value="ACTIONITEM", text="\u64cd\u4f5c\u9879", realtext="\u64cd\u4f5c\u9879", userdata="\u5361\u7247\u4e2d\u7684\u64cd\u4f5c\u680f")})
public class DataViewItemTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String DATAITEM = "DATAITEM";
    public static final String ACTIONITEM = "ACTIONITEM";

    public DataViewItemTypeCodeListModel() {
        this.initAnnotation(DataViewItemTypeCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DataViewItemTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DataViewItemTypeCodeListModel");
    }
}

