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

@CodeList(id="e72d12c134972d883a13cc86ef6c9129", name="\u4e91\u5e94\u7528\u4e2d\u5fc3\u5e73\u53f0\u4ea7\u54c1\u95ee\u9898\u72b6\u6001", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="10", text="\u672a\u786e\u8ba4", realtext="\u672a\u786e\u8ba4"), @CodeItem(value="20", text="\u5df2\u786e\u8ba4", realtext="\u5df2\u786e\u8ba4"), @CodeItem(value="30", text="\u5df2\u786e\u8ba4\uff08\u53d6\u6d88\uff09", realtext="\u5df2\u786e\u8ba4\uff08\u53d6\u6d88\uff09")})
public class DCPSCorePrdIssueStateCodeListModel
extends StaticCodeListModelBase {
    public static final String ITEM_10 = "10";
    public static final String ITEM_20 = "20";
    public static final String ITEM_30 = "30";

    public DCPSCorePrdIssueStateCodeListModel() {
        this.initAnnotation(DCPSCorePrdIssueStateCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DCPSCorePrdIssueStateCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DCPSCorePrdIssueStateCodeListModel");
    }
}

