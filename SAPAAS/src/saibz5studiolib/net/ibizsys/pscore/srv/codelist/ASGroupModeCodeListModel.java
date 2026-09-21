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

@CodeList(id="63cfe891b7020bbbb9cdd149473958f5", name="\u90e8\u7f72\u65b9\u6848\u5e94\u7528\u5bb9\u5668\u7ec4", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="RR", text="\u8f6e\u8be2", realtext="\u8f6e\u8be2"), @CodeItem(value="ip_hash", text="\u6309\u5730\u5740\u8f6c\u53d1", realtext="\u6309\u5730\u5740\u8f6c\u53d1")})
public class ASGroupModeCodeListModel
extends StaticCodeListModelBase {
    public static final String RR = "RR";
    public static final String IP_HASH = "ip_hash";

    public ASGroupModeCodeListModel() {
        this.initAnnotation(ASGroupModeCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.ASGroupModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.ASGroupModeCodeListModel");
    }
}

