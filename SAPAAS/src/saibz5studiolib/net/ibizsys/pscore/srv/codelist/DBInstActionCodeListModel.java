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

@CodeList(id="c64be78d737827ffa15b41cda409c75e", name="\u6570\u636e\u5e93\u5b9e\u4f8b\u5f53\u524d\u4f5c\u4e1a", type="STATIC", userscope=false, emptytext="")
@CodeItems(value={@CodeItem(value="BACKUP", text="\u5907\u4efd\u4e2d", realtext="\u5907\u4efd\u4e2d"), @CodeItem(value="RESTORE", text="\u6062\u590d\u4e2d", realtext="\u6062\u590d\u4e2d")})
public class DBInstActionCodeListModel
extends StaticCodeListModelBase {
    public static final String BACKUP = "BACKUP";
    public static final String RESTORE = "RESTORE";

    public DBInstActionCodeListModel() {
        this.initAnnotation(DBInstActionCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DBInstActionCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DBInstActionCodeListModel");
    }
}

