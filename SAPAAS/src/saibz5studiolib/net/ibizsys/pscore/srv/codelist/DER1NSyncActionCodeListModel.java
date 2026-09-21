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

@CodeList(id="2fe7b367716aaf3cd9396416e2462a9e", name="\u5b9e\u4f53\u5173\u7cfb\u5b50\u6570\u636e\u540c\u6b65\u64cd\u4f5c", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="1", text="\u6570\u636e\u540c\u6b65", realtext="\u6570\u636e\u540c\u6b65"), @CodeItem(value="2", text="\u6570\u636e\u91cd\u7f6e", realtext="\u6570\u636e\u91cd\u7f6e")})
public class DER1NSyncActionCodeListModel
extends StaticCodeListModelBase {
    public static final Integer SYNC = 1;
    public static final int INT_SYNC = 1;
    public static final Integer RESET = 2;
    public static final int INT_RESET = 2;

    public DER1NSyncActionCodeListModel() {
        this.initAnnotation(DER1NSyncActionCodeListModel.class);
        this.setUserData2("DERDataSyncAction");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DER1NSyncActionCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DER1NSyncActionCodeListModel");
    }
}

