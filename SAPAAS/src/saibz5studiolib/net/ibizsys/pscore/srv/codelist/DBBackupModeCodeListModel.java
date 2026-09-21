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

@CodeList(id="b12513b50096554ccbcd75801961c5fb", name="\u6570\u636e\u5e93\u5907\u4efd\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="10", text="\u5b8c\u6574\u5907\u4efd", realtext="\u5b8c\u6574\u5907\u4efd"), @CodeItem(value="20", text="\u589e\u91cf\u5907\u4efd", realtext="\u589e\u91cf\u5907\u4efd")})
public class DBBackupModeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer FULL = 10;
    public static final int INT_FULL = 10;
    public static final Integer INCREASE = 20;
    public static final int INT_INCREASE = 20;

    public DBBackupModeCodeListModel() {
        this.initAnnotation(DBBackupModeCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DBBackupModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DBBackupModeCodeListModel");
    }
}

