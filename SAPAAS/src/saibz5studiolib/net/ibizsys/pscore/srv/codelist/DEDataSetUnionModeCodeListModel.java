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

@CodeList(id="A9B3721B-04B8-4907-B9BD-2E1825F20EA3", name="\u5b9e\u4f53\u6570\u636e\u96c6\u8fde\u63a5\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="UNION", text="\u6392\u91cd\u8fde\u63a5", realtext="\u6392\u91cd\u8fde\u63a5"), @CodeItem(value="UNIONALL", text="\u5168\u90e8\u8fde\u63a5", realtext="\u5168\u90e8\u8fde\u63a5")})
public class DEDataSetUnionModeCodeListModel
extends StaticCodeListModelBase {
    public static final String UNION = "UNION";
    public static final String UNIONALL = "UNIONALL";

    public DEDataSetUnionModeCodeListModel() {
        this.initAnnotation(DEDataSetUnionModeCodeListModel.class);
        this.setUserData2("DEDataSetUnionMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEDataSetUnionModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEDataSetUnionModeCodeListModel");
    }
}

