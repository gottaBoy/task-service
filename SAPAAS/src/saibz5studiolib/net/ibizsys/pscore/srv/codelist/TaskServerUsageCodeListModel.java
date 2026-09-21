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

@CodeList(id="645c7a5a4b1e03b7272e843c53bed275", name="\u670d\u52a1\u5668\u7528\u9014", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="SYSPUB", text="\u7cfb\u7edf\u53d1\u5e03", realtext="\u7cfb\u7edf\u53d1\u5e03"), @CodeItem(value="SYSJIT", text="\u7cfb\u7edfJIT", realtext="\u7cfb\u7edfJIT"), @CodeItem(value="TEMPLDEV", text="\u6a21\u677f\u5f00\u53d1", realtext="\u6a21\u677f\u5f00\u53d1"), @CodeItem(value="INTERNAL", text="\u5185\u90e8\u5f00\u53d1\u8c03\u8bd5", realtext="\u5185\u90e8\u5f00\u53d1\u8c03\u8bd5")})
public class TaskServerUsageCodeListModel
extends StaticCodeListModelBase {
    public static final String SYSPUB = "SYSPUB";
    public static final String SYSJIT = "SYSJIT";
    public static final String TEMPLDEV = "TEMPLDEV";
    public static final String INTERNAL = "INTERNAL";

    public TaskServerUsageCodeListModel() {
        this.initAnnotation(TaskServerUsageCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.TaskServerUsageCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.TaskServerUsageCodeListModel");
    }
}

