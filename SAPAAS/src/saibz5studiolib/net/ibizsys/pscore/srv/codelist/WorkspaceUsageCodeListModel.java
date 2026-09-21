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

@CodeList(id="29b93839bb06657cafb487b0355339cf", name="\u5e73\u53f0\u751f\u4ea7\u7ebf\u7528\u9014", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="DEMO", text="\u6f14\u793a", realtext="\u6f14\u793a"), @CodeItem(value="DEVTEMPL", text="\u6a21\u677f\u5f00\u53d1", realtext="\u6a21\u677f\u5f00\u53d1"), @CodeItem(value="DEVSYS", text="\u7cfb\u7edf\u5f00\u53d1", realtext="\u7cfb\u7edf\u5f00\u53d1"), @CodeItem(value="CLOUD", text="Cloud\u914d\u7f6e", realtext="Cloud\u914d\u7f6e")})
public class WorkspaceUsageCodeListModel
extends StaticCodeListModelBase {
    public static final String DEMO = "DEMO";
    public static final String DEVTEMPL = "DEVTEMPL";
    public static final String DEVSYS = "DEVSYS";
    public static final String CLOUD = "CLOUD";

    public WorkspaceUsageCodeListModel() {
        this.initAnnotation(WorkspaceUsageCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.WorkspaceUsageCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.WorkspaceUsageCodeListModel");
    }
}

