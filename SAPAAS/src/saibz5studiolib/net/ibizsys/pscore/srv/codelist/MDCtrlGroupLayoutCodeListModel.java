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

@CodeList(id="8019416b963d9960ba3ab016f620d6e2", name="\u591a\u6570\u636e\u90e8\u4ef6\u5206\u7ec4\u65b9\u5411", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="ROW", text="\u4ece\u5de6\u5f80\u53f3", realtext="\u4ece\u5de6\u5f80\u53f3"), @CodeItem(value="COLUMN", text="\u4ece\u4e0a\u5f80\u4e0b", realtext="\u4ece\u4e0a\u5f80\u4e0b")})
public class MDCtrlGroupLayoutCodeListModel
extends StaticCodeListModelBase {
    public static final String ROW = "ROW";
    public static final String COLUMN = "COLUMN";

    public MDCtrlGroupLayoutCodeListModel() {
        this.initAnnotation(MDCtrlGroupLayoutCodeListModel.class);
        this.setUserData2("MDCtrlGroupLayout");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.MDCtrlGroupLayoutCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.MDCtrlGroupLayoutCodeListModel");
    }
}

