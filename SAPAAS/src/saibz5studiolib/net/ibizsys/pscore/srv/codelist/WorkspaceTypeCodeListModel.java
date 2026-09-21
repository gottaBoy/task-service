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

@CodeList(id="3031d308d1b32528f042010338dcc740", name="\u5e73\u53f0\u751f\u4ea7\u7ebf\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="C_A", text="\u793e\u533a\uff08A\u7c7b\uff09", realtext="\u793e\u533a\uff08A\u7c7b\uff09"), @CodeItem(value="T1_A", text="\u5206\u65f6\uff08A\u7c7b\uff09", realtext="\u5206\u65f6\uff08A\u7c7b\uff09"), @CodeItem(value="B_A", text="B\u7aef\uff08A\u7c7b\uff09", realtext="B\u7aef\uff08A\u7c7b\uff09"), @CodeItem(value="DEMO", text="\u6f14\u793a", realtext="\u6f14\u793a"), @CodeItem(value="CLOUD", text="Cloud", realtext="Cloud")})
public class WorkspaceTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String C_A = "C_A";
    public static final String T1_A = "T1_A";
    public static final String B_A = "B_A";
    public static final String DEMO = "DEMO";
    public static final String CLOUD = "CLOUD";

    public WorkspaceTypeCodeListModel() {
        this.initAnnotation(WorkspaceTypeCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.WorkspaceTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.WorkspaceTypeCodeListModel");
    }
}

