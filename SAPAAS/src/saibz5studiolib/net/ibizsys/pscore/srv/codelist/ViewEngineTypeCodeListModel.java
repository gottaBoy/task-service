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

@CodeList(id="98e7131af743ba164dd1eba0e5c0a6df", name="\u89c6\u56fe\u5f15\u64ce\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="VIEW", text="\u89c6\u56fe\u5bf9\u8c61", realtext="\u89c6\u56fe\u5bf9\u8c61"), @CodeItem(value="PLUGIN", text="\u89c6\u56fe\u63d2\u4ef6", realtext="\u89c6\u56fe\u63d2\u4ef6")})
public class ViewEngineTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String VIEW = "VIEW";
    public static final String PLUGIN = "PLUGIN";

    public ViewEngineTypeCodeListModel() {
        this.initAnnotation(ViewEngineTypeCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.ViewEngineTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.ViewEngineTypeCodeListModel");
    }
}

