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

@CodeList(id="16b4de5d9a7364b57659e080ab0eac08", name="\u4e91\u7cfb\u7edf\u95ee\u9898\u72b6\u6001", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="CREATED", text="\u5df2\u5efa\u7acb", realtext="\u5df2\u5efa\u7acb"), @CodeItem(value="SOLVED", text="\u5df2\u89e3\u51b3", realtext="\u5df2\u89e3\u51b3"), @CodeItem(value="CANCELLED", text="\u5df2\u53d6\u6d88", realtext="\u5df2\u53d6\u6d88")})
public class SysIssueStateCodeListModel
extends StaticCodeListModelBase {
    public static final String CREATED = "CREATED";
    public static final String SOLVED = "SOLVED";
    public static final String CANCELLED = "CANCELLED";

    public SysIssueStateCodeListModel() {
        this.initAnnotation(SysIssueStateCodeListModel.class);
        this.setUserData2("SysIssueState");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.SysIssueStateCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.SysIssueStateCodeListModel");
    }
}

