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

@CodeList(id="DF4485DB-CF19-4B89-97F6-6B3389308AAD", name="\u5bfc\u822a\u680f\u4f4d\u7f6e", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="LEFT", text="\u5de6\u4fa7\uff08\u9ed8\u8ba4\uff09", realtext="\u5de6\u4fa7\uff08\u9ed8\u8ba4\uff09"), @CodeItem(value="TOP", text="\u4e0a\u65b9", realtext="\u4e0a\u65b9")})
public class ExpBarPosCodeListModel
extends StaticCodeListModelBase {
    public static final String LEFT = "LEFT";
    public static final String TOP = "TOP";

    public ExpBarPosCodeListModel() {
        this.initAnnotation(ExpBarPosCodeListModel.class);
        this.setUserData2("ExpBarPos");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.ExpBarPosCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.ExpBarPosCodeListModel");
    }
}

