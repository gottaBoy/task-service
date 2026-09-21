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

@CodeList(id="6dcd44466bb1e672f7a4518ca83fa61f", name="\u4e91\u5e73\u53f0\u6838\u5fc3\u4ea7\u54c1\u95ee\u9898\u72b6\u6001", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="20", text="\u5df2\u786e\u8ba4", realtext="\u5df2\u786e\u8ba4"), @CodeItem(value="30", text="\u5df2\u89e3\u51b3", realtext="\u5df2\u89e3\u51b3"), @CodeItem(value="40", text="\u5df2\u53d6\u6d88", realtext="\u5df2\u53d6\u6d88")})
public class PSCorePrdIssueStateCodeListModel
extends StaticCodeListModelBase {
    public static final String ITEM_20 = "20";
    public static final String ITEM_30 = "30";
    public static final String ITEM_40 = "40";

    public PSCorePrdIssueStateCodeListModel() {
        this.initAnnotation(PSCorePrdIssueStateCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.PSCorePrdIssueStateCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.PSCorePrdIssueStateCodeListModel");
    }
}

