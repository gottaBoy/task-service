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

@CodeList(id="20cd77ba8fdcb30c8424e5e2246383ca", name="\u6570\u636e\u540c\u6b65\u8f93\u51fa\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="1", text="\u5b9e\u65f6", realtext="\u5b9e\u65f6"), @CodeItem(value="2", text="\u5b9a\u65f6", realtext="\u5b9a\u65f6")})
public class DataSyncOutModeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer REALTIME = 1;
    public static final int INT_REALTIME = 1;
    public static final Integer TIMER = 2;
    public static final int INT_TIMER = 2;

    public DataSyncOutModeCodeListModel() {
        this.initAnnotation(DataSyncOutModeCodeListModel.class);
        this.setUserData("IGNOREMODELDSL2");
        this.setUserData2("DataSyncOutMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DataSyncOutModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DataSyncOutModeCodeListModel");
    }
}

