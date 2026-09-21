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

@CodeList(id="7ea12369d458ff1fc786145b7e5daf22", name="\u4e91\u7cfb\u7edf\u95ee\u9898\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="WARN", text="\u8b66\u544a", realtext="\u8b66\u544a"), @CodeItem(value="ERROR", text="\u9519\u8bef", realtext="\u9519\u8bef"), @CodeItem(value="CRITICAL", text="\u4e25\u91cd\u9519\u8bef", realtext="\u4e25\u91cd\u9519\u8bef")})
public class SysIssueTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String WARN = "WARN";
    public static final String ERROR = "ERROR";
    public static final String CRITICAL = "CRITICAL";

    public SysIssueTypeCodeListModel() {
        this.initAnnotation(SysIssueTypeCodeListModel.class);
        this.setUserData2("SysIssueType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.SysIssueTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.SysIssueTypeCodeListModel");
    }
}

