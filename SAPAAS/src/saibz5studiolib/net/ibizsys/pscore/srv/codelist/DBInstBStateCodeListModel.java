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

@CodeList(id="d429cb34022dc26089c019aaeba68ce7", name="\u6570\u636e\u5e93\u5b9e\u4f8b\u5907\u4efd\u72b6\u6001", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="10", text="\u672a\u521b\u5efa", realtext="\u672a\u521b\u5efa"), @CodeItem(value="20", text="\u521b\u5efa\u4e2d", realtext="\u521b\u5efa\u4e2d"), @CodeItem(value="30", text="\u5df2\u521b\u5efa", realtext="\u5df2\u521b\u5efa"), @CodeItem(value="40", text="\u521b\u5efa\u5931\u8d25", realtext="\u521b\u5efa\u5931\u8d25")})
public class DBInstBStateCodeListModel
extends StaticCodeListModelBase {
    public static final Integer NOTCREATED = 10;
    public static final int INT_NOTCREATED = 10;
    public static final Integer CREATING = 20;
    public static final int INT_CREATING = 20;
    public static final Integer CREATED = 30;
    public static final int INT_CREATED = 30;
    public static final Integer FAILED = 40;
    public static final int INT_FAILED = 40;

    public DBInstBStateCodeListModel() {
        this.initAnnotation(DBInstBStateCodeListModel.class);
        this.setUserData2("DBInstBKState");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DBInstBStateCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DBInstBStateCodeListModel");
    }
}

