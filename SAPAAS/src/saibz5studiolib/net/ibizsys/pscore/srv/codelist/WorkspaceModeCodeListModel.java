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

@CodeList(id="2e80ee289473c8e64b43018c9e7f778b", name="\u5e73\u53f0\u751f\u4ea7\u7ebf\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="B", text="B\u7aef", realtext="B\u7aef"), @CodeItem(value="C", text="C\u7aef", realtext="C\u7aef"), @CodeItem(value="T1", text="\u8ba1\u65f6\u6a21\u5f0f\uff08\u9884\u4ed8\uff09", realtext="\u8ba1\u65f6\u6a21\u5f0f\uff08\u9884\u4ed8\uff09")})
public class WorkspaceModeCodeListModel
extends StaticCodeListModelBase {
    public static final String B = "B";
    public static final String C = "C";
    public static final String T1 = "T1";

    public WorkspaceModeCodeListModel() {
        this.initAnnotation(WorkspaceModeCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.WorkspaceModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.WorkspaceModeCodeListModel");
    }
}

