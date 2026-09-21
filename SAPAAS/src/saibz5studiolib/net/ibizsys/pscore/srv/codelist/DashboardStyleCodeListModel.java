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

@CodeList(id="51300547-32C9-4DB7-B488-D07A225D48FD", name="\u6570\u636e\u770b\u677f\u6837\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="BIREPORTDASHBOARD", text="BI\u62a5\u8868\u6570\u636e\u770b\u677f", realtext="BI\u62a5\u8868\u6570\u636e\u770b\u677f"), @CodeItem(value="BIREPORTDASHBOARD2", text="BI\u62a5\u8868\u6570\u636e\u770b\u677f2", realtext="BI\u62a5\u8868\u6570\u636e\u770b\u677f2"), @CodeItem(value="USER", text="\u7528\u6237\u81ea\u5b9a\u4e49", realtext="\u7528\u6237\u81ea\u5b9a\u4e49"), @CodeItem(value="USER2", text="\u7528\u6237\u81ea\u5b9a\u4e492", realtext="\u7528\u6237\u81ea\u5b9a\u4e492")})
public class DashboardStyleCodeListModel
extends StaticCodeListModelBase {
    public static final String BIREPORTDASHBOARD = "BIREPORTDASHBOARD";
    public static final String BIREPORTDASHBOARD2 = "BIREPORTDASHBOARD2";
    public static final String USER = "USER";
    public static final String USER2 = "USER2";

    public DashboardStyleCodeListModel() {
        this.initAnnotation(DashboardStyleCodeListModel.class);
        this.setUserData2("DashboardStyle");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DashboardStyleCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DashboardStyleCodeListModel");
    }
}

