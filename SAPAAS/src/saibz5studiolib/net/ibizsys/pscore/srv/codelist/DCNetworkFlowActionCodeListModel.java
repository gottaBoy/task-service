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

@CodeList(id="4f81ab6c82c12162e871a8b75e01f145", name="\u5e94\u7528\u4e2d\u5fc3\u6d41\u91cf\u64cd\u4f5c", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="DEPLOY", text="\u7cfb\u7edf\u90e8\u7f72", realtext="\u7cfb\u7edf\u90e8\u7f72"), @CodeItem(value="DOWNLOAD", text="\u4e0b\u8f7d", realtext="\u4e0b\u8f7d")})
public class DCNetworkFlowActionCodeListModel
extends StaticCodeListModelBase {
    public static final String DEPLOY = "DEPLOY";
    public static final String DOWNLOAD = "DOWNLOAD";

    public DCNetworkFlowActionCodeListModel() {
        this.initAnnotation(DCNetworkFlowActionCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DCNetworkFlowActionCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DCNetworkFlowActionCodeListModel");
    }
}

